package com.example.simploncloneweb.controller;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.service.ApprenantService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet({"/", "/home", "/logout"})
public class ApprenantController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Mapping(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Mapping(req, resp);
    }

    public void Mapping(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path)
        {
            case "/":
            {
                HttpSession session = req.getSession();
                if(session.getAttribute("user") == null)
                {
                    req.getRequestDispatcher("./Apprenant/apprenantLogin.jsp").forward(req, resp);
                    return;
                }
                req.getRequestDispatcher("./Apprenant/home.jsp").forward(req, resp);
                break;
            }
            case "/home":
            {
                HttpSession sessionT = req.getSession();
                if(sessionT.getAttribute("user") == null)
                {
                    String username = req.getParameter("username");
                    String password = req.getParameter("password");

                    if(ApprenantService.login(username, password))
                    {
                        Apprenant apprenant = new Apprenant();
                        HttpSession session = req.getSession();
                        session.setAttribute("user", apprenant);
                        req.getRequestDispatcher("./Apprenant/home.jsp").forward(req, resp);
                    }else{
                        req.getRequestDispatcher("./Apprenant/apprenantLogin.jsp").forward(req, resp);
                    }
                }else{
                    req.getRequestDispatcher("./Apprenant/home.jsp").forward(req, resp);
                }
                break;
            }
            case "/logout":
            {
                HttpSession session = req.getSession();
                session.removeAttribute("user");
                resp.sendRedirect("/");
                break;
            }
        }
    }
}