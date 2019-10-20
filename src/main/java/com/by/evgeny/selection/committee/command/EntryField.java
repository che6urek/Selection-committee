package com.by.evgeny.selection.committee.command;

import com.by.evgeny.selection.committee.reader.ConsoleReader;

public class EntryField {

    public static String EnterString(String fieldName, StringValidationInterface validation) {
        System.out.print("Enter " + fieldName + ": ");
        String str = ConsoleReader.nextString();
        if (validation.validate(str))
            return str;
        else {
            System.out.println("Invalid " + fieldName.split("[(]")[0].trim() + ", please try again.");
            return null;
        }
    }

    public static int EnterInt(String fieldName, IntValidationInterface validation) {
        System.out.print("Enter " + fieldName + ": ");
        int num = ConsoleReader.nextInt();
        if (validation.validate(num))
            return num;
        else {
            System.out.println("Invalid " + fieldName.split("[(]")[0].trim() + ", please try again.");
            return -1;
        }
    }
}
