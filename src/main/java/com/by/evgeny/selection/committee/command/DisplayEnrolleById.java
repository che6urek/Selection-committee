package com.by.evgeny.selection.committee.command;

import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.EnrolleService;

public class DisplayEnrolleById implements Command {

    @Override
    public void execute() {
        var service = new EnrolleService();

        System.out.println("Enter enrolle's ID: ");
        int id = ConsoleReader.nextInt();

        service.getById(id).ifPresent(System.out::println);
    }
}
