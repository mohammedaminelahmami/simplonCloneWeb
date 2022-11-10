package com.example.simploncloneweb.controller;

import com.example.simploncloneweb.Entity.Admin;
import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.Entity.Formateur;
import com.example.simploncloneweb.Entity.Promotion;
import com.example.simploncloneweb.service.AdminService;
import com.example.simploncloneweb.service.ApprenantService;
import com.example.simploncloneweb.service.FormateurService;
import com.example.simploncloneweb.service.PromotionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/login", "/dashboard", "/admin/users", "/admin/addPromo", "/admin/addAccount", "/admin/edit", "/admin/delete", "/admin/assign", "/admin/empeche", "/admin/logout"})
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

                    // getAll "promos"
                    List<Promotion> listPromotion = PromotionService.getAllPromotion();
                    req.setAttribute("listPromotion", listPromotion);

                    // getAll "promos --> false"
                    List<Promotion> listPromosFalse = PromotionService.getAllPromotionStatusFalse();
                    req.setAttribute("listPromosFalse", listPromosFalse);

                    req.getRequestDispatcher("../Admin/adminUsers.jsp").forward(req, resp);
                    return;
                }
                resp.sendRedirect("/admin/login");
                break;
            }
            case "/admin/addPromo":
            {
                String name = req.getParameter("name");
                String annee = req.getParameter("annee");
                boolean checkNull = name != null && annee != null;
                assert annee != null;
                if(PromotionService.addPromo(name, Integer.parseInt(annee)) && checkNull)
                {
                    resp.sendRedirect("/admin/users");
                    return;
                }
                System.out.println("error");
                resp.sendRedirect("/admin/users");
                break;
            }
            case "/admin/addAccount":
            {
                if(session.getAttribute("admin") != null)
                {
                    String username = req.getParameter("username");
                    String password = req.getParameter("password");
                    String email = req.getParameter("email");
                    String nom = req.getParameter("nom");
                    String prenom = req.getParameter("prenom");
                    boolean checkNull = username != null && password != null && email != null && nom != null && prenom != null;

                    boolean account = false;
                    if (req.getParameter("action").equals("apprenant")) {
                        //assert username != null;
                        account = ApprenantService.addAccount(username, password, email, nom, prenom) && checkNull;
                    } else if(req.getParameter("action").equals("formateur")){
                        //assert username != null;
                        account = FormateurService.addAccount(username, password, email, nom, prenom) && checkNull;
                    }

                    if(account)
                    {
                        resp.sendRedirect("/admin/users");
                    }else{
                        System.out.println("Error !!");
                        resp.sendRedirect("/admin/users");
                    }
                    return;
                }
                resp.sendRedirect("admin/login");
                break;
            }
            case "/admin/edit":
            {
                String getId = req.getParameter("id");

                String nom = req.getParameter("nom");
                String prenom = req.getParameter("prenom");
                String email = req.getParameter("email");
                String username = req.getParameter("username");
                String password = req.getParameter("password");

                if(req.getParameter("action").equals("apprenant"))
                {
                    if(ApprenantService.updateApprenant(Integer.parseInt(getId), nom, prenom, email, username, password))
                    {
                        resp.sendRedirect("/admin/users");
                        return;
                    }
                    resp.sendRedirect("/admin/users");
                }else if(req.getParameter("action").equals("formateur"))
                {
                    if(FormateurService.updateFormateur(Integer.parseInt(getId), nom, prenom, email, username, password))
                    {
                        resp.sendRedirect("/admin/users");
                        return;
                    }
                    resp.sendRedirect("/admin/users");
                }
                break;
            }
            case "/admin/delete":
            {
                String getId = req.getParameter("id");
                boolean account = false;

                if(req.getParameter("action").equals("apprenant"))
                {
                    account = ApprenantService.deleteAccount(Integer.parseInt(getId));
                }else if(req.getParameter("action").equals("formateur"))
                {
                    account = FormateurService.deleteAccount(Integer.parseInt(getId));
                }else if(req.getParameter("action").equals("promotion"))
                {
                    account = PromotionService.deletePromo(Integer.parseInt(getId));
                }
                if(account)
                {
                    resp.sendRedirect("/admin/users");
                    return;
                }
                resp.sendRedirect("/admin/users");
                System.out.println("errorDelete");
                break;
            }
            case "/admin/assign":
            {
                 // assign formateur to promo
                String idFormateur = req.getParameter("idFormateur");
                String promoName = req.getParameter("promoName");

                if(PromotionService.assignerFormateur(Integer.parseInt(idFormateur), promoName))
                {
                    resp.sendRedirect("/admin/users");
                    return;
                }
                System.out.println("errorAssign");
                resp.sendRedirect("/admin/users");
                break;
            }
            case "/admin/empeche":
            {
                // (!assign) promo from formateur
                String idFormateur = req.getParameter("idFormateur");
                if(PromotionService.empecherFormateur(Integer.parseInt(idFormateur)))
                {
                    resp.sendRedirect("/admin/users");
                    return;
                }
                resp.sendRedirect("/admin/users");
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