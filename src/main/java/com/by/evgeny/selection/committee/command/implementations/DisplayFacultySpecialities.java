package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;

public class DisplayFacultySpecialities implements Command {

    @Override
    public void execute() {
        var service = new SpecialityService();

        System.out.print("Enter faculty name: ");
        String result = service.getFacultySpecialities(ConsoleReader.nextString());
        System.out.println(result.isBlank() ? "Nothing found" : result);
    }
}
