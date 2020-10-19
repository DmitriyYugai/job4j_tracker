package ru.job4j.tracker;

public class TrackerSingletone4 {

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    private TrackerSingletone4() { }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

}
