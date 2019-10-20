package com.by.evgeny.selection.committee.entity.person;

import com.by.evgeny.selection.committee.entity.documents.PersonalData;

//TODO make necessary or remove

public class Student extends Person {

    //private int groupNo;
    private int ticketNo;
    private int totalMark;
    private String specialityName;

    public Student(PersonalData personalData, String specialtyName, int ticketNo, int totalMark, String specialityName) {
        super(personalData, specialtyName);
        this.ticketNo = ticketNo;
        this.totalMark = totalMark;
        this.specialityName = specialityName;
    }

    public Student(PersonalData personalData, String specialtyName, int totalMark, String specialityName) {
        this(personalData, specialtyName, 0, totalMark, specialityName);
    }

    public Student() {

    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "TicketNo: " + ticketNo + System.lineSeparator()
                + "Total mark: " + totalMark;
    }
}
