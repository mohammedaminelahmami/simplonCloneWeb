package com.example.simploncloneweb.dao;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.Entity.Brief;
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
    void testFindByIdWithValidId()
    {
        UseDaoImpl<Brief> useDao = new UseDaoImpl<>(Brief.class);
        Brief brief = useDao.findById(8);
        assertNotNull(brief);
    }

//    @Test
//    void testGetWhereInvalidInfo()
//    {
//        UseDaoImpl<Apprenant> useDao = new UseDaoImpl<>(Apprenant.class);
//        assertNotNull(useDao.getWhere("id", 1));
//        //System.out.println(useDao.getWhere("id", 1).getIdpromo());
//    }
}