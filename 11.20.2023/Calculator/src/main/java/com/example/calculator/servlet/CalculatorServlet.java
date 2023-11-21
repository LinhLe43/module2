package com.example.calculator.servlet;

import com.example.calculator.model.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calculatorServlet", value = "/cal")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("calculatorForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float firstNumber = Float.parseFloat(req.getParameter("firstNumber"));
        float secondNumber = Float.parseFloat(req.getParameter("secondNumber"));
        char operation = req.getParameter("operator").charAt(0);
        float result = Calculator.calculate(firstNumber, secondNumber, operation);
        req.setAttribute("result", result);
        req.setAttribute("firstNumber", firstNumber);
        req.setAttribute("secondNumber", secondNumber);
        req.setAttribute("operation", operation);
        RequestDispatcher dispatcher = req.getRequestDispatcher("result.jsp");
        dispatcher.forward(req, resp);
    }
}
