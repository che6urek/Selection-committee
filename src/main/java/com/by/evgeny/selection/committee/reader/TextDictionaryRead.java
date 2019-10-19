package com.by.evgeny.selection.committee.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TextDictionaryRead {
    public static ArrayList<String> readFile(String fileName)
    {
        try {
            return (ArrayList<String>) Files.readAllLines(Paths.get(fileName));
        }
        catch (IOException ex) {
            //TODO exception handling
            return new ArrayList<String>();
        }
    }
}
