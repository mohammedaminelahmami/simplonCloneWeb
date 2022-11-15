package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.dao.UseDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApprenantServiceTest {
    //NormalThread
    @Test
    void test()
    {
        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
        List<Apprenant> apprenant = useDao.getAllWhere("username", "amine0029");
        System.out.println(apprenant.get(0).getNom());
    }
}