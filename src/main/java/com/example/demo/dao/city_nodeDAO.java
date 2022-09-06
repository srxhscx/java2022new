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

    public int update(String nodeType,String nodeName,String cityName){
        int m = -1;
        String sql = "UPDATE city_node_info SET node_type = ?, node_name= ? WHERE city_name = ?;";
        Connection cn = ConnectionUtil.getConnection();

//        info = 'my name is {my_name},i am {my_age} years old,my price is {my_price}'\
//    .format(my_name=name,my_age=age,my_price=price)
        PreparedStatement pstmt =  null;

        try{
            pstmt = cn.prepareStatement(sql);

            pstmt.setString(1,nodeType);
            pstmt.setString(2,nodeName);
            pstmt.setString(3,cityName);
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
