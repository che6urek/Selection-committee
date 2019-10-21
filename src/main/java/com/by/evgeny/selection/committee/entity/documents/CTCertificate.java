package com.by.evgeny.selection.committee.entity.documents;

import java.io.Serializable;
import java.util.Objects;

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
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject, mark);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        CTCertificate ct = (CTCertificate) obj;
        return Objects.equals(subject, ct.subject) &&
                Objects.equals(mark, ct.mark);
    }

    @Override
    public String toString() {
        return subject + ": " + mark;
    }
}
