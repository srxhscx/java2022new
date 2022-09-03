package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Role;
import com.example.demo.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

 /**
  *
 *验证用户是否存在
 *
  */

    public User login(String account){
        int n = -1;
        String sql = "SELECT * FROM user_info WHERE user_account = ?";
        Connection cn = ConnectionUtil.getConnection();

        PreparedStatement pstmt =  null;

        //声明结果集游标，用于查询每一行数据
        ResultSet rs = null;
        User user = null;
        try{
            pstmt = cn.prepareStatement(sql);
            pstmt.setString(1,account);

            rs = pstmt.executeQuery();


            if(rs.next()){
                user = new User();
                //使用rs.get...(查询结果集)
                user.setUser_account(rs.getString("user_name"));
                user.setUser_password(rs.getString("user_password"));
                user.setUser_id(rs.getInt("user_id"));
                user.setFace_img(rs.getString("face_img"));
                user.setUser_name(rs.getString("user_name"));
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
        return user;

    }

    /**
     *
     *创建用户
     */
    public int addRole(String userAccount,String userPassword,String userName,int userPermission) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into user_info(user_account,user_password,user_name,role_id)values('"+userAccount+"','"+userPassword+"','"+userName+"',"+userPermission+")";
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
