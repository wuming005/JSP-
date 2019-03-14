package com.phoenix.common;

import java.sql.*;

public class GetConnection {
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/stu?characterEncoding=utf-8";
    public static final String USER = "root";
    public static final String PASSWORD = "1111";
    public static Connection conn;

    public static Connection getConnection(){
        try {
            if (null == conn){
                Class.forName(CLASSNAME);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("系统找不到指定类");
        } catch (SQLException e) {
            System.out.println("数据库连接出现异常");
        }
        return conn;
    }

}

