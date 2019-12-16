package com.by.evgeny.selection.committee.singleton;

public class IdGenerator {

    private static int id;

    private IdGenerator() {

    }

    public static int getNewId() {
        return ++id;
    }

    public static void init(int newId) {
        if (id < newId) {
            id = newId;
        }
    }
}
