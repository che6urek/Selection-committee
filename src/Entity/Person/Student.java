package Entity.Person;

import Entity.Documents.PersonalData;

public class Student extends Person {

    private int groupNo;
    //private int ticketNo;

    protected Student(PersonalData personalData, String specialtyName, int groupNo, int id) {
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
