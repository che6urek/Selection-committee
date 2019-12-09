package com.by.evgeny.selection.committee.command.implementations.Faculties;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.FacultyService;
import com.by.evgeny.selection.committee.service.SpecialityService;

public class DisplayFacultyByCode implements Command {

    @Override
    public void execute() {
        var service = new FacultyService();

        System.out.print("Enter faculty code: ");
        service.getByCode(ConsoleReader.nextInt())
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nothing found"));
    }
}
