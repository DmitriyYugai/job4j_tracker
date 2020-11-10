package ru.job4j.tracker;

public class TrackerSingletone2 {

    private static final MemTracker INSTANCE = new MemTracker();

    private TrackerSingletone2() { }

    public static MemTracker getInstance() {
        return INSTANCE;
    }

}
