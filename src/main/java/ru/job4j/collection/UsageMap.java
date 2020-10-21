package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("student97@mail.ru", "Dmitry Yugay");
        for (String key : hashMap.keySet()) {
            System.out.println("E-mail: " + key + "; Name: " + hashMap.get(key));
        }
    }
}
