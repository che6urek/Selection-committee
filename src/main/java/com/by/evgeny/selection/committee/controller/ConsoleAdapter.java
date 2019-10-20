package com.by.evgeny.selection.committee.controller;

import com.by.evgeny.selection.committee.command.CommandType;
import static com.by.evgeny.selection.committee.command.CommandType.*;

import java.util.HashMap;
import java.util.Map;

public enum ConsoleAdapter {
    _0(0, "Exit", EXIT),
    _1(1, "Help", HELP),
    _2(2, "Display enrollees", DISPLAY_ENROLLEES),
    _3(3, "Display enrollees for speciality", DISPLAY_ENROLLE_FOR_SPECIALITY),
    _4(4, "Add enrolle", ADD_ENROLLE),
    _5(5, "Delete enrolle by id", DELETE_ENROLLE_BY_ID),
    _6(6, "Display enrolle by id", DISPLAY_ENROLLE_BY_ID);


    private String description;
    private int index;
    private CommandType commandType;

    ConsoleAdapter(int index, String description, CommandType commandType) {
        this.index = index;
        this.description = description;
        this.commandType = commandType;
    }

    public int getIndex() {
        return index;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public String getDescription() {
        return description;
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
