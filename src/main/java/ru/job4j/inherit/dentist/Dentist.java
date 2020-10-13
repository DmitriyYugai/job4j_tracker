package ru.job4j.inherit.dentist;

import ru.job4j.inherit.doctor.Doctor;

public class Dentist extends Doctor {
    private Drill drill;

    public Tooth removeTooth() {
        return new Tooth();
    }
}
