package com.by.evgeny.selection.committee.command.implementations.Dictionary;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.service.DictionaryService;

public class DisplayDictionary implements Command {

    @Override
    public void execute() {

        var service = new DictionaryService();
        String result = service.getAll();
        System.out.println(result == null || result.isBlank() ? "Nothing found" : result);
    }
}
