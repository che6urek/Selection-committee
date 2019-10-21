package com.by.evgeny.selection.committee.command.implementations.Faculties;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.FacultyService;
import com.by.evgeny.selection.committee.service.SpecialityService;

public class DisplayFaculties implements Command {

    @Override
    public void execute() {
        var service = new FacultyService();

        String result = service.getAll();
        System.out.println(result == null || result.isBlank() ? "Nothing found" : result);
    }
}
