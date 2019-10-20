package com.by.evgeny.selection.committee.controller;

import com.by.evgeny.selection.committee.reader.ConsoleReader;

public class Controller {

    public static void main(String[] args) {
        Initialization.Init();

        int cmd = ConsoleReader.nextInt();
        try {
            while (cmd != 0) {
                ConsoleAdapter.getCommandByIndex(cmd).getCommand().execute();
                cmd = ConsoleReader.nextInt();
            }
            ConsoleAdapter
                    .getCommandByIndex(cmd)
                    .getCommand()
                    .execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
