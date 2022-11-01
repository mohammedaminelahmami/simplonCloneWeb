package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.Entity.Apprenant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseDaoImplTest {
    @Test
    void checkIfExistTestWithValidUsername()
    {
        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
        assertTrue(useDao.checkIfExist("hichamov"));
    }

    @Test
    void loginWithValidUsernameAndPassword()
    {
        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
        assertTrue(useDao.login("amine0029", "amine0029"));
    }
}