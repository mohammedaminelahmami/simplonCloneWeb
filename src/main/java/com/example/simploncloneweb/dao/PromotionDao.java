package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.Entity.Promotion;
import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;

import java.util.List;


public class PromotionDao {

    public List<Promotion> getAllWhere() {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            List<Promotion> list = entityManager.createQuery("select t from "+ Promotion.class.getSimpleName()+" t WHERE t.status = false", Promotion.class)
                    .getResultList();
            PersistenceManager.commitTransaction(entityManager); // commit
            return list;
        } catch (Exception e) {
            PersistenceManager.rollbackTransaction(entityManager); // rollback
            e.printStackTrace();
            return null;
        }finally {
            entityManager.close();
        }
    }
}