package com.finance.interfaces;

import java.util.List;

public interface GenericDAO<T> {
    void save(T object) throws Exception;
    void delete(int id) throws Exception;
    List<T> findAll(int userId) throws Exception;
}
