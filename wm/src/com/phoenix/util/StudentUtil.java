package com.phoenix.util;

import com.phoenix.bo.Student;
import com.phoenix.common.GetConnection;


import com.phoenix.common.Table2Object;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentUtil {


    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs= null;


    public List addStudent(Student student) throws SQLException {
        String sql = "insert into student(id,name,sex,birthday,specialty) values(?,?,?,?,?)";
        conn = GetConnection.getConnection();
        pst = conn.prepareStatement(sql);
        pst.setInt(1, student.getId());
        pst.setString(2, student.getName());
        pst.setString(3, student.getSex());
        pst.setLong(4, student.getBirthday());
        pst.setLong(5, student.getSpecialty());
        //保存学生
        pst.executeUpdate();
        sql = "insert into role(role_id,role_name,username,password) values(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, student.getId());
        pst.setString(2, "学生");
        pst.setString(3, student.getName());
        pst.setString(4, student.getId().toString());
        pst.executeUpdate();
        //将保存的学生信息检出，显示给用户
        sql = "select * from student";
        rs = pst.executeQuery(sql);
        Student stu = null;
        List list = new ArrayList();
        while(rs.next()){
            stu = Table2Object.student2Object(rs);
            list.add(stu);
        }
        return list;
    }

    public List deleteStudent(Integer id) throws SQLException {
        String sql = "delete from student where id=?";
        conn = GetConnection.getConnection();
        pst = conn.prepareStatement(sql);
        pst.setInt(1,id);
        //保存学生
        pst.executeUpdate();
        //将保存的学生信息检出，显示给用户
        sql = "select * from student";
        rs = pst.executeQuery(sql);
        Student stu = null;
        List list = new ArrayList();
        while(rs.next()){
            stu = Table2Object.student2Object(rs);
            list.add(stu);
        }
        return list;
    }

    public List updateStudent(Integer id,Student student) throws SQLException {
        String sql = "update student set name=?,sex=?,id=?,birthday=?,specialty=? where id=?";
        conn = GetConnection.getConnection();
        pst = conn.prepareStatement(sql);
        pst.setString(1,student.getName());
        pst.setString(2,student.getSex());
        pst.setInt(3,student.getId());
        pst.setLong(4,student.getBirthday());
        pst.setLong(5,student.getSpecialty());
        pst.setInt(6,id);
        //保存学生
        pst.executeUpdate();
        //将保存的学生信息检出，显示给用户
        sql = "select * from student";
        rs = pst.executeQuery(sql);
        Student stu = null;
        List list = new ArrayList();
        while(rs.next()){
            stu = Table2Object.student2Object(rs);
            list.add(stu);
        }
        return list;
    }
    public Student showOneStudent(Integer id) throws SQLException {
        String sql="select * from student where id="+id;
        conn = GetConnection.getConnection();
        pst = conn.prepareStatement(sql);

        //将保存的学生信息检出，显示给用户
        rs = pst.executeQuery(sql);
        Student stu = null;
        while(rs.next()){
            stu = Table2Object.student2Object(rs);
        }
        return stu;
    }


    public List showListStudent(Student student) throws SQLException {
        StringBuilder stringBuilder=new StringBuilder("select * from student");
        if(student!=null)
        {
            if(student.getName()!=null)
            {
                stringBuilder.append(" where name='"+student.getName()+"'");
            }
            if(student.getId()!=null)
            {
                String s=(stringBuilder.indexOf("where")>-1)?" id=":" where id=";
                stringBuilder.append(s+student.getId());
            }
            if(student.getSex()!=null)
            {
                String s=(stringBuilder.indexOf("where")>-1)?" sex='":" where sex='";
                stringBuilder.append(s+student.getSex()+"'");
            }
        }
        conn = GetConnection.getConnection();
        pst = conn.prepareStatement(stringBuilder.toString());

        //将保存的学生信息检出，显示给用户
        rs = pst.executeQuery(stringBuilder.toString());
        Student stu = null;
        List list = new ArrayList();
        while(rs.next()){
            stu = Table2Object.student2Object(rs);
            list.add(stu);
        }
        return list;
    }

}
