package org.ieie.plays.sakilaplay.jpa.repository;

import java.math.BigInteger;
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
