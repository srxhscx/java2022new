package com.example.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    //创建一个获取数据库连接的方法，返回数据库连接对象；
    public static Connection getConnection(){

        //声明一个连接对象
        Connection cn = null;
        //连接数据库的URL，用户名和密码
        String url = "jdbc:mysql://localhost:3306/jd_tms_db";
        String username = "root";
        String password = "QWer13836656849";

        try{
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接的对象
            cn = DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
            return cn;
    }

    public static void main(String[] args) {
        Connection cm = getConnection();
        System.out.println(cm);
    }
}
