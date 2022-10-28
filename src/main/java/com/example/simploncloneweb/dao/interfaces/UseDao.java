package com.example.simploncloneweb.dao.interfaces;

import java.util.List;

public interface UseDao<T> {
    public boolean save(T entityObj);
    public boolean update(T entityObj);
    public boolean delete(int id);
    public List<T> get(int id);
    public List<T> getAll();
}