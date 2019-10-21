package com.by.evgeny.selection.committee.command.implementations.Students;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.creating.CreateStudent;
import com.by.evgeny.selection.committee.entity.person.Student;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;
import com.by.evgeny.selection.committee.service.StudentService;

public class UpdateStudentById implements Command {

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
            System.out.print("Enter students's ID: ");
            int id = ConsoleReader.nextInt();
            if (service
                    .getById(id)
                    .isPresent()) {
                System.out.println("Are you sure you want to change enrolle's data?"
                        + " The previous values will be deleted (Print \"yes\")");
                String answer = ConsoleReader.nextString();
                if (answer != null) {
                    if (answer.toLowerCase().equals("yes")) {
                        Student student = CreateStudent.create();
                        if (student != null) {
                            service.updateById(id, student);
                            System.out.println("Done.");
                        }
                    }
                    else
                        System.out.println("Aborted by user.");
                }
            } else
                System.out.println("Nothing found");
        }
        else {
            System.out.println("Nothing found");
        }
    }
}
