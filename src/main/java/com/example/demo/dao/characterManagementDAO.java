package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Cartype;
import com.example.demo.vo.characterManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class characterManagementDAO {
    public int addAccountManagement (int id,String name,String remark,String permission) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert role_info(role_id,role_name,role_remark,role_permission)values("+id+",'"+name+"','"+remark+"','"+permission+"')";
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

    public List<characterManagement> getCharacterManagement() {
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM role_info ";
        //发送给mysql执行
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<characterManagement> characterManagementList = new ArrayList<>();
        try {
            pstmt = cn.prepareStatement(sql);
            //返回影响行数

            rs = pstmt.executeQuery();
            while (rs.next()) {
                characterManagement charactermanagement = new characterManagement();

                charactermanagement.setCmstate(rs.getString("role_state"));
                charactermanagement.setCmrole(rs.getString("role_name"));
                charactermanagement.setCmremark(rs.getString("role_remark"));
                charactermanagement.setCmpermission(rs.getString("role_permission"));

                characterManagementList.add(charactermanagement);


            }
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
        return characterManagementList;

    }
    public List<characterManagement> getCharacterByManagement(String cmname) {
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM role_info  WHERE role_name = ?";
        //发送给mysql执行
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<characterManagement> characterManagementList = new ArrayList<>();
        try {
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,cmname);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                characterManagement charactermanagement = new characterManagement();

                charactermanagement.setCmstate(rs.getString("role_state"));
                charactermanagement.setCmrole(rs.getString("role_name"));
                charactermanagement.setCmremark(rs.getString("role_remark"));
                charactermanagement.setCmpermission(rs.getString("role_permission"));

                characterManagementList.add(charactermanagement);


            }
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
        return characterManagementList;

    }
}



