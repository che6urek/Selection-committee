package com.by.evgeny.selection.committee.entity.comparators;

import com.by.evgeny.selection.committee.entity.Speciality;

import java.util.Comparator;

public class SpecialityByNameComparator implements Comparator<Speciality> {

    @Override
    public int compare(Speciality speciality1, Speciality speciality2) {
        return (speciality1.getFacultyName() + speciality1.getName())
                .compareTo(speciality2.getFacultyName() + speciality2.getName());
    }
}