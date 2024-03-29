package com.by.evgeny.selection.committee.command.implementations.Enrollees;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.EnrolleService;

public class DisplayEnrolleesForSpeciality implements Command {

    @Override
    public void execute() {
        var service = new EnrolleService();

        System.out.print("Enter speciality name: ");
        String result = service.getForSpeciality(ConsoleReader.nextString());
        System.out.println(result.isBlank() ? "Nothing found" : result);
    }
}
