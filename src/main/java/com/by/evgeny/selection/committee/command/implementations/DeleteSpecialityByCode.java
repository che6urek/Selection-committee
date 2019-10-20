package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;

public class DeleteSpecialityByCode implements Command {

    @Override
    public void execute() {
        var service = new SpecialityService();

        System.out.print("Enter speciality code: ");
        int code = ConsoleReader.nextInt();
        if(service.getByCode(code).isPresent()) {
            System.out.println("Are you sure you want to delete this speciality? (Print \"yes\")");
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