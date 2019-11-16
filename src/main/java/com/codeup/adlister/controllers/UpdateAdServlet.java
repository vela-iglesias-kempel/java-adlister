package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateAdServlet", urlPatterns = "/ads/update")
public class UpdateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("id") != null){

            long id = Long.parseLong(request.getParameter("id"));

            if(DaoFactory.getAdsDao().getAdById(id) != null) {

                if (request.getSession().getAttribute("user") != null) {
                    request.setAttribute("user", request.getSession().getAttribute("user"));
                }

                request.setAttribute("ad", DaoFactory.getAdsDao().getAdById(id));

                request.getRequestDispatcher("/WEB-INF/ads/update.jsp")
                        .forward(request, response);
                return;
            }
            response.sendRedirect("/profile");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        String id = request.getParameter("id");
        long longId = Long.parseLong(request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user");



            Ad ad = new Ad(
                    longId,
                    user.getId(),
                    title,
                    description,
                    category
            );
            DaoFactory.getAdsDao().update(ad);

            request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);

        response.sendRedirect("/profile");
    }
}

