package ru.job4j.collection;

import java.util.Comparator;

public class DepDescCompSecond implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int left = o1.charAt(1);
        int right = o2.charAt(1);
        return Integer.compare(right, left);
    }
}
