package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.Entity.Apprenant;
import org.junit.jupiter.api.Test;

import java.util.List;


class UseDaoImplTest {

    @Test
    void getAllTest()
    {
        System.out.println("start-----------------------------------------------------");

        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
        List<Apprenant> list = useDao.getAll();

        System.out.println(list);
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }

        System.out.println("end-------------------------------------------------------");
    }

    @Test
    void save() {
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
}




