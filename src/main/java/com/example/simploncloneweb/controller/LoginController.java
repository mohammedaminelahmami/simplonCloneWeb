package com.example.simploncloneweb.controller;

import com.example.simploncloneweb.Entity.Apprenant;
import com.example.simploncloneweb.Entity.Brief;
import com.example.simploncloneweb.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet({"/login", "/home", "/logout"})
public class LoginController extends HttpServlet {
    HttpSession session;
    boolean drop = true;
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
                        session.setAttribute("username", username);
                        resp.sendRedirect("/home");
                    }else if(LoginService.login(username, password).equals("formateur"))
                    {
                        session.setAttribute("role", "formateur");
                        session.setAttribute("username", username);
                        resp.sendRedirect("/home");
                    }else{
                        resp.sendRedirect("/login");
                    }
                }else{
                    if(session.getAttribute("role") == "apprenant")
                    {
                        String usernameApprenant = (String) session.getAttribute("username");
                        // getIdPromo
                        int idPromo = ApprenantService.getIdApprenant(usernameApprenant);
                        // getAllBriefs

                         List<Brief> briefs = BriefService.getAllBriefsPromoFalse(idPromo);
                         req.setAttribute("briefs", briefs);
                        // redirect to "apprenant" Home;
                        req.getRequestDispatcher("./Apprenant/home.jsp").forward(req, resp);
                    }else if(session.getAttribute("role") == "formateur")
                    {
                        if(drop)
                        {
                            System.out.println("if");
                            // redirect to "formateur" Home;
                            // getAll "apprenant"
//                        List<Apprenant> listApprenant = ApprenantService.getAllApprenant();
//                        req.setAttribute("listApprenant", listApprenant);

                            String usernameFromSession = (String) session.getAttribute("username");

                            // getIdPromo
                            int getPromoId = FormateurService.getIdPromo(usernameFromSession);
                            session.setAttribute("idPromo", getPromoId);

                            // getPromoName
                            String promoName = PromotionService.getPromoName(getPromoId);
                            session.setAttribute("promoName", promoName);

                            // getAllApprenantAssignedToTHisPromo
                            List<Apprenant> listApprenantAssigned = ApprenantService.getAllApprenantAssignedToTHisPromo(getPromoId);
                            session.setAttribute("listApprenantAssigned", listApprenantAssigned);

                            // getAllApprenantNotAssignedToAnyPromo
                            List<Apprenant> listApprenantNotAssigned = ApprenantService.getAllApprenantNotAssignedToAnyPromo();
                            session.setAttribute("listApprenantNotAssigned", listApprenantNotAssigned);

                            req.getRequestDispatcher("./Formateur/home.jsp").include(req, resp);
                            drop = false;
                        }else{
                            System.out.println("else");
                            // getAllApprenantAssignedToTHisPromo
                            String usernameFromSession = (String) session.getAttribute("username");
                            int getPromoId = FormateurService.getIdPromo(usernameFromSession);

                            List<Apprenant> listApprenantAssigned = ApprenantService.getAllApprenantAssignedToTHisPromo(getPromoId);
                            session.setAttribute("listApprenantAssigned", listApprenantAssigned);

                            // getAllApprenantNotAssignedToAnyPromo
                            List<Apprenant> listApprenantNotAssigned = ApprenantService.getAllApprenantNotAssignedToAnyPromo();
                            session.setAttribute("listApprenantNotAssigned", listApprenantNotAssigned);

                            req.getRequestDispatcher("./Formateur/home.jsp").include(req, resp);
                        }
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