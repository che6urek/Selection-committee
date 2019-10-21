package com.by.evgeny.selection.committee.command.implementations.Students;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.creating.CreateStudent;
import com.by.evgeny.selection.committee.entity.person.Student;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;
import com.by.evgeny.selection.committee.service.StudentService;

public class AddStudent  implements Command {

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
            Student student = CreateStudent.create();
            if (student != null) {
                student.setSpecialtyName(specialityService
                        .getByCode(code)
                        .get()
                        .getName());
                service.add(student);
                System.out.println("Done.");
            }
        }
        else
            System.out.println("Nothing found");
    }
}
