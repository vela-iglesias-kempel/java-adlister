package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdatePasswordServlet",  urlPatterns="/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Update Password");
        User currentUser = (User) request.getSession().getAttribute("user");
        System.out.println( currentUser.getId());
        String newPassword = request.getParameter("newPassword");
        DaoFactory.getUsersDao().updatePassword(newPassword, currentUser.getId());
        response.sendRedirect("/updateSettings");
    }


}

