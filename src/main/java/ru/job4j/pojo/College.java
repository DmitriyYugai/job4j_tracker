package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Dmitry");
        student.setGroup("APIM-20");
        student.setEntered(new Date(2020, 6, 22));
        System.out.println("Student name: " + student.getName() + System.lineSeparator()
                            + "Group: " + student.getGroup() + System.lineSeparator()
                            + "Entered: " + student.getEntered());
    }
}
