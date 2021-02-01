package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Pattern specialChars = Pattern.compile("[!@$%&?#-]");
        Pattern nums = Pattern.compile("[0-9]");
        if (password.length() >= 10 && specialChars.matcher(password).find()
                && nums.matcher(password).find()
                && DaoFactory.getUsersDao().findByUsername(username) == null) {
            User newUser = new User(username, email, password);
            DaoFactory.getUsersDao().insert(newUser);
            request.getSession().setAttribute("user", newUser);
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        } else response.sendRedirect("/register");
    }
}
