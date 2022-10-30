package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.dao.interfaces.UseDao;
import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class UseDaoImpl<T> implements UseDao<T> {
    protected Class<T> entityClass;

    public UseDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(T entityObj) {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            entityManager.persist(entityObj);
            PersistenceManager.commitTransaction(entityManager);
        } catch (Exception e) {
            PersistenceManager.rollbackTransaction(entityManager);
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(int id, T entityObj) {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            entityManager.merge(entityObj);
            PersistenceManager.commitTransaction(entityManager);
            return true;
        } catch (Exception e) {
            PersistenceManager.rollbackTransaction(entityManager);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            T t = find(id);
            if(t != null)
            {
               T a = entityManager.merge(t);
                entityManager.remove(a);
            }
            PersistenceManager.commitTransaction(entityManager);
            return true;
        } catch (Exception e) {
            PersistenceManager.rollbackTransaction(entityManager);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public T find(int id) {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            T t = entityManager.find(entityClass, id);
            PersistenceManager.commitTransaction(entityManager);
            return t;
        } catch (Exception e) {
            PersistenceManager.rollbackTransaction(entityManager);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> getAll() {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            List<T> list = entityManager.createQuery("SELECT t from "+ entityClass.getSimpleName() + " t", entityClass).getResultList();
            PersistenceManager.commitTransaction(entityManager); // commit
            return list;
        } catch (Exception e) {
            PersistenceManager.rollbackTransaction(entityManager); // rollback
            e.printStackTrace();
            return null;
        }
    }
}