package com.by.evgeny.selection.committee.service;

import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.entity.comparators.SpecialityByNameComparator;
import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.entity.crud.Specialities;
import com.by.evgeny.selection.committee.entity.documents.CTCertificate;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.entity.comparators.EnrolleByMarkComparator;
import com.by.evgeny.selection.committee.singleton.SingletonSpecialities;
import com.by.evgeny.selection.committee.utils.DataValidator;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class SpecialityService {

    private Specialities specialities = SingletonSpecialities.getInstance();

    public Optional<Speciality> getByCode(int code) {
        return specialities.get(code);
    }

    public void updateDataById(int id, Speciality spec){
        if(validate(spec))
            specialities.update(id, spec);
    }

    public void add(Speciality spec){
        if(validate(spec))
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
        var temp = new Specialities();
        temp.setSpecialities(specialities.getSpecialities().stream()
                .filter(e -> e.getFacultyName().equals(facultyName))
                .collect(Collectors.toCollection(ArrayList::new)));
        return temp.toString();
    }

    public boolean validate(Speciality spec) {
        String[] subjects = spec.getRequiredSubjects();
        if(spec.getFacultyName() == null || spec.getName() == null
                || spec.getEnrolled() == null || subjects == null)
            return false;
        if(!DataValidator.checkWords(spec.getFacultyName()) || !DataValidator.checkWords(spec.getName()))
            return false;
        if(spec.getPlaces() < 0)
            return false;
        for (var subject: subjects) {
            if(!DataValidator.checkWords(subject))
                return false;
        }
        var enrolleService = new EnrolleService();
        for (Enrolle en: spec.getEnrolled().getEnrollees()) {
            if(!enrolleService.validate(en))
                return false;
        }
        return spec.getCode() >= 0;
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
