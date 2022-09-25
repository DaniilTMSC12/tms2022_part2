package by.teachmeskills.login.service;

import by.teachmeskills.login.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/security")
public class SecurityPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User("qwerty@gmail.com", "qwerty12345");
        if (req.getSession().getAttribute("user") != null
                && req.getSession().getAttribute("user").equals(user)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/securityPage.html");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
            requestDispatcher.forward(req, resp);

        }
    }
}