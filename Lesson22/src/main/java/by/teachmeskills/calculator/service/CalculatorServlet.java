package by.teachmeskills.calculator.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.teachmeskills.calculator.model.Calculator.*;


@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/calculator.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double number1 = Double.parseDouble(req.getParameter("num1"));
        double number2 = Double.parseDouble(req.getParameter("num2"));
        double result = switch (req.getParameter("operation")) {
            case "+" -> sum(number1, number2);
            case "-" -> subtraction(number1, number2);
            case "*" -> multiply(number1, number2);
            case "/" -> divide(number1, number2);
            default -> 0;
        };
        resp.getWriter().write("Result: " + result);
    }


}
