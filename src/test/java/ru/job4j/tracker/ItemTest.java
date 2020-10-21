package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void whenSortById() {
        List<Item> items = Arrays.asList(new Item(4, "Adding"),
                                         new Item(2, "Deleting"),
                                         new Item(7, "Replacing"));
        Collections.sort(items);
        List<Item> expected = Arrays.asList(new Item(2, "Deleting"),
                                            new Item(4, "Adding"),
                                            new Item(7, "Replacing"));
        assertThat(items, is(expected));
    }

    @Test
    public void whenSortByName() {
        List<Item> items = Arrays.asList(new Item(2, "Deleting"),
                                         new Item(7, "Replacing"),
                                         new Item(4, "Adding"));
        Collections.sort(items, new SortByNameItem());
        List<Item> expected = Arrays.asList(new Item(4, "Adding"),
                                            new Item(2, "Deleting"),
                                            new Item(7, "Replacing"));
        assertThat(items, is(expected));
    }
}