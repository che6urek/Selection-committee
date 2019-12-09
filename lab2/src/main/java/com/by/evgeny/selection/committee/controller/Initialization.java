package com.by.evgeny.selection.committee.controller;

import com.by.evgeny.selection.committee.entity.Faculty;
import com.by.evgeny.selection.committee.entity.SelectionCommittee;
import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.entity.person.Gender;
import com.by.evgeny.selection.committee.entity.person.PersonalData;
import com.by.evgeny.selection.committee.entity.person.Student;
import java.util.ArrayList;

public class Initialization {

    public static SelectionCommittee Init() {
        var enrollees = new ArrayList<Enrolle>();
        var students = new ArrayList<Student>();
        var faculties = new ArrayList<Faculty>();
        var specialities = new ArrayList<Speciality>();

        enrollees.add(new Enrolle(new int[] {10, 20, 30}, 40, true,
                new PersonalData("Ivanov", "Ivan", "Ivanovich", Gender.MALE), "SWIT"));
        enrollees.add(new Enrolle(new int[] {100, 100, 100}, 100, false,
                new PersonalData("Petrov", "Petr", "Petrovich", Gender.FEMALE), "CS"));

        students.add(new Student(new PersonalData("Ivanov", "Ivan", "Ivanovich", Gender.MALE),
                "SWIT", 85100090, 150));
        students.add(new Student(new PersonalData("Petrov", "Petr", "Petrovich", Gender.FEMALE),
                "CS", 85100001, 400));

        faculties.add(new Faculty("CSaN", 41));
        faculties.add(new Faculty("CT", 42));

        specialities.add(new Speciality("SWIT", 30, 0, 510));
        specialities.add(new Speciality("CS", 40, 0, 535));

        var selectionCommittee = new SelectionCommittee();

        selectionCommittee.setEnrollees(enrollees);
        selectionCommittee.setStudents(students);
        selectionCommittee.setFaculties(faculties);
        selectionCommittee.setSpecialities(specialities);

        return selectionCommittee;
    }
}
