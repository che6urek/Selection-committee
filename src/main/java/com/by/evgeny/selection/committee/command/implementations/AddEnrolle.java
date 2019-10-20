package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.CreateEnrolle;
import com.by.evgeny.selection.committee.entity.person.Enrolle;
import com.by.evgeny.selection.committee.singleton.SingletonEnrollees;

public class AddEnrolle implements Command {

    @Override
    public void execute() {

        Enrolle enrolle = CreateEnrolle.create();
        if (enrolle != null) {
            SingletonEnrollees.getInstance().add(enrolle);
            System.out.println("Done.");
        }
    }
}
