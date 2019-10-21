package com.by.evgeny.selection.committee.entity.comparators;

import com.by.evgeny.selection.committee.entity.person.Student;

import java.util.Comparator;

public class StudentByMarkComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student2.getTotalMark() - student1.getTotalMark();
    }
}
