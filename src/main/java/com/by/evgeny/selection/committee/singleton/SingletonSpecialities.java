package com.by.evgeny.selection.committee.singleton;

import com.by.evgeny.selection.committee.entity.crud.Specialities;

public class SingletonSpecialities {

    private static Specialities specialities;

    private SingletonSpecialities(){

    }

    public static Specialities getInstance() {
        if (specialities == null){
            specialities = new Specialities();
        }
        return specialities;
    }

    public static void init(Specialities en) {
        if (specialities == null) {
            specialities = en;
        }
    }
}
