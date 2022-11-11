package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Formateur;
import com.example.simploncloneweb.Entity.Promotion;
import com.example.simploncloneweb.dao.ApprenantDao;
import com.example.simploncloneweb.dao.FormateurDao;
import com.example.simploncloneweb.dao.PromotionDao;
import com.example.simploncloneweb.dao.UseDaoImpl;

import java.util.List;

public class FormateurService {

    final static UseDaoImpl<Formateur> useDao = new UseDaoImpl<>(Formateur.class);
    final static UseDaoImpl<Promotion> useDaoP = new UseDaoImpl<>(Promotion.class);
    final static PromotionDao pDao = new PromotionDao();
    final static ApprenantDao appDao = new ApprenantDao();
    final static FormateurDao fDao = new FormateurDao();

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
            Formateur formateur = new Formateur();

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

    public static Formateur getOneFormateur(int id)
    {
        return useDao.findById(id);
    }

    public static boolean updateFormateur(int id, String nom, String prenom, String email, String username, String password)
    {
        Formateur formateur = useDao.findById(id);

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
            formateur.setUsername(username);
            formateur.setPassword(password);
            formateur.setEmail(email);
            formateur.setNom(nom);
            formateur.setPrenom(prenom);

            return useDao.update(formateur);
        }else{
            return false;
        }
    }

    public static boolean deleteAccount(int id)
    {
        int idPromo = pDao.findIdPromoByIdFormateur(id);
        if(idPromo != -1)
        {
            Promotion promotion = useDaoP.findById(idPromo);
            promotion.setStatus(false);
            useDaoP.update(promotion);
            return useDao.delete(id);
        }else{
            return useDao.delete(id);
        }
    }

    public static int getIdPromo(String username)
    {
        int idFormateur  = fDao.getIdFormateurByUsername(username);
        return pDao.findIdPromoByIdFormateur(idFormateur);
    }

    public static boolean assignApprenantToPromo(int idApprenant, String username)
    {
        // getIdPromoByUsername
        int idFormateur  = fDao.getIdFormateurByUsername(username);
        int idPromo = pDao.findIdPromoByIdFormateur(idFormateur);
        return appDao.updateApprenantPromo(idApprenant, idPromo);
    }
}