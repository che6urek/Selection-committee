package com.by.evgeny.selection.committee.entity.crud;

import com.by.evgeny.selection.committee.entity.Speciality;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Specialities implements CRUD<Speciality> {

    private ArrayList<Speciality> specialities;
    private int maxId;

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
                .filter(s -> s.getCode() == code)
                .findFirst();
    }
    @Override
    public Optional<Speciality> get(String fullName) {
        return this.specialities.stream()
                .filter(s -> s.getName().equals(fullName))
                .findFirst();
    }

    @Override
    public void update(int code, Speciality newSpeciality) {
        this.specialities = this.specialities.stream()
                .map(s -> (s.getCode() == code) ? newSpeciality : s)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void update(String name, Speciality newSpeciality) {
        this.specialities = this.specialities.stream()
                .map(s -> (s.getName().equals(name)) ? newSpeciality : s)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(int code) {
        specialities.removeIf(s -> s.getCode() == code);
    }

    @Override
    public void delete(String name) {
        specialities.removeIf(s -> s.getName().equals(name));
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

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public void updateMaxId() {
        this.maxId = specialities.stream()
                .mapToInt(Speciality::getMaxId)
                .max().orElse(0);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Specialities spec = (Specialities) obj;
        return Objects.equals(specialities, spec.specialities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialities);
    }

    @Override
    public String toString() {
        return specialities.stream()
                .map(Speciality::toString)
                .collect(Collectors.joining(System.lineSeparator() + System.lineSeparator()));
    }

}
