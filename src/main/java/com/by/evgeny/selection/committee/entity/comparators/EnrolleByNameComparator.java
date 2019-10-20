package com.by.evgeny.selection.committee.entity.comparators;

import com.by.evgeny.selection.committee.entity.person.Enrolle;

import java.util.Comparator;

public class EnrolleByNameComparator implements Comparator <Enrolle> {

    @Override
    public int compare(Enrolle enrolle1, Enrolle enrolle2){
        return enrolle1.getFullName().compareTo(enrolle2.getFullName());
    }
}
