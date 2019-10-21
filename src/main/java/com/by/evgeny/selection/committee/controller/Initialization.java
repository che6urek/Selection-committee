package com.by.evgeny.selection.committee.controller;

import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.entity.crud.Enrollees;
import com.by.evgeny.selection.committee.entity.crud.Specialities;
import com.by.evgeny.selection.committee.entity.person.Student;
import com.by.evgeny.selection.committee.exceptions.XmlException;
import com.by.evgeny.selection.committee.reader.XmlReader;
import com.by.evgeny.selection.committee.singleton.IdGenerator;
import com.by.evgeny.selection.committee.singleton.SingletonEnrollees;
import com.by.evgeny.selection.committee.singleton.SingletonSpecialities;
import com.by.evgeny.selection.committee.utils.DataValidator;
import com.by.evgeny.selection.committee.utils.Dictionary;

import java.util.ArrayList;

public class Initialization {

    public static void Init() {

        var xmlEnrolleReader = new XmlReader<Enrollees>();
        try {
            Enrollees enrollees = xmlEnrolleReader.read("enrollees.xml", Enrollees.class);

            if (enrollees == null)
                enrollees = (new Enrollees());
            SingletonEnrollees.init(enrollees);
            enrollees.updateMaxId();
            IdGenerator.init(enrollees.getMaxId());
        }
        catch (Exception e) {
            if (e instanceof XmlException)
                System.out.println(e.getMessage());
        }

        var xmlSpecialitiesReader = new XmlReader<Specialities>();
        try {
            Specialities specialities = xmlSpecialitiesReader.read("specialities.xml", Specialities.class);

            if (specialities == null)
                specialities = (new Specialities());
            for (Speciality spec: specialities.getSpecialities()) {
                if (spec.getEnrolled() == null)
                    spec.setEnrolled((new ArrayList<Student>()));
            }
            SingletonSpecialities.init(specialities);
            specialities.updateMaxId();
            IdGenerator.init(specialities.getMaxId());
        }
        catch (Exception e) {
            if (e instanceof XmlException)
                System.out.println(e.getMessage());
        }

        var xmlDictionaryReader = new XmlReader<Dictionary>();
        try {
            Dictionary dictionary = xmlDictionaryReader.read("dictionary.xml", Dictionary.class);

            if (dictionary == null)
                dictionary = new Dictionary();
            if (dictionary.getSubjects() == null)
                dictionary.setSubjects(new ArrayList<String>());
            if (dictionary.getSpecialities() == null)
                dictionary.setSpecialities(new ArrayList<String>());
            if (dictionary.getFaculties() == null)
                dictionary.setFaculties(new ArrayList<String>());
            DataValidator.setDictionary(dictionary);
        }
        catch (Exception e) {
            if (e instanceof XmlException)
                System.out.println(e.getMessage());
        }
    }
}
