package com.by.evgeny.selection.committee.Entity.Documents;

public class PersonalData  implements java.io.Serializable{
    private String name;
    private String surname;
    private String patronymic;
    //public Gender gender;

    //public String passportNo;
    //public LocalDate dateOfBirth;

    public PersonalData(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
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
    public String toString() {
        return  "Name: " + name + System.lineSeparator() +
                "Surname: " + surname + System.lineSeparator() +
                "Patronymic: " + patronymic;
    }
}
