package com.phoenix.common;

import com.phoenix.bo.Role;
import com.phoenix.bo.Student;
import com.phoenix.bo.Teacher;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table2Object {
    public static Role role2Role(ResultSet rs) throws SQLException {
        Role role = null;
        if(rs.getRow() != 0){
            role = new Role();
            role.setRoleId(rs.getInt(1));
            role.setUsername(rs.getString(3));
            role.setRoleName(rs.getString(2));
            role.setPassword(rs.getString(4));
        }
        return role;
    }

    public static Student student2Object(ResultSet rs) throws SQLException {
       Student student = null;
        if(rs.getRow() != 0){
            student  = new Student();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            student.setSex(rs.getString(3));
            student.setBirthday(rs.getLong(4));
            student.setSpecialty(rs.getLong(5));
        }
        return student;
    }

    public static Teacher teacher2Object(ResultSet rs) throws SQLException {
        Teacher teacher = null;
        if(rs.getRow() != 0){
            teacher  = new Teacher();
            teacher.setId(rs.getInt(1));
            teacher.setName(rs.getString(2));
        }
        return teacher;
    }
}
