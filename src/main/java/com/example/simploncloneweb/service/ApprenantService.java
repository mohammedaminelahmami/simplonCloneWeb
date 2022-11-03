package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.dao.UseDaoImpl;

public class ApprenantService {

    final static UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
    final static Apprenant apprenant = new Apprenant();
    public static boolean login(String username, String password)
    {
        return useDao.login(username, password);
    }

    public static boolean addAccount(String username, String password, String email, String nom, String prenom)
    {
        // Regex !!
        apprenant.setUsername(username);
        apprenant.setPassword(password);
        apprenant.setEmail(email);
        apprenant.setNom(nom);
        apprenant.setPrenom(prenom);

        return useDao.save(apprenant);
    }
}