package com.by.evgeny.selection.committee.command;
//TODO add commands
public enum CommandType {
    EXIT                            (new Exit()),
    DISPLAY_ENROLLEES               (new DisplayEnrollees()),
    DISPLAY_ENROLLE_FOR_SPECIALITY  (new DisplayEnrolleesForSpeciality()),
    ADD_ENROLLE                     (new AddEnrolle()),
    DISPLAY_ENROLLE_BY_ID           (new DisplayEnrolleById()),
    DELETE_ENROLLE_BY_ID            (new DeleteEnrolleById()),
    HELP                            (new Help());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
