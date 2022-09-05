package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class routeManagmentDAO {
    public int addRouteManagement(String startCity,String destination,String type,String mode,String allzero,String time,String first,String second,String remark)
    {
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into remark_info(originatingcity_name,destination_name,business_type,transport_mode,all_zero,effective_time,first_carrier,last_carrier,route_remark)values('"+startCity+"','"+destination+"','"+type+"','"+mode+"','"+allzero+"','"+time+"','"+first+"','"+second+"','"+remark+"')";
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
