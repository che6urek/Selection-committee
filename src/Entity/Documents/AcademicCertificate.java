package Entity.Documents;

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
}
