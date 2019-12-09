package com.by.evgeny.selection.committee.entity;

import com.by.evgeny.selection.committee.singleton.IdGenerator;

import java.io.Serializable;
import java.util.Objects;

public class Entity implements Serializable {

    private int id;

    public Entity() {
        this.id = IdGenerator.getNewId();
    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entity entity = (Entity) obj;
        return id == entity.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Id: " + id;
    }
}
