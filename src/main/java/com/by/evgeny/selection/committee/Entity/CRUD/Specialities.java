package com.by.evgeny.selection.committee.Entity.CRUD;

import com.by.evgeny.selection.committee.Data.EnrolleByMarkComparator;
import com.by.evgeny.selection.committee.Entity.Documents.CTCertificate;
import com.by.evgeny.selection.committee.Entity.Person.Enrolle;
import com.by.evgeny.selection.committee.Entity.Speciality;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Specialities implements CRUD<Speciality> {

    private ArrayList<Speciality> specialities;

    public Specialities () {
        specialities = new ArrayList<Speciality>();
        //TODO fill list from file
    }

    @Override
    public void add(Speciality speciality) {
        specialities.add(speciality);
    }

    @Override
    public Optional<Speciality> get(int code) {
        return this.specialities.stream()
                .filter(e -> e.getCode() == code)
                .findFirst();
    }
    @Override
    public Optional<Speciality> get(String fullName) {
        return this.specialities.stream()
                .filter(e -> e.getName().equals(fullName))
                .findFirst();
    }

    @Override
    public void update(int code, Speciality newSpeciality) {
        this.specialities = this.specialities.stream()
                .map(e -> (e.getCode() == code) ? newSpeciality : e)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void update(String name, Speciality newSpeciality) {
        this.specialities = this.specialities.stream()
                .map(e -> (e.getName().equals(name)) ? newSpeciality : e)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(int code) {
        specialities.removeIf(e -> e.getCode() == code);
    }

    @Override
    public void delete(String name) {
        specialities.removeIf(e -> e.getName().equals(name));
    }

    @Override
    public void delete(Speciality speciality) {
        specialities.remove(speciality);
    }

    public void Enroll(Enrollees enrollees){
        EnrolleByMarkComparator comparator = new EnrolleByMarkComparator();
        ArrayList<Enrolle> en = enrollees.getEnrollees();
        en.sort((e1, e2) -> comparator.compare(e2, e1));
        for (Enrolle enrolle: en) {
            Speciality spec = specialities.stream()
                    .filter(e -> e.getName().equals(enrolle.getSpecialtyName()))
                    .findFirst()
                    .orElse(null);
            if(spec != null)
                if(CheckSubjects(enrolle.getCtCertificates(), spec.getRequiredSubjects()) && !enrolle.getEnrolled()) {
                    enrolle.setEnrolled(true);
                    //spec.AddStudent(new Student(enrolle.getPersonalData(), enrolle.getSpecialtyName(), spec.getCode() * 100 + 1));
                    spec.Enrolle(enrolle);
                }
        }
    }

    private boolean CheckSubjects(ArrayList<CTCertificate> ct, String[] subjects)
    {
        for (String subject: subjects) {
            if(ct.stream()
                    .noneMatch(c -> c.getSubject().equals(subject)))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return specialities.stream()
                .map(Speciality::toString)
                .collect(Collectors.joining(System.lineSeparator() + System.lineSeparator()));
    }

}
