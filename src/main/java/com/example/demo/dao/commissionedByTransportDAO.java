package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.CommissionedByTransport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class commissionedByTransportDAO {

    public int addCommissionedByTransport(String commissionedByTransport_number ,String commissionedByTransport_type ,String commissionedByTransport_carrier ,String commissionedByTransport_way ,String commissionedByTransport_from_peo ,String commissionedByTransport_to_peo ,String commissionedByTransport_remark) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into commissionedbytransport_info(commissionedByTransport_number, commissionedByTransport_type,commissionedByTransport_carrier,commissionedByTransport_way,commissionedByTransport_from_peo,commissionedByTransport_to_peo,commissionedByTransport_remark)values('"+commissionedByTransport_number+"','"+commissionedByTransport_type+"','"+commissionedByTransport_carrier+"','"+commissionedByTransport_way+"','"+commissionedByTransport_from_peo+"','"+commissionedByTransport_to_peo+"','"+commissionedByTransport_remark+"')";
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

    public List<CommissionedByTransport> getCommissionedByTransportByCommissionedByTransportType(String commissionedByTransportType){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM commissionedbytransport_info WHERE commissionedByTransport_type = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<CommissionedByTransport> commissionedByTransportList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,commissionedByTransportType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                CommissionedByTransport commissionedByTransport =new CommissionedByTransport();

                commissionedByTransport.setCommissionedByTransport_carrier(rs.getString("commissionedByTransport_carrier"));
                commissionedByTransport.setCommissionedByTransport_number(rs.getString("commissionedByTransport_number"));
                commissionedByTransport.setCommissionedByTransport_type(rs.getString("commissionedByTransport_type"));
                commissionedByTransport.setCommissionedByTransport_way(rs.getString("commissionedByTransport_way"));
                commissionedByTransport.setCommissionedByTransport_from_peo(rs.getString("commissionedByTransport_from_peo"));
                commissionedByTransport.setCommissionedByTransport_to_peo(rs.getString("commissionedByTransport_to_peo"));
                commissionedByTransport.setCommissionedByTransport_remark(rs.getString("commissionedByTransport_remark"));


                commissionedByTransportList.add(commissionedByTransport);
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
        return commissionedByTransportList;
    }

    public List<CommissionedByTransport> getCommissionedByTransport(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM commissionedbytransport_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<CommissionedByTransport> commissionedByTransportList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                CommissionedByTransport commissionedByTransport =new CommissionedByTransport();

                commissionedByTransport.setCommissionedByTransport_carrier(rs.getString("commissionedByTransport_carrier"));
                commissionedByTransport.setCommissionedByTransport_number(rs.getString("commissionedByTransport_number"));
                commissionedByTransport.setCommissionedByTransport_type(rs.getString("commissionedByTransport_type"));
                commissionedByTransport.setCommissionedByTransport_way(rs.getString("commissionedByTransport_way"));
                commissionedByTransport.setCommissionedByTransport_from_peo(rs.getString("commissionedByTransport_from_peo"));
                commissionedByTransport.setCommissionedByTransport_to_peo(rs.getString("commissionedByTransport_to_peo"));
                commissionedByTransport.setCommissionedByTransport_remark(rs.getString("commissionedByTransport_remark"));


                commissionedByTransportList.add(commissionedByTransport);
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
        return commissionedByTransportList;
    }

}
