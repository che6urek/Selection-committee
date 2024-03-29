package com.by.evgeny.selection.committee.entity.person;

import com.by.evgeny.selection.committee.entity.documents.PersonalData;

import java.util.Objects;

public class Student extends Person {

    //private int groupNo;
    private int ticketNo;
    private int totalMark;

    public Student(PersonalData personalData, String specialtyName, int ticketNo, int totalMark) {
        super(personalData, specialtyName);
        this.ticketNo = ticketNo;
        this.totalMark = totalMark;
    }

    public Student(PersonalData personalData, String specialtyName, int totalMark) {
        this(personalData, specialtyName, 0, totalMark);
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

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ticketNo, totalMark);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Student speciality = (Student) obj;
        return Objects.equals(ticketNo, speciality.ticketNo) &&
                Objects.equals(totalMark, speciality.totalMark);
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "TicketNo: " + ticketNo + System.lineSeparator()
                + "Total mark: " + totalMark;
    }
}
