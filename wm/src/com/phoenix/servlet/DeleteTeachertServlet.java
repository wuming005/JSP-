package com.phoenix.servlet;
import com.phoenix.util.TeacherUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DeleteTeachertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String teacherId=req.getParameter("teacherId");
        if(teacherId==null)
        {
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
            return;
        }
        TeacherUtil teacherUtil=new TeacherUtil();
        try {
            List list = teacherUtil.deleteTeacher(Integer.parseInt(teacherId));
            req.setAttribute("list", list);
            req.getRequestDispatcher("/Main.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
    }

}