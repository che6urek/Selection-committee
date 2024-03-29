package com.by.evgeny.selection.committee.entity.comparators;

import com.by.evgeny.selection.committee.entity.person.Enrolle;

import java.util.Comparator;

public class EnrolleByMarkComparator implements Comparator<Enrolle> {

    @Override
    public int compare(Enrolle enrolle1, Enrolle enrolle2) {
        return enrolle2.getTotalMark() - enrolle1.getTotalMark();
    }
}
