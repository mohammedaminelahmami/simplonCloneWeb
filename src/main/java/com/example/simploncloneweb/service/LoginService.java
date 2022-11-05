package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.Entity.Formateur;
import com.example.simploncloneweb.dao.AuthDao;

public class LoginService {
    final static AuthDao<Apprenant> authApp = new AuthDao<>(Apprenant.class);
    final static AuthDao<Formateur> authFor = new AuthDao<>(Formateur.class);

    // login { Apprenant | Formateur }
    public static String login(String username, String password)
    {
        String result = "";
        if(authApp.login(username, password))
        {
            result = "apprenant";
        }else if(authFor.login(username, password))
        {
            result = "formateur";
        }
        return result;
    }
}