package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cards {
    public static void main(String[] args) {
        List<Card> cards = Stream.of(Suit.values())
                .flatMap(suit -> {
                    Card[] tmp = new Card[Value.values().length];
                    for (int i = 0; i < Value.values().length; i++) {
                        tmp[i] = new Card(suit, Value.values()[i]);
                    }
                    return Arrays.stream(tmp);
                })
                .collect(Collectors.toList());
        System.out.println(cards);
    }
}
