package com.phoenix.servlet;
import com.phoenix.bo.Teacher;
import com.phoenix.util.TeacherUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UpdateTeacherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("teacherId")==null)
        {
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
        TeacherUtil teUtil= new TeacherUtil();
        try {
            Teacher teacher=teUtil.showOneTeacher(Integer.parseInt(req.getParameter("teacherId")));
            req.setAttribute("teacher", teacher);
            req.getRequestDispatcher("updateTeacher.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher tea = new Teacher();
        tea.setId(Integer.parseInt(req.getParameter("teacherId")));
        tea.setName(req.getParameter("teacherName"));
        Integer queryId= Integer.parseInt(req.getParameter("id"));
        TeacherUtil teaUtil= new TeacherUtil();
        try {
            List list = teaUtil.updateTeacher(queryId,tea);
            req.setAttribute("list", list);
            req.getRequestDispatcher("/Main.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
    }
}
