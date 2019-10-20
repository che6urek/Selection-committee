package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.CreateSpeciality;
import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.singleton.SingletonSpecialities;

public class AddSpeciality implements Command {

    @Override
    public void execute() {

        Speciality spec = CreateSpeciality.create();
        if (spec != null) {
            SingletonSpecialities.getInstance().add(spec);
            System.out.println("Done.");
        }
    }
}
