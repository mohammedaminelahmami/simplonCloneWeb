package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.dao.UseDaoImpl;

public class ApprenantService {

    public static boolean login(String username, String password)
    {
        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
        return useDao.login(username, password);
    }

    public static void logout()
    {

    }
}