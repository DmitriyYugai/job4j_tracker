package ru.job4j.tracker;

public class TrackerSingletone4 {

    private final Tracker tracker = new Tracker();

    private static final class Holder {
        private static final TrackerSingletone4 INSTANCE = new TrackerSingletone4();
    }

    private TrackerSingletone4() { }

    public static TrackerSingletone4 getInstance() {
        return Holder.INSTANCE;
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
