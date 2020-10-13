package ru.job4j.inherit.engineer;

import ru.job4j.inherit.Profession;
import ru.job4j.inherit.engineer.Project;

public class Engineer extends Profession {
    private Project project;

    public Project getProject() {
        return project;
    }
}
