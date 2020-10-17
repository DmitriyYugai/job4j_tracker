package ru.job4j.ex;

public class Fact {

    @SuppressWarnings("checkstyle:LineLength")
    public int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("Невозможно вычислить факториал отрицательного числа");
        } else {
            for (int index = 1; index <= n; index++) {
                rsl *= index;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Fact fact = new Fact();
        System.out.println("4! = " + fact.calc(4));
        System.out.println("0! = " + fact.calc(0));
        System.out.println("-5! = " + fact.calc(-5));
    }
}
