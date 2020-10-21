package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        for (int i = 0; i < left.length() - 1 || i < right.length(); i++) {
            char l = i < left.length() - 1 ? left.charAt(i) : Character.MIN_VALUE;
            char r = i < right.length() - 1 ? right.charAt(i) : Character.MIN_VALUE;
            if (l != Character.MIN_VALUE && r == Character.MIN_VALUE) {
                rsl++;
            } else if (r != Character.MIN_VALUE && l == Character.MIN_VALUE) {
                rsl--;
            } else if (r == Character.MIN_VALUE && l == Character.MIN_VALUE) {
                break;
            } else {
                rsl = Character.compare(l, r);
                if (rsl == 0) {
                    continue;
                }
                break;
            }
        }
        return rsl;
    }
}
