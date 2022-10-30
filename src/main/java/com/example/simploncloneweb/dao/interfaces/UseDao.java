package com.example.simploncloneweb.dao.interfaces;

import java.util.List;

public interface UseDao<T> {
    void save(T entityObj);
    boolean update(int id, T entityObj);
    boolean delete(int id);
    T find(int id);
    List<T> getAll();
}