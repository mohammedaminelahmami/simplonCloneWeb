package com.example.simploncloneweb.controller;

import com.example.simploncloneweb.Entity.Brief;
import com.example.simploncloneweb.service.BriefService;
import com.example.simploncloneweb.service.FormateurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet({"/formateur/assign","/formateur/empecher", "/formateur/briefs", "/formateur/addBrief", "/formateur/deleteBrief", "/formateur/updateBrief", "/formateur/rendus"})
public class FormateurController extends HttpServlet {
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
            case "/formateur/assign":
            {
                String idApprenant = req.getParameter("idApprenant");
                String username = (String) session.getAttribute("username");
                if(FormateurService.assignApprenantToPromo(Integer.parseInt(idApprenant), username))
                {
                    resp.sendRedirect("/home");
                    return;
                }
                System.out.println("errorAssign");
                resp.sendRedirect("/home");
                break;
            }
            case "/formateur/empecher":
            {
                String idApprenant = req.getParameter("idApprenant");
                if(FormateurService.empechApprenantToPromo(Integer.parseInt(idApprenant)))
                {
                    resp.sendRedirect("/home");
                    return;
                }
                System.out.println("errorEmpeche");
                resp.sendRedirect("/home");
                break;
            }
            case "/formateur/briefs":
            {
                int idPromo = (int) session.getAttribute("idPromo");

                List<Brief> briefs = BriefService.getAllBriefsPromo(idPromo);
                req.setAttribute("briefs", briefs);

                req.getRequestDispatcher("../Formateur/briefs.jsp").forward(req, resp);
                break;
            }
            case "/formateur/addBrief":
            {
                String context = req.getParameter("context");
                String deadline = req.getParameter("deadline");
                int idPromo = (int) session.getAttribute("idPromo");

                if(BriefService.addBrief(context, Integer.parseInt(deadline),idPromo))
                {
                    resp.sendRedirect("/formateur/briefs");
                    return;
                }
                System.out.println("errorAddBrief");
                resp.sendRedirect("/formateur/briefs");
                break;
            }
        }
    }
}