package ru.job4j.lambda;

import java.util.Comparator;

public class StringDesc {
    public static void main(String[] args) {
        Comparator<String> comp = (s1, s2) -> {
            System.out.println("comparing: \"" + s1 + "\" and \"" + s2 + "\"");
            return s2.compareTo(s1);
        };
        System.out.println("result: " + comp.compare("abc", "abcd"));
    }
}
