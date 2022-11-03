package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Admin;
import com.example.simploncloneweb.dao.UseDaoImpl;

public class AdminService {

    public static boolean login(String username, String password)
    {
        UseDaoImpl<Admin> useDao = new UseDaoImpl<>(Admin.class);
        return useDao.login(username, password);
    }
}