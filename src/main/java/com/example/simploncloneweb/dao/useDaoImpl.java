package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.dao.interfaces.useDao;
import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;

abstract class useDaoImpl<T> implements useDao<T> {
    EntityManager entityManager;

    public useDaoImpl()
    {
        this.entityManager = PersistenceManager.getEntityManager();
    }

    @Override
    public boolean save(T entityObj) {
        try{
            entityManager.getTransaction().begin(); // Begin Transaction
            entityManager.persist(entityObj); // persist " insert record "
            entityManager.getTransaction().commit(); // commit
            return true;
        }catch (Exception e)
        {
            System.out.println("error => "+e);
            entityManager.getTransaction().rollback(); // rollback
            return false;
        }
    }

}