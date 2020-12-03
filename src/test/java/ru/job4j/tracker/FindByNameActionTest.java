package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenExecuteFindByName() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item1 = new Item("Find item");
        Item item2 = new Item("Find item");
        tracker.add(item1);
        tracker.add(item2);
        FindByNameAction find = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Find item");
        boolean rsl = find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln
                + "1. " + item1 + ln
                + "2. " + item2 + ln));
        assertTrue(rsl);
    }
}