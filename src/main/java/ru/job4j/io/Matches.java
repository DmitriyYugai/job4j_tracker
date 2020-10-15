package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    private int numberOfMatches = 11;
    private Scanner input = new Scanner(System.in);

    private void playerEnter(int numberOfPlayer) {
        int num = 0;
        while (num < 1 || num > 3) {
            System.out.println("Игрок " + numberOfPlayer + " введите число от 1 до 3:");
            try {
                num = Integer.valueOf(input.nextLine());
            } catch (NumberFormatException e) {
                num = 0;
            }
            if (num >= 1 && num <= 3) {
                break;
            } else {
                System.out.println("Введено некорректное значение. "
                        + "Каждый игрок за один ход может забрать от 1 до 3 спичек");
            }
        }
        numberOfMatches = numberOfMatches - num;
        System.out.println("Игрок " + numberOfPlayer + " сделал свой ход. "
                            + "Спичек осталось: " + numberOfMatches);
    }

    public static void main(String[] args) {
        Matches m = new Matches();
        System.out.println("Начало игры. Всего спичек: 11");
        while (m.numberOfMatches > 0) {
            m.playerEnter(1);
            m.playerEnter(2);
            m.playerEnter(3);
        }
    }
}
