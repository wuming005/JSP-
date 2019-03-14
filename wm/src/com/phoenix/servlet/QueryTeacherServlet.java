package com.phoenix.servlet;

import com.phoenix.bo.Student;
import com.phoenix.bo.Teacher;
import com.phoenix.util.StudentUtil;
import com.phoenix.util.TeacherUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class QueryTeacherServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Teacher teacher = new Teacher();
        String column=req.getParameter("col");
        String value=req.getParameter("value");
        switch (column)
        {
            case "teacherId":
                teacher.setId(Integer.parseInt(value));
                break;
            case "name":
                teacher.setName(value);
                break;
            default:
        }
        TeacherUtil teacherUtil=new TeacherUtil();
        try {
            List list = teacherUtil.showListTeacher(teacher);
            req.setAttribute("list", list);
            req.getRequestDispatcher("/Main.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
    }

}