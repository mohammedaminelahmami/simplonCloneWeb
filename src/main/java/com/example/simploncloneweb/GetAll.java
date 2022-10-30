package com.example.simploncloneweb;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class GetAll {
    public List<Apprenant> getAll()
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            Query query = entityManager.createNativeQuery("select * from apprenant");
            List<Apprenant> list = query.getResultList();
            PersistenceManager.commitTransaction(entityManager); // commit
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager); // rollback
            return null;
        }
    }
}