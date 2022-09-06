package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.carrierManagement;
import com.example.demo.vo.freightManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<freightManagement> getFreightManagement(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM freight_setting";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<freightManagement> freightManagementList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                freightManagement freightmanagement =new freightManagement();

                freightmanagement.setFrcarrier(rs.getString("freight_name"));
                freightmanagement.setFrstartcity(rs.getString("start_city"));
                freightmanagement.setFrdestinationcity(rs.getString("destination_city"));
                freightmanagement.setFrtransport(rs.getString("transport_mode"));
                freightmanagement.setFroneall(rs.getString("all_one"));
                freightmanagement.setFrweight(rs.getString("weight"));
                freightmanagement.setFrtime(rs.getString("time"));
                freightmanagement.setFrpermium(rs.getString("premium"));
                freightmanagement.setFrstarttime(rs.getString("up_time"));
                freightmanagement.setFrdeadtime(rs.getString("dead_time"));

                freightManagementList.add(freightmanagement);
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
        return freightManagementList;
    }
    public List<freightManagement> getFreightByManagement(String fname){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM freight_setting WHERE start_city=?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<freightManagement> freightManagementList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            pstmt.setString(1,fname);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                freightManagement freightmanagement =new freightManagement();

                freightmanagement.setFrcarrier(rs.getString("freight_name"));
                freightmanagement.setFrstartcity(rs.getString("start_city"));
                freightmanagement.setFrdestinationcity(rs.getString("destination_city"));
                freightmanagement.setFrtransport(rs.getString("transport_mode"));
                freightmanagement.setFroneall(rs.getString("all_one"));
                freightmanagement.setFrweight(rs.getString("weight"));
                freightmanagement.setFrtime(rs.getString("time"));
                freightmanagement.setFrpermium(rs.getString("premium"));
                freightmanagement.setFrstarttime(rs.getString("up_time"));
                freightmanagement.setFrdeadtime(rs.getString("dead_time"));

                freightManagementList.add(freightmanagement);
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
        return freightManagementList;
    }

}

