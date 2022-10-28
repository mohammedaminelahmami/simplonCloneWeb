package com.example.simploncloneweb;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.dao.UseDaoImpl;

import java.util.List;

public class ApprenantService extends UseDaoImpl<Apprenant> {
    public ApprenantService()
    {
        super(Apprenant.class);
    }

    @Override
    public List<Apprenant> getAll() {
        return super.getAll();
    }
}