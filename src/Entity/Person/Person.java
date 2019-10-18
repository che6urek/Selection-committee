package Entity.Person;

import Entity.Documents.PersonalData;
import Entity.Entity;

public abstract class Person extends Entity  implements java.io.Serializable {
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
        return personalData.name + " " + personalData.surname + " " + personalData.patronymic;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + getFullName() + System.lineSeparator()
                + "Speciality: " + specialtyName;
    }
}
