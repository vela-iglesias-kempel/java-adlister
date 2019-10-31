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

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        if (title.isEmpty() || description.isEmpty()) {
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
            request.setAttribute("title", title);
            request.setAttribute("description", description);
            request.setAttribute("category", category);

        Ad ad = new Ad(
                    title,
                    description,
                    category
            );
        DaoFactory.getAdsDao().all();

            request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
            response.sendRedirect("/ads/update");
            return;
        }

        response.sendRedirect("/profile");
    }
}
