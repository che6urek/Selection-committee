package com.by.evgeny.selection.committee.entity;

import com.by.evgeny.selection.committee.singleton.IdGenerator;

import java.io.Serializable;

public class Entity implements Serializable {

    private int id;

    public Entity() {
        this.id = IdGenerator.getNewId();
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Id: " + id;
    }
}
