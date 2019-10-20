package com.by.evgeny.selection.committee.command;

import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.EnrolleService;

public class DeleteEnrolleById implements Command {

    @Override
    public void execute() {
        var service = new EnrolleService();

        System.out.println("Enter enrolle's ID: ");
        int id = ConsoleReader.nextInt();
        System.out.println("Are you sure you want to delete this applicant? (Print \"yes\")");
        String answer = ConsoleReader.nextString();
        if(answer != null)
            if(answer.toLowerCase().equals("yes")) {
                service.excludeById(id);
                System.out.println("Done.");
                return;
            }
        System.out.println("Aborted by user.");
    }
}