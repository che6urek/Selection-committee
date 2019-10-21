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
    _5(5, "Display enrolle by id", DISPLAY_ENROLLE_BY_ID),
    _6(6, "Update enrolle by id", UPDATE_ENROLLE_BY_ID),
    _7(7, "Delete enrolle by id", DELETE_ENROLLE_BY_ID),
    _8(8, "Display specialities", DISPLAY_SPECIALITIES),
    _9(9, "Add speciality", ADD_SPECIALITY),
    _10(10, "Display speciality by code", DISPLAY_SPECIALITY_BY_CODE),
    _11(11, "Update speciality by code", UPDATE_SPECIALITY_BY_CODE),
    _12(12, "Delete speciality by code", DELETE_SPECIALITY_BY_CODE),
    _13(13, "Display speciality students", DISPLAY_STUDENTS),
    _14(14, "Add student", ADD_STUDENT),
    _15(15, "Display student by id", DISPLAY_STUDENT_BY_ID),
    _16(16, "Update student by id", UPDATE_STUDENT_BY_ID),
    _17(17, "Delete student by id", DELETE_STUDENT_BY_ID),
    _18(18, "Display faculties", DISPLAY_FACULTIES),
    _19(19, "Add faculty", ADD_FACULTY),
    _20(20, "Display faculty by code", DISPLAY_FACULTY_BY_CODE),
    _21(21, "Delete faculty by code", DELETE_FACULTY_BY_CODE),
    _22(22, "Display faculty specialities", DISPLAY_FACULTY_SPECIALITIES),
    _23(23, "Enroll", ENROLL),
    _24(24, "Display dictionary", DISPLAY_DICTIONARY),
    _25(25, "Edit dictionary", EDIT_DICTIONARY);


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
