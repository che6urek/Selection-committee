package Entity.Documents;

import java.util.ArrayList;

public class AcademicCertificate  implements java.io.Serializable{
    //private String educationalInstitution;
    //private int year;
    private int[] marks;
    private int averageMark;

    public AcademicCertificate(int[] marks){
        this.marks = marks;
        calculateAverageMark();
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Marks: ");
        if(marks.length > 0)
            result.append(marks[0]);
        for (int i = 1; i < marks.length; i++) {
            result.append(", ").append(marks[i]);
        }
        result.append(System.lineSeparator()).append("Average mark: ").append(averageMark);
        return result.toString();
    }
}
