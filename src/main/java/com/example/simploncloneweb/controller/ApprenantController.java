package com.example.simploncloneweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet()
public class ApprenantController extends HttpServlet {
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        Mapping(req, resp, session);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        Mapping(req, resp, session);
    }

    public void Mapping(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path)
        {

        }
    }
}