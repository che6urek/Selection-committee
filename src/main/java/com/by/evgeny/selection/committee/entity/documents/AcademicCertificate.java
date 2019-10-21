package com.by.evgeny.selection.committee.entity.documents;

import javafx.beans.value.WritableMapValue;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class AcademicCertificate  implements Serializable {

    //private String educationalInstitution;
    //private int year;
    private int[] marks;
    private int averageMark;

    public AcademicCertificate(int[] marks) {
        this.marks = marks;
        calculateAverageMark();
    }

    public AcademicCertificate(){

    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
        calculateAverageMark();
    }

    public int getAverageMark() {
        return averageMark;
    }

    private void calculateAverageMark() {
        averageMark = 0;
        for (int mark: marks) {
            averageMark += mark;
        }
        averageMark = Math.round((float) averageMark / marks.length * 10);
    }

    public void setAverageMark(int averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), marks, averageMark);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        AcademicCertificate ac = (AcademicCertificate) obj;
        return Objects.equals(averageMark, ac.averageMark) &&
                Arrays.equals(marks, ac.marks);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Marks: ");
        if (marks.length > 0)
            result.append(marks[0]);
        for (int i = 1; i < marks.length; i++) {
            result.append(", ").append(marks[i]);
        }
        result.append(System.lineSeparator()).append("Average mark: ").append(averageMark);
        return result.toString();
    }
}
