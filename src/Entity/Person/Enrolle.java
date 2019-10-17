package Entity.Person;

import Entity.Documents.AcademicCertificate;
import Entity.Documents.CTCertificate;
import Entity.Documents.MedicalCertificate;
import Entity.Documents.PersonalData;

import java.util.ArrayList;

public class Enrolle extends Person implements java.io.Serializable {
    private Boolean enrolled = false;
    private ArrayList<CTCertificate> ctCertificates;
    private AcademicCertificate academicCertificate;
    private MedicalCertificate medicalCertificate;
    private int TotalMark;

    public Enrolle(PersonalData personalData, String specialtyName, ArrayList<CTCertificate> ctCertificates,
                   AcademicCertificate academicCertificate, MedicalCertificate medicalCertificate) {
        super(personalData, specialtyName);

        this.ctCertificates = ctCertificates;
        this.academicCertificate = academicCertificate;
        this.medicalCertificate = medicalCertificate;
        TotalMark = academicCertificate.getAverageMark();
        for (CTCertificate ct: ctCertificates) {
            TotalMark += ct.getMark();
        }
    }

    public Boolean getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Boolean enrolled) {
        this.enrolled = enrolled;
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
        return TotalMark;
    }

    public void setTotalMark(int totalMark) {
        TotalMark = totalMark;
    }
}
