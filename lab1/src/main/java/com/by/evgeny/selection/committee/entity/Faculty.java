package com.by.evgeny.selection.committee.entity;

import java.io.Serializable;
import java.util.Objects;

public class Faculty implements Serializable {

    private String name;
    private int code;

    public Faculty() {

    }

    public Faculty(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, code);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Faculty faculty = (Faculty) obj;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(code, faculty.code);
    }

    @Override
    public String toString() {
        return name + System.lineSeparator() + "Code: " + code;
    }
}
