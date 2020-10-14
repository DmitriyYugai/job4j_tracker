package ru.job4j.pojo;

import ru.job4j.oop.Product;

public class Shop {
    public static int indexOfNull(Product[] products) {
        for (int index = 0; index < products.length; index++) {
            if (products[index] == null) {
                return index;
            }
        }
        return -1;
    }
}
