package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void wheAddAndFindAll() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("Item1"));
        tracker.add(new Item("Item2"));
        List<Item> rsl = tracker.findAll();
        assertThat(rsl.size(), is(2));
        assertThat(rsl.get(0).getName(), is("Item1"));
        assertThat(rsl.get(1).getName(), is("Item2"));
    }

    @Test
    public void whenFindByName() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("Item1"));
        tracker.add(new Item("Item1"));
        List<Item> rsl = tracker.findByName("Item1");
        assertThat(rsl.size(), is(2));
        assertThat(rsl.get(0).getName(), is("Item1"));
        assertThat(rsl.get(1).getName(), is("Item1"));
    }

    @Test
    public void whenFindById() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("Item1"));
        Item rsl = tracker.findById(1);
        assertThat(rsl.getName(), is("Item1"));
    }

    @Test
    public void whenReplace() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("Item1"));
        tracker.replace(1, new Item("Item2"));
        Item rsl = tracker.findById(1);
        assertThat(rsl.getName(), is("Item2"));
    }

    @Test
    public void whenDelete() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("Item1"));
        tracker.delete(1);
        List<Item> rsl = tracker.findAll();
        assertThat(rsl.size(), is(0));
    }
}