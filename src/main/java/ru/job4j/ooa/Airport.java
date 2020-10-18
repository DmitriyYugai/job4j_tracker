package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus airbus = new Airbus("A320");
        System.out.println(airbus);
        airbus.printModelForAirbus();
        airbus.printCountEngine();
        airbus.setName("A380");
        System.out.println(airbus);
    }
}
