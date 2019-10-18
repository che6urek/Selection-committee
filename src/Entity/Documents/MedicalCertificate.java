package Entity.Documents;

public class MedicalCertificate  implements java.io.Serializable{
    //private String[] illnesses;
    //private String healthGroup;
    //private String healthInstitution;
    //private LocalDate expirationDate;

    private boolean allowed;

    public MedicalCertificate(Boolean allowed) {
        this.allowed = allowed;
    }

    public boolean getAllowed() {
        return allowed;
    }

    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }
}