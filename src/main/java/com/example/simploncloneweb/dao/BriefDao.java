package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.Entity.Brief;
import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class BriefDao {
    public List<Brief> getAllBriefsPromo(int idPromo) {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            Query query = entityManager.createQuery("SELECT t from Brief t where t.promoid = :idPromo and t.status = true");
            query.setParameter("idPromo", idPromo);

            List<Brief> list = query.getResultList();
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
