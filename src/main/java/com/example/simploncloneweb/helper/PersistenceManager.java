package com.example.simploncloneweb.helper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceManager {
    public static EntityManagerFactory emf;

    public static EntityManager getEntityManager()
    {
        if(emf == null)
        {
            emf = Persistence.createEntityManagerFactory("default");
        }
        return emf.createEntityManager();
    }

    public static EntityManager beginTransaction() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        return entityManager;
    }

    public static void commitTransaction(EntityManager em) {
        em.getTransaction().commit();
    }

    public static void rollbackTransaction(EntityManager em) {
        em.getTransaction().rollback();
    }
}