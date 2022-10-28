package com.example.simploncloneweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class ApprenantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApprenantService apprenantService = new ApprenantService();
        List list = apprenantService.getAll();
        req.setAttribute("getData", list);
        req.getRequestDispatcher("./src/Test/test.jsp").forward(req, resp);
    }
}