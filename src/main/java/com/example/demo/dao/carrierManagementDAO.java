package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Buisness;
import com.example.demo.vo.carrierManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<carrierManagement> getCarrierManagement(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM carrier_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<carrierManagement> carrierManagementList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                carrierManagement carriermanagement =new carrierManagement();

                carriermanagement.setFmname(rs.getString("carrier_name"));
                carriermanagement.setFmshortname(rs.getString("carrier_shortname"));
                carriermanagement.setFmcontact(rs.getString("carrier_contact"));
                carriermanagement.setFmphone(rs.getString("carrier_phone"));
                carriermanagement.setFmtel(rs.getString("carrier_tel"));
                carriermanagement.setFmaddress(rs.getString("carrier_address"));
                carriermanagement.setFmremark(rs.getString("carrier_remark"));

                carrierManagementList.add(carriermanagement);
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
        return carrierManagementList;
    }
    public List<carrierManagement> getCarrierByManagement(String cname){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM carrier_info WHERE carrier_name=?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<carrierManagement> carrierManagementList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,cname);
            rs=pstmt.executeQuery();
            while (rs.next()){
                carrierManagement carriermanagement =new carrierManagement();

                carriermanagement.setFmname(rs.getString("carrier_name"));
                carriermanagement.setFmshortname(rs.getString("carrier_shortname"));
                carriermanagement.setFmcontact(rs.getString("carrier_contact"));
                carriermanagement.setFmphone(rs.getString("carrier_phone"));
                carriermanagement.setFmtel(rs.getString("carrier_tel"));
                carriermanagement.setFmaddress(rs.getString("carrier_address"));
                carriermanagement.setFmremark(rs.getString("carrier_remark"));

                carrierManagementList.add(carriermanagement);
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
        return carrierManagementList;
    }

}

