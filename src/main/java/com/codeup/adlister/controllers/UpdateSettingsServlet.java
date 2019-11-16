package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateSettingsServlet", urlPatterns = "/updateSettings")
public class UpdateSettingsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/updateSettings.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("email");
        System.out.println(request.getParameter("hdnbt"));
        if (request.getParameter("btnUpdateEmail") != null){
            System.out.println("Email updated");
            response.sendRedirect("/updateEmail");
            return;
        }
        else if (request.getParameter("btnUpdatePassword") != null){
            System.out.println("password updated");
            response.sendRedirect("/updatePassword");
            return;

        }
        response.sendRedirect("/updateSettings");
    }
}
