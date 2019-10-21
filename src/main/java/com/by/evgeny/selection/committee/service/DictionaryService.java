package com.by.evgeny.selection.committee.service;

import com.by.evgeny.selection.committee.utils.DataValidator;
import com.by.evgeny.selection.committee.utils.Dictionary;

public class DictionaryService {

    public Dictionary dictionary = DataValidator.getDictionary();

    public void addSubject(String subject) {
        if(DataValidator.checkWords(subject) && !DataValidator.checkSubject(subject))
            dictionary.addSubject(subject);
    }

    public void deleteSubject(String subject) {
        dictionary.deleteSubject(subject);
    }

    public void addSpeciality(String speciality) {
        if(DataValidator.checkWords(speciality) && !DataValidator.checkSpeciality(speciality))
            dictionary.addSpeciality(speciality);
    }

    public void deleteSpeciality(String speciality) {
        dictionary.deleteSpeciality(speciality);
    }

    public void addFaculty(String faculty) {
        if(DataValidator.checkWords(faculty) && !DataValidator.checkFaculty(faculty))
            dictionary.addFaculty(faculty);
    }

    public void deleteFaculty(String faculty) {
        dictionary.deleteFaculty(faculty);
    }

    public String getAll() {
        return dictionary.toString();
    }
}
