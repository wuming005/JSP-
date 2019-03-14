package com.phoenix.servlet;

import com.phoenix.bo.Student;
import com.phoenix.util.StudentUtil;
import com.phoenix.common.GetConnection;
import com.phoenix.util.TeacherUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class UpdatePersonalServlet extends HttpServlet {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs= null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	  System.out.println("---------------------");
        Integer roleId=(Integer)req.getSession().getAttribute("roleId");
        String password=req.getParameter("password");
        String roleName=(String)req.getSession().getAttribute("roleName");
        System.out.println(roleId);
        System.out.println(password);
        System.out.println(roleName);
        if(roleId==null)
        {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        if(password!=null)
        {
            String sql = "update role set password=? where role_id=?";
            conn = GetConnection.getConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,password);
                pst.setInt(2,roleId);
                pst.executeUpdate();
                req.setAttribute("tip","修改成功");
                if(roleName.equals("老师"))
                {
                    StudentUtil stUtil= new StudentUtil();
                    List list = stUtil.showListStudent(null);
                    req.setAttribute("list", list);
                }else if(roleName.equals("管理"))
                {
                    TeacherUtil teacherUtil=new TeacherUtil();
                    List list = teacherUtil.showListTeacher(null);
                    req.setAttribute("list", list);
                }
                req.getRequestDispatcher("/Main.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
                req.getRequestDispatcher("/Error.jsp").forward(req, resp);
            }
        }
    }

}