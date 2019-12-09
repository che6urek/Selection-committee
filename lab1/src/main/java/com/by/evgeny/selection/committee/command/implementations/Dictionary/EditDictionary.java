package com.by.evgeny.selection.committee.command.implementations.Dictionary;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.creating.EntryField;
import com.by.evgeny.selection.committee.reader.ConsoleReader;
import com.by.evgeny.selection.committee.service.DictionaryService;
import com.by.evgeny.selection.committee.utils.DataValidator;

public class EditDictionary implements Command {

    @Override
    public void execute() {
        var service = new DictionaryService();

        System.out.println("0. Exit");
        System.out.println("1. Add subject");
        System.out.println("2. Delete subject");
        System.out.println("3. Add speciality");
        System.out.println("4. Delete speciality");
        System.out.println("5. Add faculty");
        System.out.println("6. Delete faculty");

        String result = null;
        switch (ConsoleReader.nextInt()) {
            case 0:
                System.out.println("Aborted by user.");
                break;
            case 1:
                String word = EntryField.EnterString("subject", DataValidator::checkWords);
                if (word == null)
                    return;
                service.addSubject(word);
                System.out.println("Done.");
                break;
            case 2:
                word = EntryField.EnterString("subject", DataValidator::checkWords);
                if (word == null)
                    return;
                service.deleteSubject(word);
                System.out.println("Done.");
                break;
            case 3:
                word = EntryField.EnterString("speciality", DataValidator::checkWords);
                if (word == null)
                    return;
                service.addSpeciality(word);
                System.out.println("Done.");
                break;
            case 4:
                word = EntryField.EnterString("speciality", DataValidator::checkWords);
                if (word == null)
                    return;
                service.deleteSpeciality(word);
                System.out.println("Done.");
                break;
            case 5:
                word = EntryField.EnterString("faculty", DataValidator::checkWords);
                if (word == null)
                    return;
                service.addFaculty(word);
                System.out.println("Done.");
                break;
            case 6:
                word = EntryField.EnterString("faculty", DataValidator::checkWords);
                if (word == null)
                    return;
                service.deleteFaculty(word);
                System.out.println("Done.");
                break;
            default:
                System.out.println("Unknown command");
        }
    }
}
