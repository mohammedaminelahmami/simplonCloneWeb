package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.Entity.Apprenant;
import org.junit.jupiter.api.Test;

import java.util.List;


class UseDaoImplTest {

    @Test
    void testGetAll()
    {
        System.out.println("start-----------------------------------------------------");

        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
        List<Apprenant> list = useDao.getAll();


        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).getNom());
        }

        System.out.println("end-------------------------------------------------------");
    }

    @Test
    void testSave() {
        // test insert Record :
        System.out.println("start-----------------------------------------------------");

        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
        // new Objet
        Apprenant objetApprenant = new Apprenant();

        objetApprenant.setUsername("hichamov");
        objetApprenant.setPassword("hicham0029+0");
        objetApprenant.setEmail("medamine0029@gmail.com");
        objetApprenant.setNom("hicham");
        objetApprenant.setPrenom("El youssfi");

        useDao.save(objetApprenant);

        System.out.println("end-------------------------------------------------------");
    }

    @Test
    void testUpdate()
    {
        System.out.println("start-----------------------------------------------------");
        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
        Apprenant objetApprenant = new Apprenant();

        //

        System.out.println("end-------------------------------------------------------");
    }

    @Test
    void testFind()
    {
        System.out.println("start-----------------------------------------------------");

        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);

        Apprenant a = useDao.find(1);

        System.out.println(a.getNom());

        System.out.println("end-------------------------------------------------------");
    }

    @Test
    void testDelete()
    {
        System.out.println("start-----------------------------------------------------");

        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
        useDao.delete(2);

        System.out.println("end-------------------------------------------------------");
    }
}