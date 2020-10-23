package ru.job4j.collection;

import java.util.Comparator;

public class DepDescCompFirst implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int tmp = o1.length() - o2.length() < 0 ? o1.length() : o2.length();
        for (int i = 0; i < tmp; i++) {
            if (o1.charAt(i) > o2.charAt(i)) {
                return Character.compare(o1.charAt(i), o2.charAt(i));
            }
        }
        return o1.length() - o2.length();
    }
}
