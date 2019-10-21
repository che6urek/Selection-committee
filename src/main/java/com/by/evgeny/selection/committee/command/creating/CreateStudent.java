package com.by.evgeny.selection.committee.command.creating;

import com.by.evgeny.selection.committee.entity.documents.PersonalData;
import com.by.evgeny.selection.committee.entity.person.Student;
import com.by.evgeny.selection.committee.utils.DataValidator;

public class CreateStudent {

    public static Student create() {
        var personalData = CreatePersonalData.create();

        var speciality = EntryField.EnterString("speciality", DataValidator::checkSpeciality);
        if (speciality == null)
            return null;

        var totalMark = EntryField.EnterInt("total mark", DataValidator::checkTotalMark);

        var ticketNo = EntryField.EnterInt("ticketNo.", DataValidator::checkPositive);

        return new Student(personalData, speciality, ticketNo, totalMark);
    }
}
