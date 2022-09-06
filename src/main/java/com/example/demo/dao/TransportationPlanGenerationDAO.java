package com.example.demo.dao;

import com.example.demo.model.Role;
import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.TransportationPlanGeneration;
import javafx.beans.property.StringProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportationPlanGenerationDAO {

    public int addTransportationPlanGeneration(String transportationPlanGenerationState, String transportationPlanGenerationType, String transportationPlanGenerationFromCity, String transportationPlanGenerationToCity, String transportationPlanGenerationFromBase, String transportationPlanGenerationToBase, String transportationPlanGenerationNumber, String transportationPlanGenerationVolume, String transportationPlanGenerationWeight, String transportationPlanGenerationRemark) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();

        String sql = "insert into transportationplangeneration_info(transportationPlanGeneration_state,transportationPlanGeneration_type,transportationPlanGeneration_from_city,transportationPlanGeneration_to_city,transportationPlanGeneration_from_base,transportationPlanGeneration_to_base,transportationPlanGeneration_number,transportationPlanGeneration_volume,transportationPlanGeneration_weight,transportationPlanGeneration_remark)values('"+transportationPlanGenerationState+"','"+transportationPlanGenerationType+"','"+transportationPlanGenerationFromCity+"','"+transportationPlanGenerationToCity+"','"+transportationPlanGenerationFromBase+"','"+transportationPlanGenerationToBase+"','"+transportationPlanGenerationNumber+"','"+transportationPlanGenerationVolume+"','"+transportationPlanGenerationWeight+"','"+transportationPlanGenerationRemark+"')";

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

    public List<TransportationPlanGeneration> getTransportationPlanGenerationByTransportationPlanGenerationType(String transportationPlanGenerationType){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM transportationplangeneration_info WHERE transportationPlanGeneration_type = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<TransportationPlanGeneration> transportationPlanGenerationList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,transportationPlanGenerationType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                TransportationPlanGeneration transportationPlanGeneration = new TransportationPlanGeneration();

                transportationPlanGeneration.setTransportationPlanGeneration_state(rs.getString("transportationPlanGeneration_state"));
                transportationPlanGeneration.setTransportationPlanGeneration_type(rs.getString("transportationPlanGeneration_type"));
                transportationPlanGeneration.setTransportationPlanGeneration_from_city(rs.getString("transportationPlanGeneration_from_city"));
                transportationPlanGeneration.setTransportationPlanGeneration_to_city(rs.getString("transportationPlanGeneration_to_city"));
                transportationPlanGeneration.setTransportationPlanGeneration_from_base(rs.getString("transportationPlanGeneration_from_base"));
                transportationPlanGeneration.setTransportationPlanGeneration_to_base(rs.getString("transportationPlanGeneration_to_base"));
                transportationPlanGeneration.setTransportationPlanGeneration_number(rs.getString("transportationPlanGeneration_number"));
                transportationPlanGeneration.setTransportationPlanGeneration_volume(rs.getString("transportationPlanGeneration_volume"));
                transportationPlanGeneration.setTransportationPlanGeneration_weight(rs.getString("transportationPlanGeneration_weight"));
                transportationPlanGeneration.setTransportationPlanGeneration_remark(rs.getString("transportationPlanGeneration_remark"));

                transportationPlanGenerationList.add(transportationPlanGeneration);
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
        return transportationPlanGenerationList;
    }

    public List<TransportationPlanGeneration> getTransportationPlanGeneration(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM transportationplangeneration_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<TransportationPlanGeneration> transportationPlanGenerationList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);

            rs=pstmt.executeQuery();
            while (rs.next()){
                TransportationPlanGeneration transportationPlanGeneration =new TransportationPlanGeneration();

                transportationPlanGeneration.setTransportationPlanGeneration_state(rs.getString("transportationPlanGeneration_state"));
                transportationPlanGeneration.setTransportationPlanGeneration_type(rs.getString("transportationPlanGeneration_type"));
                transportationPlanGeneration.setTransportationPlanGeneration_from_city(rs.getString("transportationPlanGeneration_from_city"));
                transportationPlanGeneration.setTransportationPlanGeneration_to_city(rs.getString("transportationPlanGeneration_to_city"));
                transportationPlanGeneration.setTransportationPlanGeneration_from_base(rs.getString("transportationPlanGeneration_from_base"));
                transportationPlanGeneration.setTransportationPlanGeneration_to_base(rs.getString("transportationPlanGeneration_to_base"));
                transportationPlanGeneration.setTransportationPlanGeneration_number(rs.getString("transportationPlanGeneration_number"));
                transportationPlanGeneration.setTransportationPlanGeneration_volume(rs.getString("transportationPlanGeneration_volume"));
                transportationPlanGeneration.setTransportationPlanGeneration_weight(rs.getString("transportationPlanGeneration_weight"));
                transportationPlanGeneration.setTransportationPlanGeneration_remark(rs.getString("transportationPlanGeneration_remark"));

                transportationPlanGenerationList.add(transportationPlanGeneration);
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
        return transportationPlanGenerationList;
    }
}
