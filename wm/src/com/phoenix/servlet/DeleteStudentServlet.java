package com.phoenix.servlet;

import com.phoenix.bo.Student;
import com.phoenix.util.StudentUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String studentId=req.getParameter("studentId");
        if(studentId==null)
        {
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
            return;
        }
        StudentUtil stUtil= new StudentUtil();
        try {
            List list = stUtil.deleteStudent(Integer.parseInt(studentId));
            req.setAttribute("list", list);
            req.getRequestDispatcher("/Main.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
    }

}