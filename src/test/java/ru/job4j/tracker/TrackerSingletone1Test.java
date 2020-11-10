package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingletone1Test {

    @Test
    public void whenGetInstance() {
        MemTracker ts1 = TrackerSingletone1.getInstance();
        MemTracker ts2 = TrackerSingletone1.getInstance();
        assertSame(ts1, ts2);
    }

}