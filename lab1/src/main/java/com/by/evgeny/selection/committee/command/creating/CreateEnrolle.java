package com.by.evgeny.selection.committee.command.creating;

import com.by.evgeny.selection.committee.entity.documents.AcademicCertificate;
import com.by.evgeny.selection.committee.entity.documents.CTCertificate;
import com.by.evgeny.selection.committee.entity.documents.MedicalCertificate;
import com.by.evgeny.selection.committee.entity.documents.PersonalData;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.utils.DataValidator;

import java.util.ArrayList;

public class CreateEnrolle {

    public static Enrolle create() {
        var personalData = CreatePersonalData.create();

        var speciality = EntryField.EnterString("speciality", DataValidator::checkSpeciality);
        if (speciality == null)
            return null;

        var len = EntryField.EnterInt("school marks count", DataValidator::checkMark);
        if (len < 1)
            return null;

        int[] marks = new int[len];
        for (int i = 0; i < len; i++) {
            marks[i] = EntryField.EnterInt("mark (" + (len - i) + " left)", DataValidator::checkSchoolMark);
            if (marks[i] < 0)
                return null;
        }

        len = EntryField.EnterInt("CT certificates count", DataValidator::checkMark);
        if (len < 2 || len > 4)
            return null;

        var ct = new ArrayList<CTCertificate>();
        for (int i = 0; i < len; i++) {
            System.out.println("Enter CT certificate (" + (len - i) + " left): ");
            var subject = EntryField.EnterString("subject", DataValidator::checkSubject);
            if (subject == null)
                return null;
            var mark = EntryField.EnterInt("mark", DataValidator::checkMark);
            if (mark < 0)
                return null;
            ct.add(new CTCertificate(subject, mark));
        }

        boolean allowed = false;
        System.out.println("Is enrolle allowed for medical reasons? (Print \"yes\")");
        String answer = ConsoleReader.nextString();
        if (answer != null)
            if (answer.toLowerCase().equals("yes"))
                allowed = true;

        return new Enrolle(personalData, speciality, ct, new AcademicCertificate(marks), new MedicalCertificate(allowed));
    }
}
