package ru.job4j.inheritance.doctor;

import ru.job4j.inheritance.Profession;

public class Doctor extends Profession {
    private Diagnose diagnose;

    public Diagnose getDiagnose() {
        return diagnose;
    }
}
