package com.example.demo.DAO;

import com.example.demo.model.Role;
import com.example.demo.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO {
    /*
     *
     * 添加一个角色
     */

    public int delRole(int id){
        int m = -1;
        String sql = "delete from user_info where user_id = ?";
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
        String sql = "UPDATE user_info SET user_account = '店长' WHERE user_id = ?;";
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
    public int addRole(String roleName,String rolePermission) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into user_info(user_id,user_account,user_password,locked,face_img,role_id)values("+roleName+"+"+rolePermission+")";
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

    public Role getRoleById(int id){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT user_id,user_account FROM user_info WHERE user_id=?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            if(rs.next()){
                Role role =new Role();
                role.setUser_id(rs.getInt("user_id"));
                role.setUser_account(rs.getString("user_account"));
                return role;
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
        return null;
    }
    public static void main(String[] args) throws SQLException {
        RoleDAO roleDAO = new RoleDAO();
//        int m = roleDAO.updateRole(2);
//        System.out.println(m);
        Role role =roleDAO.getRoleById(2);
        System.out.println(role.getUser_id()+ role.getUser_account());


    }
}