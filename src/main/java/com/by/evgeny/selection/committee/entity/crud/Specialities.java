package com.by.evgeny.selection.committee.entity.crud;

import com.by.evgeny.selection.committee.entity.person.EnrolleByMarkComparator;
import com.by.evgeny.selection.committee.entity.documents.CTCertificate;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.entity.Speciality;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Specialities implements CRUD<Speciality> {

    private ArrayList<Speciality> specialities;

    public Specialities () {
        specialities = new ArrayList<Speciality>();
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

    public ArrayList<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(ArrayList<Speciality> specialities) {
        this.specialities = specialities;
    }

    @Override
    public String toString() {
        return specialities.stream()
                .map(Speciality::toString)
                .collect(Collectors.joining(System.lineSeparator() + System.lineSeparator()));
    }

}
