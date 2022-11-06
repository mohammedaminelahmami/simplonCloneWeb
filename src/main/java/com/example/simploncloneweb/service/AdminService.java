package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Admin;
import com.example.simploncloneweb.dao.AuthDao;
import com.example.simploncloneweb.dao.UseDaoImpl;

public class AdminService {

    public static boolean login(String username, String password)
    {
        UseDaoImpl<Admin> useDao = new UseDaoImpl<>(Admin.class);
        AuthDao<Admin> authDao = new AuthDao<>(Admin.class);
        if(username == null || password == null)
        {
            return false;
        }else{
            return authDao.login(username, password);
        }
    }


}