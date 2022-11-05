package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AuthDao<T> {

    protected Class<T> entityClass;

    public AuthDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public boolean checkIfExist(String username)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try{
            Query query = entityManager.createQuery("select e.username from "+entityClass.getSimpleName()+" e where e.username = '"+username+"'", entityClass);
            PersistenceManager.commitTransaction(entityManager);
            return query.getResultList().size() > 0;
        }catch(Exception e)
        {
            PersistenceManager.rollbackTransaction(entityManager);
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String username, String password)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try{
            if(checkIfExist(username))
            {
                Query query = entityManager.createQuery("select e.password from "+entityClass.getSimpleName()+" e where e.username = '"+username+"'", entityClass);
                PersistenceManager.commitTransaction(entityManager);
                return query.getResultList().get(0).equals(password);
            }else{
                return false;
            }
        }catch(Exception e)
        {
            PersistenceManager.rollbackTransaction(entityManager);
            e.printStackTrace();
            return false;
        }
    }
}
