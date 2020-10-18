package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingletone3Test {

    @Test
    public void whenGetInstance() {
        TrackerSingletone3 ts1 = TrackerSingletone3.INSTANCE;
        TrackerSingletone3 ts2 = TrackerSingletone3.INSTANCE;
        assertSame(ts1, ts2);
    }

}