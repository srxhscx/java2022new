package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {


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

    public int addRole(String roleName,String rolePermission) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into role_info(role_name,role_permission)values('"+roleName+"','"+rolePermission+"')";
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

    public Role getRolesById(int id){
        int n = -1;
        String sql = "select role_name,role_permission from role_info where role_id = ?";
        Connection cn = ConnectionUtil.getConnection();

        PreparedStatement pstmt =  null;

       //声明结果集游标，用于查询每一行数据
        ResultSet rs = null;

        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
           // n = pstmt.executeUpdate();
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            //判断查询结果集是否有数据
            if(rs.next()){
                Role role = new Role();
                //使用rs.get...(查询结果集)
                role.setRole_name(rs.getString("role_name"));
                role.setRole_permission(rs.getString("role_permission"));
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


    //查询所有数据
    public List<Role> getRoles(){
        int n = -1;
        String sql = "select role_name,role_permission from role_info";
        Connection cn = ConnectionUtil.getConnection();

        PreparedStatement pstmt =  null;

        //声明结果集游标，用于查询每一行数据
        ResultSet rs = null;

        //创建一个集合，用于存储多条数据
        List<Role> roleList = new ArrayList<>();

        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数

            rs = pstmt.executeQuery();
            //判断查询结果集是否有数据
            while(rs.next()){
                //每一行对象存储到role中
                Role role = new Role();
                //使用rs.get...(查询结果集)
                role.setRole_name(rs.getString("role_name"));
                role.setRole_permission(rs.getString("role_permission"));
                //再存储到roleList中
                roleList.add(role);

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
        return roleList;

    }





    public static void main(String[] args) throws SQLException {
        RoleDAO roleDAO = new RoleDAO();
        //int m = roleDAO.addRole("超级管理员","修改");
        //System.out.println(m);
        //int m = roleDAO.delRole(3);
        //System.out.println(m);
        //int m = roleDAO.updateRole(2);
        //System.out.println(m);
        //Role role = roleDAO.getRolesById(1);
        //System.out.println(role.getRole_name() + role.getRole_permission()  );

        List<Role> list  = roleDAO.getRoles();
        //System.out.println(list);
        list.forEach(role -> {
            System.out.println(role.getRole_name()+","+role.getRole_permission());
        });
        //list.forEach(System.out::println);

    }
}
