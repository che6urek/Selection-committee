package com.by.evgeny.selection.committee.reader;

import java.util.Scanner;

public class ConsoleReader {

    private static Scanner scanner = new Scanner(System.in);

    private ConsoleReader() {
    }

    public static int nextSafeInt() {
        if (scanner.hasNext()) {
            return Integer.parseInt(scanner.next());
        }
        return 0;
    }

    public static int nextInt() {
        if (scanner.hasNext()) {
            try {
                return Integer.parseInt(scanner.next());
            }
            catch (Exception e)
            {
                return - 1;
            }
        }
        return -1;
    }

    public static String nextString() {
        if (scanner.hasNext()) {
            return scanner.next();
        }
        return null;
    }
}
