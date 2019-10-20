package com.by.evgeny.selection.committee.command;

import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.EnrolleService;

public class DisplayEnrolleesForSpeciality implements Command {

    @Override
    public void execute() {
        var service = new EnrolleService();

        System.out.println("Enter speciality name: ");
        String result = service.getForSpeciality(ConsoleReader.nextString());
        System.out.println(result.isEmpty() ? "Nothing found" : result);
    }
}
