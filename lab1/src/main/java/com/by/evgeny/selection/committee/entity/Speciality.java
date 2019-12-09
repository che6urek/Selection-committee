package com.by.evgeny.selection.committee.entity;

import com.by.evgeny.selection.committee.entity.crud.Students;
import com.by.evgeny.selection.committee.entity.person.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Speciality implements Serializable {

    private String name;
    private String facultyName;
    private int places;
    private int code;
    private String[] requiredSubjects;
    private Students enrolled;
    private int maxId;

    public Speciality(String name, String facultyName, int places, String[] requiredSubjects, int code) {
        this.name = name;
        this.facultyName = facultyName;
        this.places = places;
        this.requiredSubjects = requiredSubjects;
        enrolled = new Students();
        this.code = code;
    }

    public Speciality() {
        enrolled = new Students();
    }

    public void enroll(Student student){
        if (enrolled.getStudents().size() < places)
            enrolled.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public String[] getRequiredSubjects() {
        return requiredSubjects;
    }

    public void setRequiredSubjects(String[] requiredSubjects) {
        this.requiredSubjects = requiredSubjects;
    }

    public Students getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Students enrolled) {
        this.enrolled = enrolled;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public void updateMaxId() {
        this.maxId = enrolled.getStudents().stream()
                .mapToInt(Entity::getId)
                .max().orElse(0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, facultyName, places, code, requiredSubjects, enrolled);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Speciality speciality = (Speciality) obj;
        return Objects.equals(name, speciality.name) &&
                Objects.equals(facultyName, speciality.facultyName) &&
                Objects.equals(places, speciality.places) &&
                Objects.equals(code, speciality.code) &&
                Arrays.equals(requiredSubjects, speciality.requiredSubjects) &&
                Objects.equals(enrolled, speciality.enrolled);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(facultyName + " " + name + System.lineSeparator()
                + "Code: " + code + System.lineSeparator()
                + "Places: " + places + System.lineSeparator()
                + "Required subjects: ");
        if (requiredSubjects.length > 0)
            result.append(requiredSubjects[0]);
        for (int i = 1; i < requiredSubjects.length; i++) {
            result.append(", ").append(requiredSubjects[i]);
        }
        result.append(System.lineSeparator()).append("Enrolled: ").append(enrolled.getStudents().size());
        return result.toString();
    }
}
