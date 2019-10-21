package com.by.evgeny.selection.committee.command.creating;

import com.by.evgeny.selection.committee.entity.Faculty;
import com.by.evgeny.selection.committee.singleton.SingletonFaculties;
import com.by.evgeny.selection.committee.utils.DataValidator;

public class CreateFaculty {

    public static Faculty create() {
        var name = EntryField.EnterString("name", DataValidator::checkFaculty);
        if (name == null)
            return null;

        var code = EntryField.EnterInt("code", DataValidator::checkFacultyCode);
        if (code < 0)
            return null;
        for (Faculty faculty: SingletonFaculties.getInstance().getFaculties()) {
            if(faculty.getCode() == code) {
                System.out.println("Faculty with such code already exists, please try again.");
                return null;
            }
        }

        return new Faculty(name, code);
    }
}
