package com.by.evgeny.selection.committee.service;

import com.by.evgeny.selection.committee.entity.Faculty;
import com.by.evgeny.selection.committee.entity.crud.Faculties;
import com.by.evgeny.selection.committee.entity.crud.Specialities;
import com.by.evgeny.selection.committee.singleton.SingletonFaculties;
import com.by.evgeny.selection.committee.singleton.SingletonSpecialities;
import com.by.evgeny.selection.committee.utils.DataValidator;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class FacultyService {

    private Faculties faculties = SingletonFaculties.getInstance();

    public Optional<Faculty> getByCode(int code) {
        return faculties.get(code);
    }

    public void updateByCode(int code, Faculty faculty) {
        if(validate(faculty))
            faculties.update(code, faculty);
    }

    public void add(Faculty faculty) {
        if(validate(faculty))
            faculties.add(faculty);
    }

    public void deleteByCode(int code){
        faculties.delete(code);
    }

    public String getAll(){
        return faculties.toString();
    }

    public String getFacultySpecialities(int code) {
        if(faculties.get(code).isPresent()) {
            String facultyName = faculties.get(code).get().getName();
            var temp = new Specialities();
            temp.setSpecialities(SingletonSpecialities.getInstance().getSpecialities().stream()
                    .filter(s -> s.getFacultyName().equals(facultyName))
                    .collect(Collectors.toCollection(ArrayList::new)));
            return temp.toString();
        }
        return null;
    }

    public boolean validate(Faculty faculty) {
        if (faculty == null)
            return false;
        if (faculty.getName() == null)
            return false;
        if (!DataValidator.checkFaculty(faculty.getName()) || !DataValidator.checkFacultyCode(faculty.getCode()))
            return false;
        for (Faculty f: faculties.getFaculties()) {
            if(faculty.getCode() == f.getCode())
                return false;
        }

        return true;
    }
}
