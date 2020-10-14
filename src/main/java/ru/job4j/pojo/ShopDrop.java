package ru.job4j.pojo;

import ru.job4j.oop.Product;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        if (index == products.length - 1) {
            products[index] = null;
        } else {
            for (int i = index; i < products.length; i++) {
                if (i == 0) {
                    products[i] = null;
                } else {
                    products[i - 1] = products[i];
                    products[i] = null;
                }
            }
        }
        return products;
    }
}
