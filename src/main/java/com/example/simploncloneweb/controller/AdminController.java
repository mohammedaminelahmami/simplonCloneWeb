package com.example.simploncloneweb.controller;

import com.example.simploncloneweb.Entity.Admin;
import com.example.simploncloneweb.service.AdminService;
import com.example.simploncloneweb.service.ApprenantService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet({"/admin/login", "/dashboard", "/admin/addApprenant", "/admin/logout"})
public class AdminController extends HttpServlet {
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
            case "/admin/login":
            {
                if(session.getAttribute("admin") == null)
                {
                    req.getRequestDispatcher("../Admin/adminLogin.jsp").forward(req, resp);
                    return;
                }
                resp.sendRedirect("/dashboard");
                break;
            }
            case "/dashboard":
            {
                if(session.getAttribute("admin") == null)
                {
                    String username = req.getParameter("username");
                    String password = req.getParameter("password");

                    if(AdminService.login(username, password))
                    {
                        Admin admin = new Admin();
                        session.setAttribute("admin", admin);
                        resp.sendRedirect("/dashboard");
                    }else{
                        req.getRequestDispatcher("../Admin/adminLogin.jsp").forward(req, resp);
                    }
                }else{
                    req.getRequestDispatcher("./Admin/dashboard.jsp").forward(req, resp);
                }
                break;
            }
            case "/admin/addApprenant":
            {
                if(session.getAttribute("admin") != null)
                {
                    String username = req.getParameter("username");
                    String password = req.getParameter("password");
                    String email = req.getParameter("email");
                    String nom = req.getParameter("nom");
                    String prenom = req.getParameter("prenom");

                    if(ApprenantService.addAccount(username, password, email, nom, prenom))
                    {
                        resp.sendRedirect("/dashboard");
                    }else{
                        System.out.println("Error !!");
                    }
                    return;
                }
                resp.sendRedirect("admin/login");
                break;
            }
            case "/admin/logout":
            {
                session.removeAttribute("user");
                session.invalidate();
                resp.sendRedirect("/admin/login");
                break;
            }
        }
    }
}