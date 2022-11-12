package com.example.simploncloneweb.dao.interfaces;

import java.util.List;

public interface UseDao<T> {
    boolean save(T entityObj);
    boolean update(T entityObj);
    boolean delete(int id);
    T findById(int id);
    List<T> getAll();
    List<T> getAllWhere(String field, Object value);
}