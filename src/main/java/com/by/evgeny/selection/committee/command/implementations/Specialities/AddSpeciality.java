package com.by.evgeny.selection.committee.command.implementations.Specialities;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.creating.CreateSpeciality;
import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.service.SpecialityService;
import com.by.evgeny.selection.committee.singleton.SingletonSpecialities;

public class AddSpeciality implements Command {

    @Override
    public void execute() {
        var service = new SpecialityService();

        Speciality spec = CreateSpeciality.create();
        if (spec != null) {
            service.add(spec);
            System.out.println("Done.");
        }
    }
}
