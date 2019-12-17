package com.by.evgeny.selection.committee.entity;

import java.io.Serializable;

public class Speciality implements Serializable {

    private String name;
    private int facultyId;
    private int places;
    private int enrolled;
    private int id;

    public Speciality(String name, int facultyId, int places, int enrolled, int id) {
        this.name = name;
        this.facultyId = facultyId;
        this.places = places;
        this.enrolled = enrolled;
        this.id = id;
    }

    public Speciality() {

    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Name: " + name + System.lineSeparator()
                + "Id: " + id + System.lineSeparator()
                + "Places: " + places + System.lineSeparator()
                + "Enrolled: " + enrolled);
        return result.toString();
    }
}
