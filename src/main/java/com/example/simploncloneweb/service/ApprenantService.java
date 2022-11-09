package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.dao.UseDaoImpl;

import java.util.List;

public class ApprenantService {

    final static UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);

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
            Apprenant apprenant = new Apprenant();

            apprenant.setUsername(username);
            apprenant.setPassword(password);
            apprenant.setEmail(email);
            apprenant.setNom(nom);
            apprenant.setPrenom(prenom);

            return useDao.save(apprenant);
        }else{
            System.out.println(msgError);
            return false;
        }
    }

    public static List<Apprenant> getAllApprenant()
    {
        // List "Apprenant"
        return useDao.getAll();
    }

    public static boolean updateApprenant(int id, String nom, String prenom, String email, String username, String password)
    {
        Apprenant apprenant = useDao.findById(id);

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

        // checkFields !

        if(msgError.equals(""))
        {
            apprenant.setUsername(username);
            apprenant.setPassword(password);
            apprenant.setEmail(email);
            apprenant.setNom(nom);
            apprenant.setPrenom(prenom);

            return useDao.update(apprenant);
        }else{
            return false;
        }
    }

    public static boolean deleteAccount(int id)
    {
        return useDao.delete(id);
    }
}




