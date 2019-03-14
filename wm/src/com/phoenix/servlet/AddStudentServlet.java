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

public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        if(req.getSession().getAttribute("roleName").equals("老师")) {
            Student stu = new Student();
            stu.setId(Integer.parseInt(req.getParameter("studentId")));
            stu.setName(req.getParameter("studentName"));
            stu.setSex(req.getParameter("studentSex"));
            stu.setBirthday(Long.parseLong(req.getParameter("studentBirthday").toString()));
            stu.setSpecialty(Long.parseLong(req.getParameter("studentSpecialty").toString()));
            StudentUtil stUtil = new StudentUtil();
            try {
                List list = stUtil.addStudent(stu);
                req.setAttribute("list", list);
                req.getRequestDispatcher("/Main.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
                req.getRequestDispatcher("/Error.jsp").forward(req, resp);
            }
        }else {
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
    }

}
