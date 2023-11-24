package com.example.studentmanager.servlet;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.service.impl.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "findAll":
                showList(req, resp);
                break;
            case "create":
                showCreateForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            case "update":
                showUpdateForm(req, resp);
                break;
            case "view":
                showView(req, resp);
                break;
            case "findByName":
                RequestDispatcher dispatcher = req.getRequestDispatcher("students/findByName.jsp");
                dispatcher.forward(req, resp);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/read.jsp");
        List<Student> students = studentService.findAll();
        req.setAttribute("students", students);
        dispatcher.forward(req, resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/create.jsp");
        dispatcher.forward(req, resp);
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/delete.jsp");
        int idDelete = Integer.parseInt(req.getParameter("id"));
        Student studentDelete = studentService.getStudentById(idDelete);
        req.setAttribute("student", studentDelete);
        dispatcher.forward(req, resp);
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/update.jsp");
        int idUpdate = Integer.parseInt(req.getParameter("id"));
        Student updateStudent = studentService.getStudentById(idUpdate);
        req.setAttribute("student", updateStudent);
        dispatcher.forward(req, resp);
    }

    private void showView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/view.jsp");
        int idView = Integer.parseInt(req.getParameter("id"));
        Student studentView = studentService.getStudentById(idView);
        req.setAttribute("student", studentView);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String image = req.getParameter("image");
        Student newStudent = new Student(id, name, image);
        studentService.add(newStudent);
        resp.sendRedirect("/students?action=findAll");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idDelete = Integer.parseInt(req.getParameter("id"));
        studentService.delete(idDelete);
        resp.sendRedirect("/students?action=findAll");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idUpdate = Integer.parseInt(req.getParameter("oldId"));
        int id = Integer.parseInt(req.getParameter("newId"));
        String name = req.getParameter("name");
        String image = req.getParameter("image");
        Student newStudent = new Student(id, name, image);
        studentService.edit(idUpdate, newStudent);
        resp.sendRedirect("/students?action=findAll");
    }
}

