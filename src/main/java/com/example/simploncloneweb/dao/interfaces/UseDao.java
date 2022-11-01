package com.example.simploncloneweb.dao.interfaces;

import java.util.List;

public interface UseDao<T> {
    boolean save(T entityObj);
    boolean update(int id, T entityObj);
    boolean delete(int id);
    T findById(int id);
    List<T> getAll();
    boolean checkIfExist(String username);
    boolean login(String username, String password);
}
