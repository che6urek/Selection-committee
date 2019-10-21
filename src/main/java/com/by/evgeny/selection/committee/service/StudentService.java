package com.by.evgeny.selection.committee.service;

import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.entity.comparators.PersonByIdComparator;
import com.by.evgeny.selection.committee.entity.comparators.PersonByNameComparator;
import com.by.evgeny.selection.committee.entity.comparators.StudentByMarkComparator;
import com.by.evgeny.selection.committee.entity.crud.Students;
import com.by.evgeny.selection.committee.entity.person.Student;

import java.util.Optional;

public class StudentService {

    private Students students = new Students();
    private Speciality speciality = new Speciality();


    public StudentService(Speciality spec) {
        if (spec != null) {
            speciality = spec;
            if (speciality.getEnrolled() != null)
                students = speciality.getEnrolled();
            else
                speciality.setEnrolled(new Students());
        }
    }

    public Optional<Student> getById(int id) {
        return students.get(id);
    }

    public void updateById(int id, Student student) {
        if (SpecialityService.validateStudent(student) && speciality.getName().equals(student.getSpecialtyName()))
            students.update(id, student);
    }

    public void add(Student student){
        if (SpecialityService.validateStudent(student) && (speciality.getPlaces() -
                students.getStudents().size() > 0) && speciality.getName().equals(student.getSpecialtyName()))
            students.add(student);
    }

    public void deleteById(int id) {
        students.delete(id);
    }

    public String getAll() {
        return students.toString();
    }

    public String getAllSortedById() {
        students.getStudents().sort(new PersonByIdComparator());
        return students.toString();
    }

    public String getAllSortedByMark() {
        students.getStudents().sort(new StudentByMarkComparator());
        return students.toString();
    }

    public String getAllSortedByName() {
        students.getStudents().sort(new PersonByNameComparator());
        return students.toString();
    }
}
