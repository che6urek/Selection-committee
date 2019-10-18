package Entity;

import Entity.Person.IdGenerator;

public class Entity {
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
