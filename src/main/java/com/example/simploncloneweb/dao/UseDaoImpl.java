package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.dao.interfaces.UseDao;
import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.List;

public class UseDaoImpl<T> implements UseDao<T> {
    protected Class<T> entityClass;
    protected List<T> list = new ArrayList<>();

    public UseDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public boolean save(T entityObj) {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            return true;
        } catch (Exception e) {

            return false;
        }
    }

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

            return list;
        } catch (Exception e) {

            return list;
        }
    }

    @Override
    public List<T> getAll() {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            List<T> list = entityManager.createQuery("from " + entityClass.getSimpleName(), entityClass)
                    .getResultList();
            PersistenceManager.commitTransaction(entityManager); // commit
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager); // rollback
            return null;
        }
    }
}