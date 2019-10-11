package Entity.CRUD;

import java.util.Optional;

public interface CRUD<T> {

    void add(T entity);

    Optional<T> getById(int id);

    void update(int id, T entity);

    void delete(T entity);

    void deleteById(int id);

}