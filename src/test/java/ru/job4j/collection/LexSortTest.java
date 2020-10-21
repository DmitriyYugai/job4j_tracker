package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task.",
                "  6. Task.",
                " 7. Task.",
                "26. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "  6. Task.",
                " 7. Task.",
                "10. Task.",
                "26. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}