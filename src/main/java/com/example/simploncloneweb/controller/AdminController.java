package com.example.simploncloneweb.controller;

import com.example.simploncloneweb.Entity.Admin;
import com.example.simploncloneweb.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet({"/admin/login", "/dashboard", "/admin/logout"})
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            case "/admin/login":
            {
                HttpSession session = req.getSession();
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
                HttpSession session = req.getSession();
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
            case "/admin/logout":
            {
                HttpSession session = req.getSession();
                session.removeAttribute("user");
                session.invalidate();
                resp.sendRedirect("/admin/login");
                break;
            }
        }
    }
}