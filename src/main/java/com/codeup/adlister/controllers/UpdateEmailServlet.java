package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "UpdateEmailServlet", urlPatterns="/updateEmail")
public class UpdateEmailServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Update Email");
        User currentUser = (User) request.getSession().getAttribute("user");
        System.out.println( currentUser.getId());
        String newEmail = request.getParameter("email");
        DaoFactory.getUsersDao().updateEmail(newEmail, currentUser.getId());
        response.sendRedirect("/updateSettings");



    }

}
