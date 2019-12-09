package com.by.evgeny.selection.committee.entity.person;

import java.io.Serializable;
import java.util.Objects;

public class PersonalData  implements Serializable {

    private String name;
    private String surname;
    private String patronymic;
    private Gender gender;


    public PersonalData(String name, String surname, String patronymic, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
    }

    public PersonalData() {

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalData that = (PersonalData) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(patronymic, that.patronymic) &&
                gender == that.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, gender);
    }

    @Override
    public String toString() {
        return  "Name: " + name + System.lineSeparator() +
                "Surname: " + surname + System.lineSeparator() +
                "Patronymic: " + patronymic + System.lineSeparator() +
                "Gender: " + gender;
    }
}
