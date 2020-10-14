package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book b1 = new Book("Thinking in Java", 1036);
        Book b2 = new Book("Head first", 1000);
        Book b3 = new Book("Clean code", 967);
        Book b4 = new Book("Spring in Action", 657);
        Book[] books = new Book[]{b1, b2, b3, b4};
        printBooks(books);
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        printBooks(books);
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            if (b.getName().equals("Clean code")) {
                System.out.println(b.getName() + " - " + b.getPages());
            }
        }
    }

    private static void printBooks(Book[] books) {
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            System.out.println(b.getName() + " - " + b.getPages());
        }
    }

}
