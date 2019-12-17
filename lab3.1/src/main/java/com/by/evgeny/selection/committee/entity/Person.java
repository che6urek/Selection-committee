package com.by.evgeny.selection.committee.entity;

import java.util.Objects;

public abstract class Person extends Entity {

    private PersonalData personalData;
    private int specialtyId;

    public Person(PersonalData personalData, int specialtyId) {
        this.personalData = personalData;
        this.specialtyId = specialtyId;
    }

    public Person() {

    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return specialtyId == person.specialtyId &&
                personalData.equals(person.personalData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), personalData, specialtyId);
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + personalData.toString()+ System.lineSeparator()
                + "Speciality: " + specialtyId;
    }
}
