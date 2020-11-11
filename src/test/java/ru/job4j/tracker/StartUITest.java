package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    private SqlTracker tracker = new SqlTracker();

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenCreateItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[]{"0", "Item name", "1"}
            );
            UserAction[] actions = {
                    new CreateAction(out),
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(tracker.findAll().get(0).getName(), is("Item name"));
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Item item = new Item(1, "Replaced item");
            Connection cn = tracker.getCn();
            try (PreparedStatement st = cn.prepareStatement(
                    "insert into items(id, name) values(?, ?)")) {
                st.setInt(1, item.getId());
                st.setString(2, item.getName());
                st.execute();
            }
            String replacedName = "New item name";
            Input in = new StubInput(
                    new String[]{"0", "1", replacedName, "1"}
            );
            UserAction[] actions = {
                    new ReplaceAction(out),
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Item item = tracker.add(new Item("Deleted item"));
            Input in = new StubInput(
                    new String[]{"0", String.valueOf(item.getId()), "1"}
            );
            UserAction[] actions = {
                    new DeleteAction(out),
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(tracker.findById(item.getId()), is(nullValue()));
        }
    }

    @Test
    public void whenFindAll() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[]{"0", "1"}
            );
            Item item1 = new Item("New Item 1");
            Item item2 = new Item("New Item 2");
            tracker.add(item1);
            tracker.add(item2);
            UserAction[] actions = {
                    new FindAllAction(out),
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    "Menu." + System.lineSeparator()
                            + "0. Show all items" + System.lineSeparator()
                            + "1. Exit" + System.lineSeparator()
                            + "=== Show all items ===" + System.lineSeparator()
                            + "1. " + item1 + System.lineSeparator()
                            + "2. " + item2 + System.lineSeparator()
                            + "Menu." + System.lineSeparator()
                            + "0. Show all items" + System.lineSeparator()
                            + "1. Exit" + System.lineSeparator()
            ));
        }
    }

    @Test
    public void whenFindById() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[]{"0", "1", "1"}
            );
            Item item1 = new Item(1, "New Item 1");
            Connection cn = tracker.getCn();
            try (PreparedStatement st = cn.prepareStatement(
                    "insert into items(id, name) values(?, ?)")) {
                st.setInt(1, item1.getId());
                st.setString(2, item1.getName());
                st.execute();
            }
            UserAction[] actions = {
                    new FindByIdAction(out),
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    "Menu." + System.lineSeparator()
                            + "0. Find item by Id" + System.lineSeparator()
                            + "1. Exit" + System.lineSeparator()
                            + "=== Find item by Id ===" + System.lineSeparator()
                            + item1 + System.lineSeparator()
                            + "Menu." + System.lineSeparator()
                            + "0. Find item by Id" + System.lineSeparator()
                            + "1. Exit" + System.lineSeparator()
            ));
        }
    }

    @Test
    public void whenFindByName() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[]{"0", "New Item", "1"}
            );
            Item item1 = new Item("New Item");
            Item item2 = new Item("New Item");
            tracker.add(item1);
            tracker.add(item2);
            UserAction[] actions = {
                    new FindByNameAction(out),
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    "Menu." + System.lineSeparator()
                            + "0. Find items by name" + System.lineSeparator()
                            + "1. Exit" + System.lineSeparator()
                            + "=== Find items by name ===" + System.lineSeparator()
                            + "1. " + item1 + System.lineSeparator()
                            + "2. " + item2 + System.lineSeparator()
                            + "Menu." + System.lineSeparator()
                            + "0. Find items by name" + System.lineSeparator()
                            + "1. Exit" + System.lineSeparator()
            ));
        }
    }

    @Test
    public void whenExit() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[]{"0"}
            );
            UserAction[] actions = {
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    "Menu." + System.lineSeparator()
                            + "0. Exit" + System.lineSeparator()
            ));
        }
    }

    @Test
    public void whenInvalidExit() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[]{"2", "0"}
            );
            UserAction[] actions = {
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Exit%n"
                                    + "Wrong input, you can select: 0 .. 0%n"
                                    + "Menu.%n"
                                    + "0. Exit%n"
                    )
            ));
        }
    }

}