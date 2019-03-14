package com.phoenix.servlet;
import com.phoenix.bo.Role;
import com.phoenix.common.GetConnection;
import com.phoenix.common.Table2Object;
import com.phoenix.util.StudentUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.phoenix.util.TeacherUtil;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sername = req.getParameter("username");
        String password = req.getParameter("password");
        String roleId = req.getParameter("roleId");
        conn = GetConnection.getConnection();
        String sql = "select * from role where role_id="+roleId;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Role role = null;
            while (rs.next()) {
                role = Table2Object.role2Role(rs);
            }
            String target = null;
          
            if (null != role) {
            	
            	
                if (role.getUsername().equals(sername) && role.getPassword().equals(password)) {
                    req.getSession().setAttribute("roleId",role.getRoleId());
                    req.getSession().setAttribute("username", sername);
                    req.getSession().setAttribute("roleName", role.getRoleName());
                    if(role.getRoleName().equals("老师"))
                    {
                        StudentUtil stUtil= new StudentUtil();
                        List list = stUtil.showListStudent(null);
                        req.setAttribute("list", list);
                    }else if(role.getRoleName().equals("管理"))
                    {
                        TeacherUtil teacherUtil=new TeacherUtil();
                        List list = teacherUtil.showListTeacher(null);
                        req.setAttribute("list", list);
                    }
                    target = "/Main.jsp";
                } else {
                    req.setAttribute("opTip", "密码输入错误，请重新输入");
                    target = "/index.jsp";
                }
            } else {
                req.setAttribute("opTip", "用户不存在！");
                target = "/index.jsp";
            }
            req.getRequestDispatcher(target).forward(req, resp);
        } catch (NumberFormatException e) {
            System.out.println("目标字符串不能转换成Long型数值");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库操作出现异常");
            e.printStackTrace();
        }

    }
}
