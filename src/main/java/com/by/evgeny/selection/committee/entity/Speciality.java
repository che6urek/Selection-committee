package com.by.evgeny.selection.committee.entity;

import com.by.evgeny.selection.committee.entity.person.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class Speciality implements Serializable {

    private String name;
    private String facultyName;
    private int places;
    private int code;
    private String[] requiredSubjects;
    private ArrayList<Student> enrolled;
    private int maxId;

    public Speciality(String name, String facultyName, int places, String[] requiredSubjects, int code) {
        this.name = name;
        this.facultyName = facultyName;
        this.places = places;
        this.requiredSubjects = requiredSubjects;
        enrolled = new ArrayList<Student>();
        this.code = code;
    }

    public Speciality() {
        enrolled = new ArrayList<Student>();
    }

    public void enroll(Student student){
        if(enrolled.size() < places)
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

    public ArrayList<Student> getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(ArrayList<Student> enrolled) {
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
        this.maxId = enrolled.stream()
                .mapToInt(Entity::getId)
                .max().orElse(0);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(facultyName + " " + name + System.lineSeparator()
                + "Code: " + code + System.lineSeparator()
                + "Places: " + places + System.lineSeparator()
                + "Required subjects: ");
        if(requiredSubjects.length > 0)
            result.append(requiredSubjects[0]);
        for (int i = 1; i < requiredSubjects.length; i++) {
            result.append(", ").append(requiredSubjects[i]);
        }
        result.append(System.lineSeparator()).append("Enrolled: ").append(enrolled.size());
        return result.toString();
    }
}
