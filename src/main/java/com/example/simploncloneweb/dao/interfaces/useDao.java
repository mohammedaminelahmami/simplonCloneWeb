package com.example.simploncloneweb.dao.interfaces;

import java.util.List;

public interface useDao<T> {
    public boolean save(T entityObj);
    public boolean update();
    public boolean delete();
    public List<T> get();
    public List<T> getAll();
}