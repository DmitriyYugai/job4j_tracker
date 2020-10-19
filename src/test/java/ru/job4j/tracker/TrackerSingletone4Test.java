package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingletone4Test {

    @Test
    public void whenGetInstance() {
        Tracker ts1 = TrackerSingletone4.getInstance();
        Tracker ts2 = TrackerSingletone4.getInstance();
        assertSame(ts1, ts2);
    }

}