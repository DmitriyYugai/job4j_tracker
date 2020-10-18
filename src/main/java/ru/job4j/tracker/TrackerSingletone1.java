package ru.job4j.tracker;

public class TrackerSingletone1 {

    private static TrackerSingletone1 instance;
    private final Tracker tracker = new Tracker();

    private TrackerSingletone1() { }

    public static TrackerSingletone1 getInstance() {
        if (instance == null) {
            instance = new TrackerSingletone1();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

}
