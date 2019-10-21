package com.by.evgeny.selection.committee.command.creating;

import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.singleton.SingletonSpecialities;
import com.by.evgeny.selection.committee.utils.DataValidator;

public class CreateSpeciality {

    public static Speciality create() {
        var name = EntryField.EnterString("name", DataValidator::checkSpeciality);
        if (name == null)
            return null;

        var facultyName = EntryField.EnterString("faculty name", DataValidator::checkFaculty);
        if (facultyName == null)
            return null;

        var places = EntryField.EnterInt("places count", DataValidator::checkPositive);
        if (places < 0)
            return null;

        var code = EntryField.EnterInt("code", DataValidator::checkCode);
        if (code < 0)
            return null;

        for (Speciality spec: SingletonSpecialities.getInstance().getSpecialities()) {
            if (code == spec.getCode()) {
                System.out.println("Speciality with such code already exists. Please try again");
            }
        }

        var len = EntryField.EnterInt("CT subjects count", DataValidator::checkPositive);
        if (len < 2 || len > 3)
            return null;
        String[] subjects = new String[len];
        for (int i = 0; i < len; i++) {
            System.out.println("Enter subject (" + (len - i) + " left): ");
            subjects[i] = EntryField.EnterString("subject", DataValidator::checkWords);
            if (subjects[i] == null)
                return null;
        }

        return new Speciality(name, facultyName, places, subjects, code);
    }
}
