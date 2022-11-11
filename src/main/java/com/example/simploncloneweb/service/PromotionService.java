package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Formateur;
import com.example.simploncloneweb.Entity.Promotion;
import com.example.simploncloneweb.dao.FormateurDao;
import com.example.simploncloneweb.dao.PromotionDao;
import com.example.simploncloneweb.dao.UseDaoImpl;

import java.util.List;

public class PromotionService {
    final static UseDaoImpl<Promotion> useDao = new UseDaoImpl<>(Promotion.class);
    final static PromotionDao pDao = new PromotionDao();
    final static UseDaoImpl<Formateur> useDaoF = new UseDaoImpl<>(Formateur.class);
    final static PromotionDao promotionDao = new PromotionDao();
    final static FormateurDao useDaoFF = new FormateurDao();
    public static boolean addPromo(String name, int annee)
    {
        // check
        Promotion promotion = new Promotion();

        promotion.setName(name);
        promotion.setAnnee(annee);
        promotion.setStatus(false);

        return useDao.save(promotion);
    }

    public static List<Promotion> getAllPromotion()
    {
        // List "Promos"
        return useDao.getAll();
    }

    public static String getPromoName(int promoId)
    {
        return promotionDao.getPromoName(promoId);
    }

    public static List<Promotion> getAllPromotionStatusFalse()
    {
        return promotionDao.getAllWhere();
    }

    public static boolean deletePromo(int id)
    {
        // getIdFormateurByIdPromo
        int idFormateur = pDao.findIdFormateur(id);
        if(idFormateur != -1)
        {
            Formateur formateur = useDaoF.findById(idFormateur);
            formateur.setStatus(false);
            useDaoF.update(formateur);
            return useDao.delete(id);
        }else{
            return useDao.delete(id);
        }
    }

    public static boolean assignerFormateur(int idFormateur, String promoName)
    {
        return promotionDao.assignerFormateur(idFormateur, promoName);
    }

    public static boolean empecherFormateur(int idFormateur)
    {
        return promotionDao.empecherFormateur(idFormateur);
    }


}