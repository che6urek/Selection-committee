package com.by.evgeny.selection.committee.entity;

import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.entity.person.Student;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class SelectionCommittee implements Serializable {

    @JacksonXmlElementWrapper(localName = "Specialities")
    @JacksonXmlProperty(localName = "speciality")
    private ArrayList<Speciality> specialities;

    @JacksonXmlElementWrapper(localName = "Faculties")
    @JacksonXmlProperty(localName = "faculty")
    private ArrayList<Faculty> faculties;

    @JacksonXmlElementWrapper(localName = "Students")
    @JacksonXmlProperty(localName = "student")
    private ArrayList<Student> students;

    @JacksonXmlElementWrapper(localName = "Enrollees")
    @JacksonXmlProperty(localName = "enrolle")
    private ArrayList<Enrolle> enrollees;

    public SelectionCommittee(ArrayList<Speciality> specialities, ArrayList<Faculty> faculties,
                              ArrayList<Student> students, ArrayList<Enrolle> enrollees) {
        this.specialities = specialities;
        this.faculties = faculties;
        this.students = students;
        this.enrollees = enrollees;
    }

    public SelectionCommittee() {
        specialities = new ArrayList<Speciality>();
        faculties = new ArrayList<Faculty>();
        students = new ArrayList<Student>();
        enrollees = new ArrayList<Enrolle>();
    }

    public ArrayList<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(ArrayList<Speciality> specialities) {
        this.specialities = specialities;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Enrolle> getEnrollees() {
        return enrollees;
    }

    public void setEnrollees(ArrayList<Enrolle> enrollees) {
        this.enrollees = enrollees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectionCommittee that = (SelectionCommittee) o;
        return Objects.equals(specialities, that.specialities) &&
                Objects.equals(faculties, that.faculties) &&
                Objects.equals(students, that.students) &&
                Objects.equals(enrollees, that.enrollees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialities, faculties, students, enrollees);
    }

    @Override
    public String toString() {
        return "Specialities:" + specialities + System.lineSeparator() +
                "Faculties:" + faculties + System.lineSeparator() +
                "Students:" + students + System.lineSeparator() +
                "Enrollees:" + enrollees;
    }
}
