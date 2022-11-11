package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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
}