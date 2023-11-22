package com.example.studentlist.servlet;

import com.example.studentlist.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "studentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Linh", 28));
        list.add(new Student(2, "Giang", 27));
        list.add(new Student(3, "Vanh", 27));
        list.add(new Student(4, "Hieu", 30));
        list.add(new Student(5, "Duy", 21));

        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("studentForm.jsp");
        dispatcher.forward(req, resp);

    }
}
