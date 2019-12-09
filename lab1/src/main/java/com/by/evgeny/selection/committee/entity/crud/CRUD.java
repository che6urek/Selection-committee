package com.by.evgeny.selection.committee.entity.crud;

import java.io.Serializable;
import java.util.Optional;

public interface CRUD<T> extends Serializable {

    void add(T entity);

    Optional<T> get(String name);

    Optional<T> get(int id);

    void update(int id, T entity);

    void update(String name, T entity);

    void delete(T entity);

    void delete(int id);

    void delete(String name);

}