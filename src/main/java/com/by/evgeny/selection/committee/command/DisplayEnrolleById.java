package com.by.evgeny.selection.committee.command;

import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.EnrolleService;

public class DisplayEnrolleById implements Command {

    @Override
    public void execute() {
        var service = new EnrolleService();

        System.out.print("Enter enrolle's ID: ");
        service.getById(ConsoleReader.nextInt())
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nothing found"));
    }
}
