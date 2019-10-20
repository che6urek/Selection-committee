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

        switch (ConsoleReader.nextInt()) {
            case 0:
                System.out.println(service.getAll());
                break;
            case 1:
                System.out.println(service.getAllSortedById());
                break;
            case 2:
                System.out.println(service.getAllSortedByName());
                break;
            case 3:
                System.out.println(service.getAllSortedByMark());
                break;
        }
    }
}
