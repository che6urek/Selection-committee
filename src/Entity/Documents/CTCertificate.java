package Entity.Documents;

public class CTCertificate  implements java.io.Serializable{
    //private int id;
    //private int year;
    //private Subject subject;
    private String subject;
    private int mark;

    public CTCertificate(String subject, int mark) {
        this.subject = subject;
        this.mark = mark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return subject + ": " + mark;
    }
}
