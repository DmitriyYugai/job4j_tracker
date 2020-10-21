package ru.job4j.bank;

import java.util.HashMap;
import java.util.Map;

public class PutIfAbsent {
    private Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        PutIfAbsent p = new PutIfAbsent();
        p.map.put("one", 111);
        p.map.put("two", 222);
        p.map.put("three", 333);
        System.out.println(p.map);
        System.out.println(p.map.putIfAbsent("four", 444));
        System.out.println(p.map);
        System.out.println(p.map.putIfAbsent("two", 12345));
        System.out.println(p.map);
    }
}
