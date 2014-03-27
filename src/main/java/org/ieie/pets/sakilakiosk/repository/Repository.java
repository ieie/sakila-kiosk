package org.ieie.pets.sakilakiosk.repository;

import java.util.Collection;

/**
 * Created by ievgenii on 3/9/14.
 */
public interface Repository<T> {

    T findById(long id);
    Collection<T> findAll();
    T save(T entity);
    void delete(T entity);
}
