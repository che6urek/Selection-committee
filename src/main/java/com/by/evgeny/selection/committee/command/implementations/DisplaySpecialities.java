package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;

public class DisplaySpecialities implements Command {

    @Override
    public void execute() {
        var service = new SpecialityService();

        System.out.println("How to display enrollees?");
        System.out.println("0. Without sorting");
        System.out.println("1. Sorted by name");
        System.out.println("2. Sorted by places count");
        String result = null;
        switch (ConsoleReader.nextInt()) {
            case 0:
                result = service.getAll();
                break;
            case 1:
                result = service.getAllSortedByName();
                break;
            case 2:
                result = service.getAllSortedByPlaces();
                break;
            default:
        }
        System.out.println(result == null || result.isBlank() ? "Nothing found" : result);
    }
}
