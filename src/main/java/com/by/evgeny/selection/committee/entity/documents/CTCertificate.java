package com.by.evgeny.selection.committee.entity.documents;

import java.io.Serializable;

public class CTCertificate  implements Serializable {

    //private int id;
    //private int year;
    //private Subject subject;
    private String subject;
    private int mark;

    public CTCertificate(String subject, int mark) {
        this.subject = subject;
        this.mark = mark;
    }

    public CTCertificate() {

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
