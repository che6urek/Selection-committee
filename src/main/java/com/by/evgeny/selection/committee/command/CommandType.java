package com.by.evgeny.selection.committee.command;

import com.by.evgeny.selection.committee.command.implementations.*;
import com.by.evgeny.selection.committee.command.implementations.Dictionary.*;
import com.by.evgeny.selection.committee.command.implementations.Enrollees.*;
import com.by.evgeny.selection.committee.command.implementations.Specialities.*;
import com.by.evgeny.selection.committee.command.implementations.Students.*;

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
    DISPLAY_STUDENTS                (new DisplayStudents()),
    ADD_STUDENT                     (new AddStudent()),
    DISPLAY_STUDENT_BY_ID           (new DisplayStudentById()),
    UPDATE_STUDENT_BY_ID            (new UpdateStudentById()),
    DELETE_STUDENT_BY_ID            (new DeleteStudentById()),
    ENROLL                          (new Enroll()),
    DISPLAY_DICTIONARY              (new DisplayDictionary()),
    EDIT_DICTIONARY                 (new EditDictionary()),
    HELP                            (new Help());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
