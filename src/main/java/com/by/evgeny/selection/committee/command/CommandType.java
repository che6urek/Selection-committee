package com.by.evgeny.selection.committee.command;

public enum CommandType {
    TEST      (new Test()),
    TEST1     (new Test1());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
