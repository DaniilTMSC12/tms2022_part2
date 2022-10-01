package by.teachmeskills.login.service;

import by.teachmeskills.login.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        System.out.println("Почта: " + email);
        System.out.println("Пароль: " + password);

        if (!user.getEmail().equals(email) || !user.getPassword().equals(password)) {
            resp.getWriter().write("Данного пользователя не существует, или данные введены неверно!");
        } else {
            req.getSession().setAttribute("user", user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/securityPage.html");
            requestDispatcher.forward(req, resp);
        }
    }
}