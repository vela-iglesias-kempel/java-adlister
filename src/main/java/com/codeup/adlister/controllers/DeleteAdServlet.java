package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //if user is NOT logged in, they cannot view this page
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        if (request.getParameter("id") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            DaoFactory.getAdsDao().delete(id);
//            response.sendRedirect("/ads");
//        long id = Long.parseLong(request.getParameter("ad"));
//        DaoFactory.getAdsDao().delete(id);

            // Using this method if keeping the delete.jsp //
            request.setAttribute("ads", DaoFactory.getAdsDao().all());

            response.sendRedirect("/profile");
        }

    }
}