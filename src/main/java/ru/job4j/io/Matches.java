package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    private int numberOfMatches = 11;
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Matches m = new Matches();
        int numberOfPlayer = 1;
        System.out.println("Начало игры. Всего спичек: 11");
        while (m.numberOfMatches > 0) {
            int num = 0;
            while (num < 1 || num > 3) {
                System.out.println("Игрок " + numberOfPlayer + " введите число от 1 до 3:");
                try {
                    num = Integer.valueOf(m.input.nextLine());
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
            m.numberOfMatches = m.numberOfMatches - num;
            if (m.numberOfMatches > 0) {
                System.out.println("Игрок " + numberOfPlayer + " сделал свой ход. "
                        + "Спичек осталось: " + m.numberOfMatches);
                if (++numberOfPlayer > 3) {
                    numberOfPlayer = 1;
                }
            } else {
                System.out.println("Игрок " + numberOfPlayer + " победил!");
            }
        }
    }
}
