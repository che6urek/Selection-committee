package com.by.evgeny.selection.committee.command.creating;

import com.by.evgeny.selection.committee.entity.documents.PersonalData;
import com.by.evgeny.selection.committee.utils.DataValidator;

public class CreatePersonalData {

    public static PersonalData create() {
        var surname = EntryField.EnterString("surname", DataValidator::checkName);
        if (surname == null)
            return null;

        var name = EntryField.EnterString("name", DataValidator::checkName);
        if (name == null)
            return null;

        var patronymic = EntryField.EnterString("patronymic", DataValidator::checkName);
        if (patronymic == null)
            return null;

        return new PersonalData(name, surname, patronymic);
    }
}
