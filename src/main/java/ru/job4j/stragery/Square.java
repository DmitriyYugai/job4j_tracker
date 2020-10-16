package ru.job4j.stragery;

public class Square implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    " _____  " + ln
                + "|     | " + ln
                + "|_____| " + ln;
    }

    public static void main(String[] args) {
        System.out.println(new Square().draw());
    }
}
