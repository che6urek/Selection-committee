package com.by.evgeny.selection.committee.singleton;

import com.by.evgeny.selection.committee.entity.crud.Faculties;

public class SingletonFaculties {

    private static Faculties faculties;

    private SingletonFaculties(){

    }

    public static Faculties getInstance() {
        if (faculties == null){
            faculties = new Faculties();
        }
        return faculties;
    }

    public static void init(Faculties en) {
        if (faculties == null) {
            faculties = en;
        }
    }
}
