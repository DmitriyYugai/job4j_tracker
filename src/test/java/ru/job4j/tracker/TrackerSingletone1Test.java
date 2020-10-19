package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingletone1Test {

    @Test
    public void whenGetInstance() {
        Tracker ts1 = TrackerSingletone1.getInstance();
        Tracker ts2 = TrackerSingletone1.getInstance();
        assertSame(ts1, ts2);
    }

}