package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.Entity.Formateur;
import com.example.simploncloneweb.Entity.Promotion;
import com.example.simploncloneweb.helper.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;


public class PromotionDao {

    UseDaoImpl<Promotion> useDao = new UseDaoImpl<>(Promotion.class);
    UseDaoImpl<Formateur> useDaoF = new UseDaoImpl<>(Formateur.class);

    public List<Promotion> getAllWhere() {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            List<Promotion> list = entityManager.createQuery("select t from "+ Promotion.class.getSimpleName()+" t WHERE t.status = false", Promotion.class)
                    .getResultList();
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

    public int findIdByName(String name)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try{
            Query query = entityManager.createQuery("select t from Promotion t WHERE t.name = :name ");
            query.setParameter("name", name);

            Promotion promotion = (Promotion) query.getSingleResult();
            PersistenceManager.commitTransaction(entityManager);
            return promotion.getId(); // return (int) id
        }catch(Exception e)
        {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager);
            return -1;
        }finally {
            entityManager.close();
        }
    }

    public Promotion findPromoByIdFormateur(int idFormateur)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try{
            Query query = entityManager.createQuery("select t from Promotion t WHERE t.idformateur = :idFormateur");
            query.setParameter("idFormateur", idFormateur);
            Promotion promotion = (Promotion) query.getSingleResult();
            PersistenceManager.commitTransaction(entityManager);
            return promotion;
        }catch (Exception e)
        {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager);
            return null;
        }finally {
            entityManager.close();
        }
    }

    public boolean assignerFormateur(int idFormateur, String promoName)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            int idPromo = findIdByName(promoName); // getIdPromotion
            Promotion promotion = useDao.findById(idPromo); // findRowByIdPromotion
            Formateur formateur = useDaoF.findById(idFormateur); // findRowByIdFormateur

            formateur.setStatus(true);

            promotion.setIdformateur(idFormateur);
            promotion.setStatus(true);
            entityManager.merge(promotion);
            entityManager.merge(formateur);
            PersistenceManager.commitTransaction(entityManager); // commit
            return true;
        } catch (Exception e) {
            PersistenceManager.rollbackTransaction(entityManager); // rollback
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close(); // close
        }
    }

    public boolean empecherFormateur(int idFormateur)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try {
            Promotion promotion = findPromoByIdFormateur(idFormateur);
            Formateur formateur = useDaoF.findById(idFormateur); // findRowByIdFormateur

            formateur.setStatus(false);

            promotion.setIdformateur(null);
            promotion.setStatus(false);
            entityManager.merge(promotion);
            entityManager.merge(formateur);
            PersistenceManager.commitTransaction(entityManager); // commit
            return true;
        } catch (Exception e) {
            PersistenceManager.rollbackTransaction(entityManager); // rollback
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close(); // close
        }
    }

    public int findIdFormateur(int idPromo)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try{
            Query query = entityManager.createQuery("select t from Promotion t WHERE t.id = :idPromo");
            query.setParameter("idPromo", idPromo);
            Promotion promotion = (Promotion) query.getSingleResult();
            if(promotion.getIdformateur() == null)
            {
                return -1;
            }else{
                return promotion.getIdformateur();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager);
            return -1;
        }finally {
            entityManager.close();
        }
    }

    public int findIdPromoByIdFormateur(int idFormateur)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try{
            Query query = entityManager.createQuery("select t from Promotion t where t.idformateur = :idFormateur");
            query.setParameter("idFormateur", idFormateur);

            List<Promotion> promotions = query.getResultList();
            System.out.println(promotions.toString());
            if(promotions.size() == 0)
            {
                return -1;
            }else {
                int id = 0;
                for(Promotion promotion: promotions) {
                    id = promotion.getId();
                    break;
                }
                return id;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager);
            return -1;
        }finally {
            entityManager.close();
        }
    }

    public String getPromoName(int idPromo)
    {
        EntityManager entityManager = PersistenceManager.beginTransaction();
        try{
            Query query = entityManager.createQuery("select t from Promotion t where t.id = :idPromo");
            query.setParameter("idPromo", idPromo);

            Promotion promotion = (Promotion) query.getSingleResult();
            PersistenceManager.commitTransaction(entityManager);

            return promotion.getName();
        }catch(Exception e) {
            e.printStackTrace();
            PersistenceManager.rollbackTransaction(entityManager);
            return null;
        }finally {
            entityManager.close();
        }
    }
}