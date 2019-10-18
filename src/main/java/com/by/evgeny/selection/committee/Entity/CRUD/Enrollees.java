package com.by.evgeny.selection.committee.entity.crud;

import com.by.evgeny.selection.committee.entity.person.Enrolle;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Enrollees implements CRUD<Enrolle> {

    private ArrayList<Enrolle> enrollees;

    public Enrollees() {
        this.enrollees = new ArrayList<Enrolle>();
    }

    @Override
    public void add(Enrolle enrolle) {
        enrollees.add(enrolle);
    }

    @Override
    public Optional<Enrolle> get(int id) {
        return this.enrollees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }
    @Override
    public Optional<Enrolle> get(String fullName) {
        return this.enrollees.stream()
                .filter(e -> e.getFullName().equals(fullName))
                .findFirst();
    }

    @Override
    public void update(int id, Enrolle newEnrolle) {
        this.enrollees = this.enrollees.stream()
                .map(e -> (e.getId() == id) ? newEnrolle : e)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void update(String fullName, Enrolle newEnrolle) {
        this.enrollees = this.enrollees.stream()
                .map(e -> (e.getFullName().equals(fullName)) ? newEnrolle : e)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(int id) {
        enrollees.removeIf(e -> e.getId() == id);
    }

    @Override
    public void delete(String fullName) {
        enrollees.removeIf(e -> e.getFullName().equals(fullName));
    }

    @Override
    public void delete(Enrolle enrolle) {
        enrollees.remove(enrolle);
    }

    public void setEnrollees(ArrayList<Enrolle> enrollees) {
        this.enrollees = enrollees;
    }

    public ArrayList<Enrolle> getEnrollees() {
        return enrollees;
    }

    @Override
    public String toString() {
        return enrollees.stream()
                .map(Enrolle::toString)
                .collect(Collectors.joining(System.lineSeparator() + System.lineSeparator()));
    }
}
