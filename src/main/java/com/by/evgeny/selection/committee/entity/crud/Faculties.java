package com.by.evgeny.selection.committee.entity.crud;

import com.by.evgeny.selection.committee.entity.Faculty;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Faculties implements CRUD<Faculty> {

    private ArrayList<Faculty> faculties;

    public Faculties () {
        faculties = new ArrayList<Faculty>();
    }

    @Override
    public void add(Faculty faculty) {
        faculties.add(faculty);
    }

    @Override
    public Optional<Faculty> get(int code) {
        return this.faculties.stream()
                .filter(f -> f.getCode() == code)
                .findFirst();
    }
    @Override
    public Optional<Faculty> get(String fullName) {
        return this.faculties.stream()
                .filter(f -> f.getName().equals(fullName))
                .findFirst();
    }

    @Override
    public void update(int code, Faculty newFaculty) {
        this.faculties = this.faculties.stream()
                .map(f -> (f.getCode() == code) ? newFaculty : f)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void update(String name, Faculty newFaculty) {
        this.faculties = this.faculties.stream()
                .map(f -> (f.getName().equals(name)) ? newFaculty : f)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(int code) {
        faculties.removeIf(e -> e.getCode() == code);
    }

    @Override
    public void delete(String name) {
        faculties.removeIf(e -> e.getName().equals(name));
    }

    @Override
    public void delete(Faculty speciality) {
        faculties.remove(speciality);
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Faculties faculties = (Faculties) obj;
        return Objects.equals(this.faculties, faculties.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculties);
    }

    @Override
    public String toString() {
        return faculties.stream()
                .map(Faculty::toString)
                .collect(Collectors.joining(System.lineSeparator() + System.lineSeparator()));
    }

}
