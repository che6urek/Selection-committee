package com.by.evgeny.selection.committee.entity.documents;

public class MedicalCertificate  implements java.io.Serializable{
    //private String[] illnesses;
    //private String healthGroup;
    //private String healthInstitution;
    //private LocalDate expirationDate;

    private boolean allowed;

    public MedicalCertificate(Boolean allowed) {
        this.allowed = allowed;
    }

    public MedicalCertificate() {

    }

    public boolean getAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    @Override
    public String toString() {
        return "Allowed: " + allowed;
    }
}
