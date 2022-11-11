package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.Entity.Promotion;
import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ApprenantDao {

    public boolean updateApprenantPromo(int idApprenant, int idPromo)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try{
            Query query = entityManager.createQuery("UPDATE Apprenant a SET a.idpromo = :idPromo WHERE a.id = :idApprenant");
            query.setParameter("idPromo", idPromo);
            query.setParameter("idApprenant", idApprenant);

            query.executeUpdate();

            PersistenceManager.commitTransaction(entityManager);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager);
            return false;
        }finally {
            entityManager.close();
        }
    }

    public List<Apprenant> getAllApprenantAssignedToTHisPromo(int idPromo) {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            Query query = entityManager.createQuery("select t from Apprenant t where t.idpromo = :idPromo");
            query.setParameter("idPromo", idPromo);

            List<Apprenant> list = query.getResultList();
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