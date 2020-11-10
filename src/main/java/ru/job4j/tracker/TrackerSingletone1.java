package ru.job4j.tracker;

public class TrackerSingletone1 {
    private static MemTracker instance;

    private TrackerSingletone1() { }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }

}
