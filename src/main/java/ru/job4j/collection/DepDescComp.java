package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] s1 = o1.split("/");
        String[] s2 = o2.split("/");
        int rsl = s2[0].compareTo(s1[0]);
        if (rsl != 0) {
            return rsl;
        }
        return o1.compareTo(o2);

//        int tmp = o1.length() - o2.length() < 0 ? o1.length() : o2.length();
//        for (int i = 0; i < tmp; i++) {
//            if (o1.charAt(i) > o2.charAt(i)) {
//                return Character.compare(o1.charAt(i), o2.charAt(i));
//            }
//        }
//        return o1.length() - o2.length();
    }
}
