package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> firstCond = person -> person.getName().contains(key);
        Predicate<Person> combine = firstCond.or(person -> person.getSurname().contains(key))
                                             .or(person -> person.getAddress().contains(key))
                                             .or(person -> person.getPhone().contains(key));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
