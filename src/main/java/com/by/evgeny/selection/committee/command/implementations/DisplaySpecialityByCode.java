package com.by.evgeny.selection.committee.command.implementations;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.SpecialityService;

public class DisplaySpecialityByCode implements Command {

    @Override
    public void execute() {
        var service = new SpecialityService();

        System.out.print("Enter speciality code: ");
        service.getByCode(ConsoleReader.nextInt())
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nothing found"));
    }
}
