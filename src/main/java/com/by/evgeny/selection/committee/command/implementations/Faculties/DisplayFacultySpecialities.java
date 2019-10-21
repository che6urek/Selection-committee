package com.by.evgeny.selection.committee.command.implementations.Faculties;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.FacultyService;
import com.by.evgeny.selection.committee.service.SpecialityService;

public class DisplayFacultySpecialities implements Command {

    @Override
    public void execute() {
        var service = new FacultyService();

        System.out.print("Enter faculty code: ");
        String result = service.getFacultySpecialities(ConsoleReader.nextInt());
        System.out.println(result.isBlank() ? "Nothing found" : result);
    }
}
