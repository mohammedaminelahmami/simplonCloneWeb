package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.Entity.Apprenant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseDaoImplTest {
    @Test
    void checkIfExistTestWithValidUsername()
    {
        AuthDao<Apprenant> authDao = new AuthDao<>(Apprenant.class);
        assertTrue(authDao.checkIfExist("hichamov"));
    }

    @Test
    void loginWithValidUsernameAndPassword()
    {
        AuthDao<Apprenant> authDao = new AuthDao<>(Apprenant.class);
        assertTrue(authDao.login("amine0029", "amine0029"));
    }

    @Test
    void testToCharArray()
    {
        String name = "amine";
        char[] nameArray = name.toCharArray();
        System.out.println();
    }
}