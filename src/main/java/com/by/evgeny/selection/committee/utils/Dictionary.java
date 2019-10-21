package com.by.evgeny.selection.committee.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Dictionary implements Serializable {
    private ArrayList<String> subjects = new ArrayList<String>();
    private ArrayList<String> specialities = new ArrayList<String>();
    private ArrayList<String> faculties = new ArrayList<String>();

    public Dictionary() {

    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public void deleteSubject(String subject) {
        subjects.remove(subject);
    }

    public void addSpeciality(String speciality) {
        specialities.add(speciality);
    }

    public void deleteSpeciality(String speciality) {
        specialities.remove(speciality);
    }

    public void addFaculty(String faculty) {
        faculties.add(faculty);
    }

    public void deleteFaculty(String faculty) {
        faculties.remove(faculty);
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<String> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(ArrayList<String> specialities) {
        this.specialities = specialities;
    }

    public ArrayList<String> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<String> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        Collections.sort(subjects);
        Collections.sort(specialities);
        Collections.sort(faculties);
        return "Subjects: " + System.lineSeparator()
                + subjects.stream().map(String::toString)
                .collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator()
                + "Specialities: " + System.lineSeparator()
                + specialities.stream().map(String::toString)
                .collect(Collectors.joining(System.lineSeparator()))  + System.lineSeparator()
                + "Faculties: " + System.lineSeparator()
                + faculties.stream().map(String::toString)
                .collect(Collectors.joining(System.lineSeparator()))  + System.lineSeparator();
    }
}
