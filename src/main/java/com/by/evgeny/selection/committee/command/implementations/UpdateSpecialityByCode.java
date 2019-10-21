package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.CreateSpeciality;
import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;
import com.by.evgeny.selection.committee.singleton.SingletonSpecialities;

public class UpdateSpecialityByCode implements Command {

    @Override
    public void execute() {
        var service = new SpecialityService();

        System.out.print("Enter enrolle's ID: ");
        int code = ConsoleReader.nextInt();
        if (service.getByCode(code).isPresent()) {
            System.out.println("Are you sure you want to change speciality data? " +
                    "The previous values will be deleted (Print \"yes\")");
            String answer = ConsoleReader.nextString();
            if (answer != null)
                if (answer.toLowerCase().equals("yes")) {
                    Speciality speciality = CreateSpeciality.create();
                    if (speciality != null) {
                        service.updateByCode(code, speciality);
                        System.out.println("Done.");
                    }
                }
            System.out.println("Aborted by user.");
        }
        else
            System.out.println("Nothing found");
    }
}
