package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingletone2Test {

    @Test
    public void whenGetInstance() {
        TrackerSingletone2 ts1 = TrackerSingletone2.getInstance();
        TrackerSingletone2 ts2 = TrackerSingletone2.getInstance();
        assertSame(ts1, ts2);
    }

}