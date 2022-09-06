package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.carrierManagement;
import com.example.demo.vo.routeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<routeManagement> getRouteManagement(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM remark_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<routeManagement> routeManagementList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                routeManagement routemanagement =new routeManagement();

                routemanagement.setRmstartcity(rs.getString("originatingcity_name"));
                routemanagement.setRmdestinationcity(rs.getString("destination_name"));
                routemanagement.setRmmode(rs.getString("business_type"));
                routemanagement.setRmallone(rs.getString("all_zero"));
                routemanagement.setRmtype(rs.getString("transport_mode"));
                routemanagement.setRmfirstfreight(rs.getString("first_carrier"));
                routemanagement.setRmlastfreight(rs.getString("last_carrier"));
                routemanagement.setRmstarttime(rs.getString("effective_time"));
                routemanagement.setRmoperate(rs.getString("route_remark"));

                routeManagementList.add(routemanagement);
            }
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
        return routeManagementList;
    }

}
