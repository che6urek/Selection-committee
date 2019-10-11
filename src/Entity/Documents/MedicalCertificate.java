package Entity.Documents;

public class MedicalCertificate  implements java.io.Serializable{
    //private String[] illnesses;
    //private String healthGroup;
    //private String healthInstitution;
    //private LocalDate expirationDate;

    private Boolean allowed;

    public MedicalCertificate(Boolean allowed) {
        this.allowed = allowed;
    }

    public Boolean getAllowed() {
        return allowed;
    }

    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }
}
