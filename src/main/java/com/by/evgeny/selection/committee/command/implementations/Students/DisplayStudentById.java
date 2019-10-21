package com.by.evgeny.selection.committee.command.implementations.Students;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;
import com.by.evgeny.selection.committee.service.StudentService;

public class DisplayStudentById implements Command {

    @Override
    public void execute() {
        var specialityService = new SpecialityService();

        System.out.print("Enter speciality code: ");
        int code = ConsoleReader.nextInt();
        if (specialityService
                .getByCode(code)
                .isPresent()) {
            var service = new StudentService(specialityService
                    .getByCode(code)
                    .get());
            System.out.print("Enter student's ID: ");
            service.getById(ConsoleReader.nextInt())
                    .ifPresentOrElse(System.out::println, () -> System.out.println("Nothing found"));
        }
        else
            System.out.println("Nothing found");
    }
}
