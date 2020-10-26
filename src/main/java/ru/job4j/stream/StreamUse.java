package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUse {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, -1, 5, 3, 6, -4, -8, 8, -10);
        System.out.println(numbers);
        List<Integer> rsl = numbers.stream().filter(e -> e > 0).collect(Collectors.toList());
        System.out.println(rsl);
    }
}
