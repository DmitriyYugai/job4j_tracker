package ru.job4j.inherit.doctor;

import ru.job4j.inherit.Profession;
import ru.job4j.inherit.doctor.Diagnose;

public class Doctor extends Profession {
    private Diagnose diagnose;

    public Diagnose getDiagnose() {
        return diagnose;
    }
}
