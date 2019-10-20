package com.by.evgeny.selection.committee.controller;

import com.by.evgeny.selection.committee.command.implementations.Help;
import com.by.evgeny.selection.committee.reader.ConsoleReader;

//TODO javadoc

public class Controller {

    public static void main(String[] args) {

        Initialization.Init();
        new Help().execute();

        int cmd = ConsoleReader.nextInt();
        try {
            while (cmd != 0) {
                try {
                    ConsoleAdapter.getCommandByIndex(cmd).getCommand().execute();
                }
                catch (Exception e) {
                    System.out.println("Unknown command");
                }
                cmd = ConsoleReader.nextInt();
            }
            ConsoleAdapter.getCommandByIndex(cmd).getCommand().execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
