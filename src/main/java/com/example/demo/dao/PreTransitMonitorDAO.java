package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.PreTransitMonitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreTransitMonitorDAO {
    public int addPreTransitMonitor(String preInformationNumber,String preInformationLicense,String preInformationState,String preInformationCarrier,String preInformationOnWay) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into transitmonitor_info(information_number, information_license,information_state,information_carrier,information_on_way)values('"+preInformationNumber+"','"+preInformationLicense+"','"+preInformationState+"','"+preInformationCarrier+"','"+preInformationOnWay+"')";
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

    public List<PreTransitMonitor> getPreTransitMonitorByPreTransitMonitorState(String preTransitMonitorState){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM transitmonitor_info WHERE information_state = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<PreTransitMonitor> preTransitMonitorList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,preTransitMonitorState);
            rs=pstmt.executeQuery();
            while (rs.next()){
                PreTransitMonitor preTransitMonitor =new PreTransitMonitor();

                preTransitMonitor.setPreInformation_license(rs.getString("information_carrier"));
                preTransitMonitor.setPreInformation_carrier(rs.getString("information_carrier"));
                preTransitMonitor.setPreInformation_number(rs.getString("information_number"));
                preTransitMonitor.setPreInformation_state(rs.getString("information_state"));
                preTransitMonitor.setPreInformation_on_way(rs.getString("information_on_way"));

                preTransitMonitorList.add(preTransitMonitor);
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
        return preTransitMonitorList;
    }

    public List<PreTransitMonitor> getPreTransitMonitor(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM transitmonitor_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<PreTransitMonitor> preTransitMonitorList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                PreTransitMonitor preTransitMonitor =new PreTransitMonitor();

                preTransitMonitor.setPreInformation_license(rs.getString("information_carrier"));
                preTransitMonitor.setPreInformation_carrier(rs.getString("information_carrier"));
                preTransitMonitor.setPreInformation_number(rs.getString("information_number"));
                preTransitMonitor.setPreInformation_state(rs.getString("information_state"));
                preTransitMonitor.setPreInformation_on_way(rs.getString("information_on_way"));

                preTransitMonitorList.add(preTransitMonitor);
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
        return preTransitMonitorList;
    }
}
