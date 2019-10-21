package com.by.evgeny.selection.committee.command.implementations.Faculties;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.FacultyService;
import com.by.evgeny.selection.committee.service.SpecialityService;

public class DeleteFacultyByCode implements Command {

    @Override
    public void execute() {
        var service = new FacultyService();

        System.out.print("Enter faculty code: ");
        int code = ConsoleReader.nextInt();
        if (service
                .getByCode(code)
                .isPresent()) {
            System.out.println("Are you sure you want to delete this faculty? (Print \"yes\")");
            String answer = ConsoleReader.nextString();
            if (answer != null)
                if (answer.toLowerCase().equals("yes")) {
                    service.deleteByCode(code);
                    System.out.println("Done.");
                    return;
                }
            System.out.println("Aborted by user.");
        }
        else
            System.out.println("Nothing found");
    }
}