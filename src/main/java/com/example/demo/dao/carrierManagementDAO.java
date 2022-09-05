package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class carrierManagementDAO {
    public int addCarrierManagement (int id,String name,String shortname,
                                     String address,String contact,String phone,String tel,String remark) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into carrier_info(carrier_id,carrier_name,carrier_shortname,carrier_address,carrier_contact,carrier_phone,carrier_tel,carrier_remark)values("+id+",'"+name+"','"+shortname+"','"+address+"','"+contact+"','"+phone+"','"+tel+"','"+remark+"')";
        //发送给mysql执行
        PreparedStatement pstmt =  null;

        int n = -1;
        //绑定到PreparedStatement对象中

        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            n = pstmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            if (cn != null){
                try {
                    cn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return n;
    }

}

