package ru.job4j.tracker;

public class TrackerSingletone2 {

    private static final TrackerSingletone2 INSTANCE = new TrackerSingletone2();
    private final Tracker tracker = new Tracker();

    private TrackerSingletone2() { }

    public static TrackerSingletone2 getInstance() {
        return INSTANCE;
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
