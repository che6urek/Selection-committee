package com.by.evgeny.selection.committee.entity;

import java.io.Serializable;
import java.util.Objects;

public class Faculty implements Serializable {

    private String name;
    private int id;

    public Faculty() {

    }

    public Faculty(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Faculty faculty = (Faculty) obj;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(id, faculty.id);
    }

    @Override
    public String toString() {
        return "Name: " + name + System.lineSeparator() + "Code: " + id;
    }
}
