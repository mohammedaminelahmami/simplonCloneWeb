package com.example.simploncloneweb;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.dao.UseDaoImpl;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("####| Start Main |####");

        // getAll
        UseDaoImpl<Apprenant> apprenant = new UseDaoImpl<>(Apprenant.class);
        System.out.println(apprenant.getAll());

        System.out.println("####| End Main |####");
    }
}