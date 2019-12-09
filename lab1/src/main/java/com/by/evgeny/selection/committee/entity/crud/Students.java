package com.by.evgeny.selection.committee.entity.crud;

import com.by.evgeny.selection.committee.entity.Entity;
import com.by.evgeny.selection.committee.entity.person.Student;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Students implements CRUD<Student> {

    private ArrayList<Student> students;
    private int maxId;

    public Students() {
        this.students = new ArrayList<Student>();
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public Optional<Student> get(int id) {
        return this.students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Student> get(String fullName) {
        return this.students.stream()
                .filter(s -> s.getFullName().equals(fullName))
                .findFirst();
    }

    @Override
    public void update(int id, Student newStudent) {
        this.students = this.students.stream()
                .map(s -> (s.getId() == id) ? newStudent : s)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void update(String fullName, Student newStudent) {
        this.students = this.students.stream()
                .map(e -> (e.getFullName().equals(fullName)) ? newStudent : e)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(int id) {
        students.removeIf(e -> e.getId() == id);
    }

    @Override
    public void delete(String fullName) {
        students.removeIf(e -> e.getFullName().equals(fullName));
    }

    @Override
    public void delete(Student student) {
        students.remove(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public void updateMaxId() {
        this.maxId = students.stream()
                .mapToInt(Entity::getId)
                .max().orElse(0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Students st = (Students) obj;
        return Objects.equals(students, st.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students);
    }

    @Override
    public String toString() {
        return students.stream()
                .map(Student::toString)
                .collect(Collectors.joining(System.lineSeparator() + System.lineSeparator()));
    }
}
