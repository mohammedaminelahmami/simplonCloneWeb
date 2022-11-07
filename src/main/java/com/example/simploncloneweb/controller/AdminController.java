package com.example.simploncloneweb.controller;

import com.example.simploncloneweb.Entity.Admin;
import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.Entity.Formateur;
import com.example.simploncloneweb.service.AdminService;
import com.example.simploncloneweb.service.ApprenantService;
import com.example.simploncloneweb.service.FormateurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/login", "/dashboard", "/admin/users", "/admin/addApprenant", "/admin/addFormateur", "/admin/logout"})
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
            case "/admin/users":
            {
                if(session.getAttribute("admin") != null)
                {
                    // getAll "apprenant"
                    List<Apprenant> listApprenant = ApprenantService.getAllApprenant();
                    req.setAttribute("listApprenant", listApprenant);

                    // getAll "formateur"
                    List<Formateur> listFormateur = FormateurService.getAllFormateur();
                    req.setAttribute("listFormateur", listFormateur);

                    req.getRequestDispatcher("../Admin/adminUsers.jsp").forward(req, resp);
                    return;
                }
                resp.sendRedirect("/admin/login");
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

                    boolean checkNull = username != null && password != null && email != null && nom != null && prenom != null;

                    if(ApprenantService.addAccount(username, password, email, nom, prenom) && checkNull)
                    {
                        resp.sendRedirect("/dashboard");
                    }else{
                        resp.sendRedirect("/dashboard");
                    }
                    return;
                }
                resp.sendRedirect("admin/login");
                break;
            }
            case "/admin/addFormateur":
            {
                if(session.getAttribute("admin") != null)
                {
                    String username = req.getParameter("usernameF");
                    String password = req.getParameter("passwordF");
                    String email = req.getParameter("emailF");
                    String nom = req.getParameter("nomF");
                    String prenom = req.getParameter("prenomF");

                    boolean checkNull = username != null && password != null && email != null && nom != null && prenom != null;

                    if(FormateurService.addAccount(username, password, email, nom, prenom) && checkNull)
                    {
                        resp.sendRedirect("/dashboard");
                    }else{
                        System.out.println("Error !!");
                        resp.sendRedirect("/dashboard");
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