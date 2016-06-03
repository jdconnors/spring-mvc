package com.example.services;

import java.util.List;

/**
 * Created by jconnors on 6/2/16.
 */
public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
