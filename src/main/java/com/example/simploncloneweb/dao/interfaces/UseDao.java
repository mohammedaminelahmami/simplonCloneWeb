package com.example.simploncloneweb.dao.interfaces;

import java.util.Collection;
import java.util.List;

public interface UseDao<T> {
    boolean save(T entityObj);
    boolean update(T entityObj);
    boolean delete(int id);
    List<T> get(int id);
    Collection<T> getAll();
}