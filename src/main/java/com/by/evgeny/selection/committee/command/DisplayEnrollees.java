package com.by.evgeny.selection.committee.command;

import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.EnrolleService;

public class DisplayEnrollees implements Command {

    @Override
    public void execute() {
        var service = new EnrolleService();

        System.out.println("How to display enrollees?");
        System.out.println("0. Without sorting");
        System.out.println("1. Sorted by ID");
        System.out.println("2. Sorted by name");
        System.out.println("3. Sorted by total mark");

        String result = null;
        switch (ConsoleReader.nextInt()) {
            case 0:
                result = service.getAll();
                break;
            case 1:
                result = service.getAllSortedById();
                break;
            case 2:
                result = service.getAllSortedByName();
                break;
            case 3:
                result = service.getAllSortedByMark();
                break;
            default:
        }
        System.out.println(result == null || result.isEmpty() ? "Nothing found" : result);
    }
}
