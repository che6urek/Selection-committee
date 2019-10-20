package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.controller.ConsoleAdapter;

public class Help implements Command {

    @Override
    public void execute() {
        System.out.println("Available commands:");
        for (ConsoleAdapter cmd : ConsoleAdapter.values()) {
            System.out.println(cmd.getIndex() + ". " + cmd.getDescription());
        }
    }
}
