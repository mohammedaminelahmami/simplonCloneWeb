package com.example.simploncloneweb.service;

import com.example.simploncloneweb.Entity.Brief;
import com.example.simploncloneweb.dao.UseDaoImpl;

import java.util.List;

public class BriefService {

    final static UseDaoImpl<Brief> useDao = new UseDaoImpl<>(Brief.class);
    public static boolean addBrief(String context, int deadline, int idPromo)
    {
        try{
            Brief brief = new Brief();

            brief.setContext(context);
            brief.setDeadline(deadline);
            brief.setPromoid(idPromo);
            brief.setStatus(false);

            return useDao.save(brief);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<Brief> getAllBriefsPromo(int idPromo)
    {
        try{
            return useDao.getAllWhere("promoid", idPromo);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean lanceBrief(int idBrief)
    {
        try{
            Brief rowBrief = useDao.findById(idBrief);
            rowBrief.setStatus(true);

            return useDao.update(rowBrief);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean deleteBrief(int idBrief)
    {
        try{
            return useDao.delete(idBrief);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean updateBrief(String context, int deadline, int idBrief)
    {
        try{
            Brief brief = useDao.findById(idBrief);

            brief.setContext(context);
            brief.setDeadline(deadline);

            return useDao.update(brief);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}