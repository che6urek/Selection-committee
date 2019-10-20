package com.by.evgeny.selection.committee.service;

import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.entity.comparators.EnrolleByMarkComparator;
import com.by.evgeny.selection.committee.entity.comparators.EnrolleByNameComparator;
import com.by.evgeny.selection.committee.singleton.SingletonEnrollees;

public class EnrolleService {
    private Enrollees enrollees = SingletonEnrollees.getInstance();

    public void updateDataById(int id, Enrolle enrolle){
        enrollees.update(id, enrolle);
    }

    public void record(Enrolle enrolle){
        enrollees.add(enrolle);
    }

    public void excludeById(int id){
        enrollees.delete(id);
    }

    public String getAll(){
        return enrollees.toString();
    }

    public String getAllSortedByMark(){
        enrollees.getEnrollees().sort(new EnrolleByMarkComparator());
        return enrollees.toString();
    }

    public String getAllSortedByName(){
        enrollees.getEnrollees().sort(new EnrolleByNameComparator());
        return enrollees.toString();
    }
}
