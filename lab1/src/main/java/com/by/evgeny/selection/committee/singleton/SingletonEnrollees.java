package com.by.evgeny.selection.committee.singleton;

import com.by.evgeny.selection.committee.entity.crud.Enrollees;

public class SingletonEnrollees {

    private static Enrollees enrollees;

    private SingletonEnrollees(){

    }

    public static Enrollees getInstance() {
        if (enrollees == null){
            enrollees = new Enrollees();
        }
        return enrollees;
    }

    public static void init(Enrollees en) {
        if (enrollees == null) {
            enrollees = en;
        }
    }
}
