package com.by.evgeny.selection.committee.command.implementations.Enrollees;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.creating.CreateEnrolle;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.EnrolleService;

public class UpdateEnrolleById implements Command {

    @Override
    public void execute() {
        var service = new EnrolleService();

        System.out.print("Enter enrolle's ID: ");
        int id = ConsoleReader.nextInt();
        if (service
                .getById(id)
                .isPresent()) {
            System.out.println("Are you sure you want to change enrolle's data? The previous values will be deleted (Print \"yes\")");
            String answer = ConsoleReader.nextString();
            if (answer != null) {
                if (answer.toLowerCase().equals("yes")) {
                    Enrolle enrolle = CreateEnrolle.create();
                    if (enrolle != null) {
                        service.updateById(id, enrolle);
                        System.out.println("Done.");
                    }
                }
                else
                    System.out.println("Aborted by user.");
            }
        }
        else
            System.out.println("Nothing found");
    }
}
