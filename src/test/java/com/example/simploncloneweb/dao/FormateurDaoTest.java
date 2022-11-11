package com.example.simploncloneweb.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormateurDaoTest {
    // normal thread
    @Test
    void getIdFormateurByUsername()
    {
        FormateurDao formateurDao = new FormateurDao();
        System.out.println(formateurDao.getIdFormateurByUsername("Youssef"));
    }
}