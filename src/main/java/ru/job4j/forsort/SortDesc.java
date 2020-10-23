package ru.job4j.forsort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortDesc {
    public static void main(String[] args) {
        List<Integer> list =  Arrays.asList(7, 4);
        Collections.sort(list, new IntCompDesc());
        System.out.println(list);
    }
}
