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

public class AddTeacherServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute("roleName").equals("管理"))
        {
        Teacher tea=new Teacher();
        tea.setId(Integer.parseInt(req.getParameter("teacherId")));
        tea.setName(req.getParameter("teacherName"));
        TeacherUtil teUtil=new TeacherUtil();
        try {
            List list=teUtil.addTeacher(tea);
            req.setAttribute("list",list);
            req.getRequestDispatcher("/Main.jsp").forward(req, resp);
        }catch (SQLException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
        }else{
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
    }
}
