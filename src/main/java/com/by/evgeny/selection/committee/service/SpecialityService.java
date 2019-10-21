package com.by.evgeny.selection.committee.service;

import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.entity.comparators.*;
import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.entity.crud.Specialities;
import com.by.evgeny.selection.committee.entity.crud.Students;
import com.by.evgeny.selection.committee.entity.documents.CTCertificate;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.entity.person.Student;
import com.by.evgeny.selection.committee.singleton.SingletonSpecialities;
import com.by.evgeny.selection.committee.utils.DataValidator;

import java.time.Year;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class SpecialityService {

    private Specialities specialities = SingletonSpecialities.getInstance();

    public Optional<Speciality> getByCode(int code) {
        return specialities.get(code);
    }

    public void updateByCode(int code, Speciality spec) {
        if(validate(spec))
            specialities.update(code, spec);
    }

    public void add(Speciality spec) {
        if(validate(spec))
            specialities.add(spec);
    }

    public void deleteByCode(int code){
        specialities.delete(code);
    }

    public String getAll(){
        return specialities.toString();
    }

    public String getAllSortedByName() {
        specialities.getSpecialities().sort(new SpecialityByNameComparator());
        return specialities.toString();
    }

    public String getAllSortedByPlaces() {
        specialities.getSpecialities().sort(new SpecialityByPlacesComparator());
        return specialities.toString();
    }

    public String getFacultySpecialities(String facultyName) {
        var temp = new Specialities();
        temp.setSpecialities(specialities.getSpecialities().stream()
                .filter(e -> e.getFacultyName().equals(facultyName))
                .collect(Collectors.toCollection(ArrayList::new)));
        return temp.toString();
    }

    public String getEnrolledByCode(int code) {
        if (specialities.get(code).isPresent()) {
            Students students = specialities.get(code).get().getEnrolled();
            return students.getStudents().stream()
                    .map(Student::toString)
                    .collect(Collectors.joining(System.lineSeparator() + System.lineSeparator()));
        }
        return null;
    }

    public boolean validate(Speciality spec) {
        if (spec == null)
            return false;
        String[] subjects = spec.getRequiredSubjects();
        if (spec.getFacultyName() == null || spec.getName() == null
                || spec.getEnrolled() == null || subjects == null)
            return false;
        if (!DataValidator.checkWords(spec.getFacultyName()) || !DataValidator.checkWords(spec.getName()))
            return false;
        for (var subject: subjects) {
            if(!DataValidator.checkWords(subject))
                return false;
        }
        for (Student student: spec.getEnrolled().getStudents()) {
            if(!validateStudent(student))
                return false;
        }
        if (!DataValidator.checkCode(spec.getCode()))
            return false;
        for (Speciality speciality: specialities.getSpecialities()) {
            if(spec.getCode() == speciality.getCode())
                return false;
        }
        return spec.getPlaces() >= 0;
    }

    public static boolean validateStudent(Student student) {
        if (student == null)
            return false;

        if (student.getPersonalData() == null || student.getSpecialtyName() == null)
            return false;

        if (!DataValidator.checkMark(student.getTotalMark()))
            return false;

        if (!DataValidator.checkWords(student.getSpecialtyName()))
            return false;

        if (!DataValidator.checkPositive(student.getTicketNo()))
            return false;

        return DataValidator.checkName(student.getFullName());
    }

    public void enroll(Enrollees enrollees) {
        clear();
        ArrayList<Enrolle> en = enrollees.getEnrollees();
        en.sort(new EnrolleByMarkComparator());
        for (Enrolle enrolle: en) {
            Speciality spec = specialities.getSpecialities().stream()
                    .filter(e -> e.getName().equals(enrolle.getSpecialtyName()))
                    .findFirst()
                    .orElse(null);
            if (spec != null)
                if(checkSubjects(enrolle.getCtCertificates(), spec.getRequiredSubjects())) {
                    spec.enroll(new Student(enrolle.getPersonalData(), enrolle.getSpecialtyName(),
                            enrolle.getTotalMark()));
                }
        }
        generateTicketNo();
    }

    private void clear() {
        for (Speciality spec: specialities.getSpecialities()) {
            spec.setEnrolled(new Students());
        }
    }

    private void generateTicketNo() {
        for (Speciality spec: specialities.getSpecialities()) {
            int i = 0;
            var temp = new ArrayList<Student>(spec.getEnrolled().getStudents());
            temp.sort(new PersonByNameComparator());
            for (Student student: temp) {
                student.setTicketNo((Year.now().getValue() % 10) * 10000000 + spec.getCode() * 10000 + ++i);
            }
        }
    }

    private boolean checkSubjects(ArrayList<CTCertificate> ct, String[] subjects) {
        for (String subject: subjects) {
            if(ct.stream()
                    .noneMatch(c -> c.getSubject().equals(subject)))
                return false;
        }
        return true;
    }
}
