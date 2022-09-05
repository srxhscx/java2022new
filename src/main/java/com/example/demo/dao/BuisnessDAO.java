package com.example.demo.dao;

import com.example.demo.model.Role;
import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Buisness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuisnessDAO {

    /**
     *增加业务类型
     */
    public int addBusiness(String businessType,String businessState,String businessDistribution,String businessRemark) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into business_info(business_type, business_state,business_distribution,business_remark)values('"+businessType+"','"+businessState+"','"+businessDistribution+"','"+businessRemark+"')";
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

        public List<Buisness> getBusinessByBusinessType(String businessType){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM business_info WHERE business_type = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<Buisness> buisnessList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Buisness buisness =new Buisness();

                buisness.setBusiness_state(rs.getString("business_state"));
                buisness.setBusiness_type(rs.getString("business_type"));
                buisness.setBusiness_distribution(rs.getString("business_distribution"));
                buisness.setBusiness_remark(rs.getString("business_remark"));

                buisnessList.add(buisness);
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
        return buisnessList;
    }

    public List<Buisness> getBusiness(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM business_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<Buisness> buisnessList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Buisness buisness =new Buisness();

                buisness.setBusiness_state(rs.getString("business_state"));
                buisness.setBusiness_type(rs.getString("business_type"));
                buisness.setBusiness_distribution(rs.getString("business_distribution"));
                buisness.setBusiness_remark(rs.getString("business_remark"));

                buisnessList.add(buisness);
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
        return buisnessList;
    }
    /**
     * 更新业务类型状态
     */

    public int updateBusinessState(int id){
        int m = -1;
        String sql = "UPDATE business_info SET business_state = '作废' WHERE business_id = ?;";
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



}
