package com.by.evgeny.selection.committee.entity.person;

import com.by.evgeny.selection.committee.command.implementations.Enroll;
import com.by.evgeny.selection.committee.entity.documents.AcademicCertificate;
import com.by.evgeny.selection.committee.entity.documents.CTCertificate;
import com.by.evgeny.selection.committee.entity.documents.MedicalCertificate;
import com.by.evgeny.selection.committee.entity.documents.PersonalData;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Enrolle extends Person {

    private ArrayList<CTCertificate> ctCertificates;
    private AcademicCertificate academicCertificate;
    private MedicalCertificate medicalCertificate;
    private int totalMark;

    public Enrolle(PersonalData personalData, String specialtyName, ArrayList<CTCertificate> ctCertificates,
                   AcademicCertificate academicCertificate, MedicalCertificate medicalCertificate) {
        super(personalData, specialtyName);

        this.ctCertificates = ctCertificates;
        this.academicCertificate = academicCertificate;
        this.medicalCertificate = medicalCertificate;
        totalMark = academicCertificate.getAverageMark();
        for (CTCertificate ct: ctCertificates) {
            totalMark += ct.getMark();
        }
    }

    public Enrolle() {
        super();
    }

    public ArrayList<CTCertificate> getCtCertificates() {
        return ctCertificates;
    }

    public void setCtCertificates(ArrayList<CTCertificate> ctCertificates) {
        this.ctCertificates = ctCertificates;
    }

    public AcademicCertificate getAcademicCertificate() {
        return academicCertificate;
    }

    public void setAcademicCertificate(AcademicCertificate academicCertificate) {
        this.academicCertificate = academicCertificate;
    }

    public MedicalCertificate getMedicalCertificate() {
        return medicalCertificate;
    }

    public void setMedicalCertificate(MedicalCertificate medicalCertificate) {
        this.medicalCertificate = medicalCertificate;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ctCertificates, academicCertificate, medicalCertificate, totalMark);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Enrolle enrolle = (Enrolle) obj;
        return Objects.equals(ctCertificates, enrolle.ctCertificates) &&
                Objects.equals(academicCertificate, enrolle.academicCertificate) &&
                Objects.equals(medicalCertificate, enrolle.medicalCertificate) &&
                Objects.equals(totalMark, enrolle.totalMark);
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + medicalCertificate.toString() + System.lineSeparator()
                + academicCertificate.toString() + "; "
                + ctCertificates.stream()
                    .map(CTCertificate::toString)
                    .collect(Collectors.joining("; ")) + System.lineSeparator()
                + "Total mark: " + totalMark;
    }
}
