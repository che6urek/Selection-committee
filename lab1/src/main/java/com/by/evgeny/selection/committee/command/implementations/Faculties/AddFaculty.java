package com.by.evgeny.selection.committee.command.implementations.Faculties;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.creating.CreateFaculty;
import com.by.evgeny.selection.committee.command.creating.CreateSpeciality;
import com.by.evgeny.selection.committee.entity.Faculty;
import com.by.evgeny.selection.committee.entity.Speciality;
import com.by.evgeny.selection.committee.service.FacultyService;
import com.by.evgeny.selection.committee.service.SpecialityService;

public class AddFaculty implements Command {

    @Override
    public void execute() {
        var service = new FacultyService();

        Faculty faculty = CreateFaculty.create();
        if (faculty != null) {
            service.add(faculty);
            System.out.println("Done.");
        }
    }
}
