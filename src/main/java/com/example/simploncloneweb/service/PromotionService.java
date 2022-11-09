package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Promotion;
import com.example.simploncloneweb.dao.PromotionDao;
import com.example.simploncloneweb.dao.UseDaoImpl;

import java.util.List;

public class PromotionService {
    final static UseDaoImpl<Promotion> useDao = new UseDaoImpl<>(Promotion.class);
    final static PromotionDao promotionDao = new PromotionDao();
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

    public static List<Promotion> getAllPromotionStatusFalse()
    {
        return promotionDao.getAllWhere();
    }

    public static boolean deletePromo(int id)
    {
        return useDao.delete(id);
    }


}