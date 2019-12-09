package com.by.evgeny.selection.committee.entity.person;

import com.by.evgeny.selection.committee.entity.documents.PersonalData;
import com.by.evgeny.selection.committee.entity.Entity;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Objects;

public abstract class Person extends Entity {

    private PersonalData personalData;
    private String specialtyName;

    public Person(PersonalData personalData, String specialtyName) {
        this.personalData = personalData;
        this.specialtyName = specialtyName;
    }

    public Person() {

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

    @JsonIgnore
    public String getFullName(){
        return personalData.getSurname() + " " + personalData.getName() + " " + personalData.getPatronymic();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialtyName, personalData);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Person person = (Person) obj;
        return Objects.equals(specialtyName, person.specialtyName) &&
                Objects.equals(personalData, person.personalData);
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + getFullName() + System.lineSeparator()
                + "Speciality: " + specialtyName;
    }
}
