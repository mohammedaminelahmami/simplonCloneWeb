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

}