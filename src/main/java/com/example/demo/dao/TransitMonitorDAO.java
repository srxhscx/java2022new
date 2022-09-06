package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.TransitMonitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransitMonitorDAO {
    //    information_number
//    information_license
//    information_state
//    information_carrier
//    information_on_way
    public int addTransitMonitor(String informationNumber,String informationLicense,String informationState,String informationCarrier,String informationOnWay) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into transitmonitor_info(information_number, information_license,information_state,information_carrier,information_on_way)values('"+informationNumber+"','"+informationLicense+"','"+informationState+"','"+informationCarrier+"','"+informationOnWay+"')";
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

    public List<TransitMonitor> getTransitMonitorByTransitMonitorState(String transitMonitorState){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM transitmonitor_info WHERE information_state = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<TransitMonitor> transitMonitorList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,transitMonitorState);
            rs=pstmt.executeQuery();
            while (rs.next()){
                TransitMonitor transitMonitor =new TransitMonitor();

                transitMonitor.setInformation_license(rs.getString("information_license"));
                transitMonitor.setInformation_carrier(rs.getString("information_carrier"));
                transitMonitor.setInformation_number(rs.getString("information_number"));
                transitMonitor.setInformation_state(rs.getString("information_state"));
                transitMonitor.setInformation_on_way(rs.getString("information_on_way"));

                transitMonitorList.add(transitMonitor);
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
        return transitMonitorList;
    }

    public List<TransitMonitor> getTransitMonitor(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM transitmonitor_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<TransitMonitor> transitMonitorList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                TransitMonitor transitMonitor =new TransitMonitor();

                transitMonitor.setInformation_license(rs.getString("information_license"));
                transitMonitor.setInformation_carrier(rs.getString("information_carrier"));
                transitMonitor.setInformation_number(rs.getString("information_number"));
                transitMonitor.setInformation_state(rs.getString("information_state"));
                transitMonitor.setInformation_on_way(rs.getString("information_on_way"));

                transitMonitorList.add(transitMonitor);
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
        return transitMonitorList;
    }
}
