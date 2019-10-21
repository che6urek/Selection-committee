package com.by.evgeny.selection.committee.entity.documents;

import java.io.Serializable;
import java.util.Objects;

public class MedicalCertificate  implements Serializable {

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
    public int hashCode() {
        return Objects.hash(super.hashCode(), allowed);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        MedicalCertificate mc = (MedicalCertificate) obj;
        return Objects.equals(allowed, mc.allowed);
    }

    @Override
    public String toString() {
        return "Allowed: " + allowed;
    }
}
