package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement st = cn.prepareStatement(
                "insert into items(name) values(?)", Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.execute();
            try (ResultSet genKeys = st.getGeneratedKeys()) {
                if (genKeys.next()) {
                    item.setId(genKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (PreparedStatement st = cn.prepareStatement(
                "update items set name = ? where id = ?")) {
            st.setString(1, item.getName());
            st.setInt(2, id);
            rsl = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (PreparedStatement st = cn.prepareStatement(
                "delete from items where id = ?")) {
            st.setInt(1, id);
            rsl = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement(
                "select * from items")) {
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    rsl.add(new Item(
                       rs.getInt("id"),
                       rs.getString("name")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement(
                "select * from items where name = ?")) {
            st.setString(1, key);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    rsl.add(new Item(
                            rs.getInt("id"),
                            rs.getString("name")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        try (PreparedStatement st = cn.prepareStatement(
                "select * from items where id = ?")) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new Item(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        Item addedItem1 = tracker.add(new Item("Book"));
        Item addedItem2 = tracker.add(new Item("Pen"));
        Item addedItem3 = tracker.add(new Item("Computer"));
        System.out.println(addedItem3);
        System.out.println();
        tracker.replace(2, new Item("Fridge"));
        tracker.delete(2);
        System.out.println(tracker.findAll());
        System.out.println();
        System.out.println(tracker.findByName("Computer"));
        System.out.println();
        System.out.println(tracker.findById(1));
    }
}