package com.by.evgeny.selection.committee.command.implementations.Students;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;
import com.by.evgeny.selection.committee.service.StudentService;

public class DisplayStudents implements Command {

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
            System.out.println("How to display students?");
            System.out.println("0. Without sorting");
            System.out.println("1. Sorted by ID");
            System.out.println("2. Sorted by name");
            System.out.println("3. Sorted by total mark");

            String result = null;
            switch (ConsoleReader.nextInt()) {
                case 0:
                    result = service.getAll();
                    break;
                case 1:
                    result = service.getAllSortedById();
                    break;
                case 2:
                    result = service.getAllSortedByName();
                    break;
                case 3:
                    result = service.getAllSortedByMark();
                    break;
                default:
            }
            System.out.println(result == null || result.isBlank() ? "Nothing found" : result);
        }
        else
            System.out.println("Nothing found");
    }
}
