package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public int delRole(int id){
        int m = -1;
        String sql = "delete from role_info where role_id = ?";
        Connection cn = ConnectionUtil.getConnection();

        PreparedStatement pstmt =  null;

        try{
            pstmt = cn.prepareStatement(sql);

            pstmt.setInt(1,id);
            m = pstmt.executeUpdate();
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
        return m;
    }

    public int updateRole(int id){
        int m = -1;
        String sql = "UPDATE role_info SET role_name = '店长',role_permission = '修改' WHERE role_id = ?;";
        Connection cn = ConnectionUtil.getConnection();

        PreparedStatement pstmt =  null;

        try{
            pstmt = cn.prepareStatement(sql);

            pstmt.setInt(1,id);
            m = pstmt.executeUpdate();
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
        return m;
    }

    public int addRole(String User_account,String User_password,String Face_img,int Role_id,String User_name) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into user_info(user_account,user_password,face_img,role_id,user_name)values('"+User_account+"','"+User_password+"','"+Face_img+"',"+Role_id+",'"+User_name+"')";
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

    public static void main(String[] args) throws SQLException {
        //RoleDAO roleDAO = new RoleDAO();
        //int m = roleDAO.addRole("超级管理员","修改");
        //System.out.println(m);
        //int m = roleDAO.delRole(3);
        //System.out.println(m);
        //int m = roleDAO.updateRole(2);
        //System.out.println(m);
    }
}
