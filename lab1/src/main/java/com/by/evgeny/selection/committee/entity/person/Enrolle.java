package com.by.evgeny.selection.committee.entity.person;

import com.by.evgeny.selection.committee.entity.documents.AcademicCertificate;
import com.by.evgeny.selection.committee.entity.documents.CTCertificate;
import com.by.evgeny.selection.committee.entity.documents.MedicalCertificate;
import com.by.evgeny.selection.committee.entity.documents.PersonalData;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

/***
 * Class for university enrollees, contains enrolle's documents and personal data
 */
public class Enrolle extends Person {

    private ArrayList<CTCertificate> ctCertificates;
    private AcademicCertificate academicCertificate;
    private MedicalCertificate medicalCertificate;
    private int totalMark;

    /**
     * Class constructor specifying all fields
     */
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

    /**
     * Constructor without parameters (for serialization)
     */
    public Enrolle() {
        super();
    }

    /***
     * CT certificates getter
     * @return Returns enrolle's CT certificates
     */
    public ArrayList<CTCertificate> getCtCertificates() {
        return ctCertificates;
    }

    /***
     * CT certificates setter
     * @param ctCertificates New CT certificates to set
     */
    public void setCtCertificates(ArrayList<CTCertificate> ctCertificates) {
        this.ctCertificates = ctCertificates;
    }

    /***
     * Academic certificate getter
     * @return Returns enrolle's academic certificate
     */
    public AcademicCertificate getAcademicCertificate() {
        return academicCertificate;
    }

    /***
     * Academic certificate setter
     * @param academicCertificate New academic certificate to set
     */
    public void setAcademicCertificate(AcademicCertificate academicCertificate) {
        this.academicCertificate = academicCertificate;
    }

    /***
     * Medical certificate getter
     * @return Returns enrolle's medical certificate
     */
    public MedicalCertificate getMedicalCertificate() {
        return medicalCertificate;
    }

    /***
     * Academic certificate setter
     * @param medicalCertificate New medical certificate to set
     */
    public void setMedicalCertificate(MedicalCertificate medicalCertificate) {
        this.medicalCertificate = medicalCertificate;
    }

    /***
     * Total mark getter
     * @return Returns enrolle's total mark (for all CT and from academic certificate)
     */
    public int getTotalMark() {
        return totalMark;
    }

    /***
     * Total mark setter
     * @param totalMark New total mark to set
     */
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

    /***
     * Get all enrolle's data
     * @return String with each field on new line
     */
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
