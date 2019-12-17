package com.by.evgeny.selection.committee.command;

import com.by.evgeny.selection.committee.command.common.*;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {

    FACULTIES_SHOW(new ShowFacultiesCommand()),
    SPECIALITIES_SHOW(new ShowSpecialitiesCommand()),
    STUDENTS_SHOW(new ShowStudentsCommand()),
    ENROLLEES_SHOW(new ShowEnrolleesCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCurrentCommand() {
        return command;
    }

    private static final Map<String, CommandType> lookup = new HashMap<>();

    static {
        for (CommandType env : CommandType.values()) {
            lookup.put(env.toString(), env);
        }
    }

    public static CommandType getCommand(String type) {
        return lookup.get(type);
    }
}
