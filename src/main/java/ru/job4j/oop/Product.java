package ru.job4j.oop;

public final class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int price() {
        return price - discount();
    }

    public int discount() {
        return 0;
    }

    public String label() {
        return name + " " + price();
    }
}
