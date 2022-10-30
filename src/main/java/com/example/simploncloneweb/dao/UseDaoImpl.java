package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.dao.interfaces.UseDao;
import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.util.List;

public class UseDaoImpl<T> implements UseDao<T> {
    protected Class<T> entityClass;

    public UseDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    // insert record //
    @Override
    public boolean save(T entityObj) {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            entityManager.persist(entityObj);
            PersistenceManager.commitTransaction(entityManager);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager);
            return false;
        }
    }
    // ------------- //

    @Override
    public boolean update(T entityObj) {
        try {

            return true;
        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {

            return true;
        } catch (Exception e) {

            return false;
        }
    }

    // ????
    @Override
    public List<T> get(int id) {
        try {

            return null;
        } catch (Exception e) {
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
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager); // rollback
            return null;
        }
    }
}