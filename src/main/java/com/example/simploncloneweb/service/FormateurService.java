package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.Entity.Formateur;
import com.example.simploncloneweb.dao.UseDaoImpl;
import com.example.simploncloneweb.helper.Regex;

import java.util.List;

public class FormateurService {

    final static UseDaoImpl<Formateur> useDao = new UseDaoImpl<>(Formateur.class);
    final static Formateur formateur = new Formateur();

    public static boolean addAccount(String username, String password, String email, String nom, String prenom)
    {
        // Regex
//        boolean checkUsername = Regex.checkRegex("^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$" ,username);
//        boolean checkPassword = Regex.checkRegex("^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$" ,password);
//        boolean checkEmail = Regex.checkRegex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" ,email);
//        boolean checkNom = Regex.checkRegex("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" ,nom);
//        boolean checkPrenom = Regex.checkRegex("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" ,prenom);

        String msgError = "";

        // check field not empty
        if(username.isEmpty() || password.isEmpty() || email.isEmpty() || nom.isEmpty() || prenom.isEmpty())
        {
            msgError = "Required field";
        }

//        if(checkUsername && checkPassword && checkEmail && checkNom && checkPrenom)
//        {
//            msgError = "please enter correct fields";
//        }

        if(msgError.equals(""))
        {
            formateur.setUsername(username);
            formateur.setPassword(password);
            formateur.setEmail(email);
            formateur.setNom(nom);
            formateur.setPrenom(prenom);

            return useDao.save(formateur);
        }else{
            System.out.println(msgError);
            return false;
        }
    }

    public static List<Formateur> getAllFormateur()
    {
        // List "Formateur"
        return useDao.getAll();
    }
}