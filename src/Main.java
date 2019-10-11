import Entity.CRUD.Enrollees;
import Entity.Documents.AcademicCertificate;
import Entity.Documents.CTCertificate;
import Entity.Documents.MedicalCertificate;
import Entity.Documents.PersonalData;
import Entity.Person.Enrolle;
import Serialization.XmlEnrolleesWrite;
import Serialization.XmlException;

import java.util.ArrayList;

public class Main {

    /* TODO DataValidator
    *       MVC
    *       UI
    *       javadoc
    *       serialization*/

    public static void main(String[] args) {
        Enrollees enrollees = new Enrollees();
        ArrayList<CTCertificate> ct = new ArrayList<CTCertificate>();
        ct.add(new CTCertificate("Russian", 90));
        ct.add(new CTCertificate("Math", 95));
        ct.add(new CTCertificate("Physics", 90));

        Enrolle enrolle1 = new Enrolle(new PersonalData("name", "surname", "pat"), "SPEC",
                ct, new AcademicCertificate(new int[] {10, 10, 8, 9}), new MedicalCertificate(true));
        enrollees.add(enrolle1);
        Enrolle enrolle2 = new Enrolle(new PersonalData("111", "222", "333"), "444",
                ct, new AcademicCertificate(new int[] {1, 1, 8, 9}), new MedicalCertificate(false));
        enrollees.update(1, enrolle2);
        enrollees.add(enrolle1);
        XmlEnrolleesWrite writer = new XmlEnrolleesWrite();
        try {
            writer.Write(enrollees, "enrollees.xml");
        }
        catch (XmlException e){
            System.out.println("error");
        }
        enrollees.delete(enrolle2);
        enrollees.deleteById(1);
        System.out.println("end");
    }
}
