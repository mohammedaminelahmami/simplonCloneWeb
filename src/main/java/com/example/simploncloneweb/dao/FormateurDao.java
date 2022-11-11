package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.Entity.Formateur;
import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class FormateurDao {
    public int getIdFormateurByUsername(String username)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try{
            Query query = entityManager.createQuery("select t from Formateur t where t.username = :username");
            query.setParameter("username", username);

            Formateur formateur = (Formateur) query.getSingleResult();

            PersistenceManager.commitTransaction(entityManager);
            return formateur.getId();
        }catch(Exception e)
        {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager);
            return -1;
        }finally {
            entityManager.close();
        }
    }
}