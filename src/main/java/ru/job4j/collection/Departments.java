package ru.job4j.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        return deps.stream()
                .flatMap(element -> {
                    String[] elements = new String[element.split("/").length];
                    String start = "";
                    for (int i = 0; i < element.split("/").length; i++) {
                        start += element.split("/")[i];
                        elements[i] = start;
                        start += "/";
                    }
                    return Arrays.stream(elements);
                })
                .distinct()
                .collect(Collectors.toList());
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }

}
