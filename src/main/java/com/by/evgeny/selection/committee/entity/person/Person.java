package com.by.evgeny.selection.committee.entity.person;

import com.by.evgeny.selection.committee.entity.documents.PersonalData;
import com.by.evgeny.selection.committee.entity.Entity;

public abstract class Person extends Entity {
    private PersonalData personalData;
    private String specialtyName;

    public Person(PersonalData personalData, String specialtyName) {
        this.personalData = personalData;
        this.specialtyName = specialtyName;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getFullName(){
        return personalData.getName() + " " + personalData.getSurname() + " " + personalData.getPatronymic();
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + getFullName() + System.lineSeparator()
                + "Speciality: " + specialtyName;
    }
}
