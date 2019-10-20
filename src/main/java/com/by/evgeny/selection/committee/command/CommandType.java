package com.by.evgeny.selection.committee.command;

import com.by.evgeny.selection.committee.command.implementations.*;

//TODO add commands
public enum CommandType {
    EXIT                            (new Exit()),
    DISPLAY_ENROLLEES               (new DisplayEnrollees()),
    DISPLAY_ENROLLE_FOR_SPECIALITY  (new DisplayEnrolleesForSpeciality()),
    ADD_ENROLLE                     (new AddEnrolle()),
    DISPLAY_ENROLLE_BY_ID           (new DisplayEnrolleById()),
    UPDATE_ENROLLE_BY_ID            (new UpdateEnrolleById()),
    DELETE_ENROLLE_BY_ID            (new DeleteEnrolleById()),
    DISPLAY_SPECIALITIES            (new DisplaySpecialities()),
    DISPLAY_FACULTY_SPECIALITIES    (new DisplayFacultySpecialities()),
    ADD_SPECIALITY                  (new AddSpeciality()),
    DISPLAY_SPECIALITY_BY_CODE      (new DisplaySpecialityByCode()),
    DELETE_SPECIALITY_BY_CODE       (new DeleteSpecialityByCode()),
    UPDATE_SPECIALITY_BY_CODE       (new UpdateSpecialityByCode()),
    HELP                            (new Help());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
