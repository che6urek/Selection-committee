package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;

public class DisplayEnrolledByCode implements Command {

    @Override
    public void execute() {
        var service = new SpecialityService();

        System.out.print("Enter speciality code: ");
        int code = ConsoleReader.nextInt();
        if (service.getByCode(code).isPresent()) {
            String result = service.getEnrolledByCode(code);
            System.out.println(result.isBlank() ? "Nothing found" : result);
        }
        else
            System.out.println("Nothing found");
    }
}
