package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.EnrolleService;

public class DeleteEnrolleById implements Command {

    @Override
    public void execute() {
        var service = new EnrolleService();

        System.out.print("Enter enrolle's ID: ");
        int id = ConsoleReader.nextInt();
        if (service.getById(id).isPresent()) {
            System.out.println("Are you sure you want to delete this enrolle? (Print \"yes\")");
            String answer = ConsoleReader.nextString();
            if (answer != null)
                if (answer.toLowerCase().equals("yes")) {
                    service.deleteById(id);
                    System.out.println("Done.");
                    return;
                }
            System.out.println("Aborted by user.");
        }
        else
            System.out.println("Nothing found");
    }
}