package com.by.evgeny.selection.committee.entity.comparators;

import com.by.evgeny.selection.committee.entity.person.Person;

import java.util.Comparator;

public class PersonByIdComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getId() - person2.getId();
    }
}
