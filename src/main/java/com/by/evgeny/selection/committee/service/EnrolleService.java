package com.by.evgeny.selection.committee.service;

import com.by.evgeny.selection.committee.entity.comparators.EnrolleByIdComparator;
import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.entity.comparators.EnrolleByMarkComparator;
import com.by.evgeny.selection.committee.entity.comparators.EnrolleByNameComparator;
import com.by.evgeny.selection.committee.singleton.SingletonEnrollees;
import com.by.evgeny.selection.committee.utils.DataValidator;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class EnrolleService {

    private Enrollees enrollees = SingletonEnrollees.getInstance();

    public Optional<Enrolle> getById(int id) {
        return enrollees.get(id);
    }

    public void updateDataById(int id, Enrolle enrolle){
        if(validate(enrolle))
            enrollees.update(id, enrolle);
    }

    public void add(Enrolle enrolle){
        if(validate(enrolle))
            enrollees.add(enrolle);
    }

    public void deleteById(int id){
        enrollees.delete(id);
    }

    public String getAll(){
        return enrollees.toString();
    }

    public String getAllSortedById() {
        enrollees.getEnrollees().sort(new EnrolleByIdComparator());
        return enrollees.toString();
    }

    public String getAllSortedByMark() {
        enrollees.getEnrollees().sort(new EnrolleByMarkComparator());
        return enrollees.toString();
    }

    public String getAllSortedByName() {
        enrollees.getEnrollees().sort(new EnrolleByNameComparator());
        return enrollees.toString();
    }

    public String getForSpeciality(String specName) {
        var temp = new Enrollees();
        temp.setEnrollees(enrollees.getEnrollees().stream()
                .filter(e -> e.getSpecialtyName().equals(specName))
                .collect(Collectors.toCollection(ArrayList::new)));
        return temp.toString();
    }

    public boolean validate(Enrolle enrolle) {
        var ct = enrolle.getCtCertificates();
        var ac = enrolle.getAcademicCertificate();

        if(ct == null || ac == null || enrolle.getMedicalCertificate() == null
                || enrolle.getPersonalData() == null || enrolle.getSpecialtyName() == null)
            return false;

        if(ct.size() < 2 || ct.size() > 4)
            return false;
        for (var certificate: ct) {
            if(!DataValidator.checkMark(certificate.getMark()))
                return false;
        }

        if(ac.getMarks() == null || ac.getMarks().length < 1 || !DataValidator.checkMark(ac.getAverageMark()))
            return false;
        for (var mark: ac.getMarks()) {
            if(!DataValidator.checkSchoolMark(mark))
                return false;
        }

        if(!DataValidator.checkMark(enrolle.getTotalMark()))
            return false;

        if(!DataValidator.checkWords(enrolle.getSpecialtyName()))
            return false;

        return DataValidator.checkName(enrolle.getFullName());
    }
}
