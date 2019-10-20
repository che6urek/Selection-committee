package com.by.evgeny.selection.committee.service;

import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.entity.comparators.SpecialityByNameComparator;
import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.entity.crud.Specialities;
import com.by.evgeny.selection.committee.entity.documents.CTCertificate;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.entity.comparators.EnrolleByMarkComparator;
import com.by.evgeny.selection.committee.singleton.SingletonSpecialities;

import java.util.ArrayList;

public class SpecialityService {
    private Specialities specialities = SingletonSpecialities.getInstance();

    public void updateDataById(int id, Speciality spec){
        specialities.update(id, spec);
    }

    public void add(Speciality spec){
        specialities.add(spec);
    }

    public void remove(int id){
        specialities.delete(id);
    }

    public String getAll(){
        return specialities.toString();
    }

    public String getAllSortedByName(){
        specialities.getSpecialities().sort(new SpecialityByNameComparator());
        return specialities.toString();
    }

    public String getFacultySpecialities(String facultyName){
        return specialities.getSpecialities().stream().filter(s -> s.getFacultyName().equals(facultyName)).toString();
    }

    public void enroll(Enrollees enrollees){
        ArrayList<Enrolle> en = enrollees.getEnrollees();
        en.sort(new EnrolleByMarkComparator());
        for (Enrolle enrolle: en) {
            Speciality spec = specialities.getSpecialities().stream()
                    .filter(e -> e.getName().equals(enrolle.getSpecialtyName()))
                    .findFirst()
                    .orElse(null);
            if(spec != null)
                if(checkSubjects(enrolle.getCtCertificates(), spec.getRequiredSubjects()) && !enrolle.getEnrolled()) {
                    enrolle.setEnrolled(true);
                    spec.enroll(enrolle);
                }
        }
    }

    private boolean checkSubjects(ArrayList<CTCertificate> ct, String[] subjects)
    {
        for (String subject: subjects) {
            if(ct.stream()
                    .noneMatch(c -> c.getSubject().equals(subject)))
                return false;
        }
        return true;
    }
}
