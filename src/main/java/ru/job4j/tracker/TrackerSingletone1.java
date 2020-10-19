package ru.job4j.tracker;

public class TrackerSingletone1 {
    private static Tracker instance;

    private TrackerSingletone1() { }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

}
