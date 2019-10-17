package Entity.Person;

import Entity.Documents.PersonalData;

//TODO make necessary or remove

public class Student extends Person {

    private int groupNo;
    //private int ticketNo;

    public Student(PersonalData personalData, String specialtyName, int groupNo) {
        super(personalData, specialtyName);
        this.groupNo = groupNo;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }
}
