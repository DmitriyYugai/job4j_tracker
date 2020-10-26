package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void matrixToList() {
        Integer[][] in = {
                {1, 3, 5},
                {2, 4, 10}
        };
        List<Integer> expected = Arrays.asList(1, 3, 5, 2, 4, 10);
        List<Integer> rsl = MatrixToList.matrixToList(in);
        assertThat(rsl, is(expected));
    }
}