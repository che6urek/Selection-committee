package com.by.evgeny.selection.committee.controller;

import com.by.evgeny.selection.committee.command.CommandType;
import static com.by.evgeny.selection.committee.command.CommandType.*;

import java.util.HashMap;
import java.util.Map;

public enum ConsoleAdapter {
    _0(0, "Exit", EXIT),
    _1(1, "Help", HELP),
    _2(2, "Display enrollees", DISPLAY_ENROLLEES),
    _4(4, "Delete enrolle by id", DELETE_ENROLLE_BY_ID),
    _5(5, "Display enrolle by id", DISPLAY_ENROLLE_BY_ID);

    private String message;
    private int index;
    private CommandType commandType;

    ConsoleAdapter(int index, String message, CommandType commandType) {
        this.index = index;
        this.message = message;
        this.commandType = commandType;
    }

    public int getIndex() {
        return index;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public String getMessage() {
        return message;
    }

    private static final Map<Integer, ConsoleAdapter> commandMap = new HashMap<>();

    static {
        for (ConsoleAdapter command : ConsoleAdapter.values()) {
            commandMap.put(command.index, command);
        }
    }

    public static CommandType getCommandByIndex(int number) {
        return commandMap.get(number).getCommandType();
    }
}
