package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Buisness;
import com.example.demo.vo.CityNode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class city_nodeDAO {
    public int addCity(String cityName,String cityId,String cityState,String cityInstitution,String cityDistribution) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into city_node_info(city_name, city_id,city_state,city_institution,city_distribution)values('"+cityName+"','"+cityId+"','"+cityState+"','"+cityInstitution+"','"+cityDistribution+"')";
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

    public List<CityNode> getCitynodeBycityName(String cityName){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM city_node_info WHERE city_name = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<CityNode> cityNodeList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,cityName);
            rs=pstmt.executeQuery();
            while (rs.next()){
                CityNode cityNode = new CityNode();

                cityNode.setCity_name(rs.getString("city_name"));
                cityNode.setCity_id(rs.getString("city_id"));
                cityNode.setCity_state(rs.getString("city_state"));
                cityNode.setCity_institution(rs.getString("city_institution"));
                cityNode.setCity_distribution(rs.getString("city_distribution"));
                cityNode.setNode_name(rs.getString("node_name"));
                cityNode.setNode_type(rs.getString("node_type"));
                cityNodeList.add(cityNode);
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
        return cityNodeList;
    }

    public List<CityNode> getCityNode(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM city_node_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<CityNode> cityNodeList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                CityNode cityNode =new CityNode();

                cityNode.setCity_name(rs.getString("city_name"));
                cityNode.setCity_id(rs.getString("city_id"));
                cityNode.setCity_state(rs.getString("city_state"));
                cityNode.setCity_institution(rs.getString("city_institution"));
                cityNode.setCity_distribution(rs.getString("city_distribution"));
                cityNode.setNode_name(rs.getString("node_name"));
                cityNode.setNode_type(rs.getString("node_type"));
                cityNodeList.add(cityNode);
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
        return cityNodeList;
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
