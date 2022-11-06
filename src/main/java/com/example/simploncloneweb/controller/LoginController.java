package com.example.simploncloneweb.controller;

import com.example.simploncloneweb.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/login", "/home", "/logout"})
public class LoginController extends HttpServlet {
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

    protected void Mapping(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path)
        {
            case "/login":
            {
                if(session.getAttribute("role") == null)
                {
                    req.getRequestDispatcher("Auth/loginApprenantFormateur.jsp").forward(req, resp);
                }else{
                    resp.sendRedirect("/home");
                }
                break;
            }
            case "/home":
            {
                // check { formateur / apprenant }
                if(session.getAttribute("role") == null)
                {
                    String username = req.getParameter("username");
                    String password = req.getParameter("password");

                    if(LoginService.login(username, password).equals("apprenant"))
                    {
                        session.setAttribute("role", "apprenant");
                        resp.sendRedirect("/home");
                    }else if(LoginService.login(username, password).equals("formateur"))
                    {
                        session.setAttribute("role", "formateur");
                        resp.sendRedirect("/home");
                    }else{
                        resp.sendRedirect("/login");
                    }
                }else{
                    if(session.getAttribute("role") == "apprenant")
                    {
                        // redirect to "apprenant" Home;
                        req.getRequestDispatcher("./Apprenant/home.jsp").forward(req, resp);
                    }else if(session.getAttribute("role") == "formateur")
                    {
                        // redirect to "formateur" Home;
                        req.getRequestDispatcher("./Formateur/home.jsp").forward(req, resp);
                    }
                }
                break;
            }
            case "/logout":
            {
                session.removeAttribute("role");
                session.invalidate();
                resp.sendRedirect("/home");
                break;
            }
        }
    }
}
