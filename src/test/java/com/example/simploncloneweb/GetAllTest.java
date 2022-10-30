package com.example.simploncloneweb;

import com.example.simploncloneweb.Entity.Apprenant;
import org.junit.jupiter.api.Test;

import java.util.List;

class GetAllTest {

    @Test
    void getAllApp()
    {
        GetAll g1 = new GetAll();
        List<Apprenant> list = g1.getAll();
        System.out.println(list);
    }

}