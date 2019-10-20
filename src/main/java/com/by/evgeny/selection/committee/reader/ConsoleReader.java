package com.by.evgeny.selection.committee.reader;

import java.util.Scanner;

public class ConsoleReader {

    private static Scanner scanner = new Scanner(System.in);

    private ConsoleReader() {
    }

    public static int nextInt() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }

    public static String nextString(){
        if (scanner.hasNext()) {
            return scanner.next();
        }
        return null;
    }
}
