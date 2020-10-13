package ru.job4j.inheritance.engineer;

import ru.job4j.inheritance.Profession;

public class Engineer extends Profession {
    private Project project;

    public Project getProject() {
        return project;
    }
}
