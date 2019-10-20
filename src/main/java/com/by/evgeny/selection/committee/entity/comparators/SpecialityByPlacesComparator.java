package com.by.evgeny.selection.committee.entity.comparators;

import com.by.evgeny.selection.committee.entity.Speciality;

import java.util.Comparator;

public class SpecialityByPlacesComparator implements Comparator<Speciality> {

    @Override
    public int compare(Speciality speciality1, Speciality speciality2) {
        return (speciality2.getPlaces() - speciality1.getPlaces());
    }
}