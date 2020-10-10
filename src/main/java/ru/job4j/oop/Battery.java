package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = another.load + load;
        load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(25);
        Battery battery2 = new Battery(5);
        System.out.println("battery1: " + battery1.load + " battery2: " + battery2.load);
        battery1.exchange(battery2);
        System.out.println("battery1: " + battery1.load + " battery2: " + battery2.load);
    }

}
