package com.by.evgeny.selection.committee.command.creating;

import com.by.evgeny.selection.committee.entity.documents.PersonalData;
import com.by.evgeny.selection.committee.entity.person.Student;
import com.by.evgeny.selection.committee.utils.DataValidator;

public class CreateStudent {

    public static Student create() {
        var personalData = CreatePersonalData.create();

        var speciality = "";

        var totalMark = EntryField.EnterInt("total mark", DataValidator::checkTotalMark);
        if(totalMark < 0)
            return null;

        var ticketNo = EntryField.EnterInt("ticketNo.", DataValidator::checkPositive);
        if (ticketNo < 0)
            return null;

        return new Student(personalData, speciality, ticketNo, totalMark);
    }
}
