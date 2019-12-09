package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;
import com.by.evgeny.selection.committee.singleton.SingletonEnrollees;

public class Enroll implements Command {

    @Override
    public void execute() {
        var service = new SpecialityService();

        System.out.println("Lists of enrolled will be deleted. Are you sure you want to continue? (Print \"yes\")");
        String answer = ConsoleReader.nextString();
        if (answer != null)
            if (answer.toLowerCase().equals("yes")) {
                service.enroll(SingletonEnrollees.getInstance());
                System.out.println("Done.");
                return;
            }
        System.out.println("Aborted by user.");
    }
}
