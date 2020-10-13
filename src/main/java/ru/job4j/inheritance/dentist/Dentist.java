package ru.job4j.inheritance.dentist;

import ru.job4j.inheritance.doctor.Doctor;

public class Dentist extends Doctor {
    private Drill drill;

    public Tooth removeTooth() {
        return new Tooth();
    }
}
