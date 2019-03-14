package com.phoenix.util;

import com.phoenix.bo.Teacher;
import com.phoenix.common.GetConnection;
import com.phoenix.common.Table2Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherUtil {


    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs= null;


    public List addTeacher(Teacher teacher) throws SQLException {
        String sql = "insert into teacher(id,name) values(?,?)";
        conn = GetConnection.getConnection();
        pst = conn.prepareStatement(sql);
        pst.setInt(1, teacher.getId());
        pst.setString(2, teacher.getName());

        pst.executeUpdate();
        sql = "insert into role(role_id,role_name,username,password) values(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, teacher.getId());
        pst.setString(2, "老师");
        pst.setString(3, teacher.getName());
        pst.setString(4, teacher.getId().toString());
        pst.executeUpdate();

        sql = "select * from teacher";
        rs = pst.executeQuery(sql);
        Teacher tea = null;
        List list = new ArrayList();
        while(rs.next()){
            tea = Table2Object.teacher2Object(rs);
            list.add(tea);
        }
        return list;
    }

    public List deleteTeacher(Integer id) throws SQLException {
        String sql = "delete from teacher where id=?";
        conn = GetConnection.getConnection();
        pst = conn.prepareStatement(sql);
        pst.setInt(1,id);

        pst.executeUpdate();

        sql = "select * from teacher";
        rs = pst.executeQuery(sql);
        Teacher tea = null;
        List list = new ArrayList();
        while(rs.next()){
            tea = Table2Object.teacher2Object(rs);
            list.add(tea);
        }
        return list;
    }

    public List updateTeacher(Integer id,Teacher Teacher) throws SQLException {
        String sql = "update teacher set name=?,id=? where id=?";
        conn = GetConnection.getConnection();
        pst = conn.prepareStatement(sql);
        pst.setString(1,Teacher.getName());
        pst.setInt(2,Teacher.getId());
        pst.setInt(3,id);
        //保存学生
        pst.executeUpdate();
        //将保存的学生信息检出，显示给用户
        sql = "select * from teacher";
        rs = pst.executeQuery(sql);
        Teacher tea = null;
        List list = new ArrayList();
        while(rs.next()){
            tea = Table2Object.teacher2Object(rs);
            list.add(tea);
        }
        return list;
    }
    public Teacher showOneTeacher(Integer id) throws SQLException {
        String sql="select * from teacher where id="+id;
        conn = GetConnection.getConnection();
        pst = conn.prepareStatement(sql);

        //将保存的学生信息检出，显示给用户
        rs = pst.executeQuery(sql);
        Teacher tea = null;
        while(rs.next()){
            tea = Table2Object.teacher2Object(rs);
        }
        return tea;
    }


    public List showListTeacher(Teacher Teacher) throws SQLException {
        StringBuilder stringBuilder=new StringBuilder("select * from teacher");
        if(Teacher!=null)
        {
            if(Teacher.getName()!=null)
            {
                stringBuilder.append(" where name='"+Teacher.getName()+"'");
            }
            if(Teacher.getId()!=null)
            {
                String s=(stringBuilder.indexOf("where")>-1)?" id=":" where id=";
                stringBuilder.append(s+Teacher.getId());
            }
        }
        conn = GetConnection.getConnection();
        pst = conn.prepareStatement(stringBuilder.toString());
        rs = pst.executeQuery(stringBuilder.toString());
        Teacher tea = null;
        List list = new ArrayList();
        while(rs.next()){
            tea = Table2Object.teacher2Object(rs);
            list.add(tea);
        }
        return list;
    }

}