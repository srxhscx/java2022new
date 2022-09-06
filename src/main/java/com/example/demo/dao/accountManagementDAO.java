package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Buisness;
import com.example.demo.vo.accountManagement;
import javafx.beans.property.StringProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class accountManagementDAO{
    public int addAccountManagement (String account,String name,String password,
                                    String institution,String city,String node,String contact,String mail) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into user_info(user_account,user_name,user_password,user_institution,user_city,user_node,user_tel,user_mail)values('"+account+"','"+name+"','"+password+"','"+institution+"','"+city+"','"+node+"','"+contact+"','"+mail+"')";
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

    public List<accountManagement> getAccountManagement(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM user_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<accountManagement> accountManagementList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                accountManagement accountmanagement =new accountManagement();

                accountmanagement.setAm_account(rs.getString("user_account"));
                accountmanagement.setAm_name(rs.getString("user_name"));
                accountmanagement.setAm_password(rs.getString("user_password"));
                accountmanagement.setAm_institution(rs.getString("user_institution"));
                accountmanagement.setAm_city(rs.getString("user_city"));
                accountmanagement.setAm_node(rs.getString("user_node"));
                accountmanagement.setAm_contact(rs.getString("user_tel"));
                accountmanagement.setAm_mail(rs.getString("user_mail"));

                accountManagementList.add(accountmanagement);
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
        return accountManagementList;
    }
    public List<accountManagement> getAccountByManagement(String name){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM user_info WHERE user_name=?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<accountManagement> accountManagementList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            pstmt.setString(1,name);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                accountManagement accountmanagement =new accountManagement();

                accountmanagement.setAm_account(rs.getString("user_account"));
                accountmanagement.setAm_name(rs.getString("user_name"));
                accountmanagement.setAm_password(rs.getString("user_password"));
                accountmanagement.setAm_institution(rs.getString("user_institution"));
                accountmanagement.setAm_city(rs.getString("user_city"));
                accountmanagement.setAm_node(rs.getString("user_node"));
                accountmanagement.setAm_contact(rs.getString("user_tel"));
                accountmanagement.setAm_mail(rs.getString("user_mail"));

                accountManagementList.add(accountmanagement);
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
        return accountManagementList;
    }

}
