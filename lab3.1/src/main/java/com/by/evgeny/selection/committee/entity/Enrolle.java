package com.by.evgeny.selection.committee.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Arrays;

public class Enrolle extends Person {

    @JacksonXmlElementWrapper(localName = "ctMarks")
    @JacksonXmlProperty(localName = "ctMark")
    private int[] ctMarks;
    private int schoolMark;
    private boolean medicalClearance;

    public Enrolle(int[] ctMarks, int schoolMark, boolean medicalClearance, PersonalData personalData, int specialtyId) {
        super(personalData, specialtyId);
        if(ctMarks.length != 3) {
            this.ctMarks = Arrays.copyOf(ctMarks, 3);
        }
        else {
            this.ctMarks = ctMarks;
        }
        this.schoolMark = schoolMark;
        this.medicalClearance = medicalClearance;
    }

    public Enrolle() {

    }

    public int getSchoolMark() {
        return schoolMark;
    }

    public void setSchoolMark(int schoolMark) {
        this.schoolMark = schoolMark;
    }

    public boolean isMedicalClearance() {
        return medicalClearance;
    }

    public void setMedicalClearance(boolean medicalClearance) {
        this.medicalClearance = medicalClearance;
    }

    public int[] getCtMarks() {
        return ctMarks;
    }

    public void setCtMarks(int[] ctMarks) {
        if(ctMarks.length != 3) {
            this.ctMarks = Arrays.copyOf(ctMarks, 3);
        }
        else {
            this.ctMarks = ctMarks;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Enrolle enrolle = (Enrolle) o;
        return Arrays.equals(ctMarks, enrolle.ctMarks);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(ctMarks);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString() + System.lineSeparator()
                + "Medical clearance: " + medicalClearance + System.lineSeparator()
                + "School mark: " + schoolMark + System.lineSeparator()
                + "CT marks: ");
        for (int mark: ctMarks) {
            result.append(mark).append(" ");
        }
        return result.toString();
    }
}
