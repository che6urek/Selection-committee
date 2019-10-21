package com.by.evgeny.selection.committee.command.implementations.Enrollees;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.creating.CreateEnrolle;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.service.EnrolleService;
import com.by.evgeny.selection.committee.singleton.SingletonEnrollees;

public class AddEnrolle implements Command {

    @Override
    public void execute() {
        var service = new EnrolleService();

        Enrolle enrolle = CreateEnrolle.create();
        if (enrolle != null) {
            service.add(enrolle);
            System.out.println("Done.");
        }
    }
}
