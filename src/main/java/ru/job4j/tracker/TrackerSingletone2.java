package ru.job4j.tracker;

public class TrackerSingletone2 {

    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingletone2() { }

    public static Tracker getInstance() {
        return INSTANCE;
    }

}
