package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class freightManagementDAO {
    public int addFreightManagement (String mode,String allOne,String num,
                                     String name,String startCity,String destinationCity,
                                     String weight,String volume,String time,String premium,String upTime,String deadTime) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into freight_setting(transport_mode,all_one,freight_num,freight_name,start_city,destination_city,weight,volume,time,premium,up_time,dead_time)values('" + mode + "','" + allOne + "','" + num + "','" + name + "','" + startCity + "','" + destinationCity + "','" + weight + "','" + volume + "','"+time+"','"+premium+"','"+upTime+"','"+deadTime+"')";
        //发送给mysql执行
        PreparedStatement pstmt = null;

        int n = -1;
        //绑定到PreparedStatement对象中

        try {
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            n = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return n;
    }
}
