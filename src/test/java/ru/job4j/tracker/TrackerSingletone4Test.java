package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingletone4Test {

    @Test
    public void whenGetInstance() {
        TrackerSingletone4 ts1 = TrackerSingletone4.getInstance();
        TrackerSingletone4 ts2 = TrackerSingletone4.getInstance();
        assertSame(ts1, ts2);
    }

}