package ru.job4j.tracker;

public class TrackerSingletone4 {

    private static final class Holder {
        private static final MemTracker INSTANCE = new MemTracker();
    }

    private TrackerSingletone4() { }

    public static MemTracker getInstance() {
        return Holder.INSTANCE;
    }

}
