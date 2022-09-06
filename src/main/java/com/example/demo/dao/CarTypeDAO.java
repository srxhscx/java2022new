package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Cartype;
import com.example.demo.vo.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarTypeDAO {
    /**
     *增加车型
     */
    public int addCarType(String carType,String carVolume,String carLoad,String carState,String carRemark) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into car_type_info(car_type, car_volume, car_load,car_state,car_remark)values('"+carType+"','"+carVolume+"','"+carLoad+"','"+carState+"','"+carRemark+"')";
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

    /**
     * 通过车型查询
     * @return
     */
    public List<Cartype> getCarTypeBycarType(String carType){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM car_type_info WHERE car_type = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<Cartype> carTypeList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,carType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Cartype cartype =new Cartype();

                cartype.setCar_type(rs.getString("car_type"));
                cartype.setCar_state(rs.getString("car_state"));
                cartype.setCar_volume(rs.getString("car_volume"));
                cartype.setCar_load(rs.getString("car_load"));
                cartype.setCar_remark(rs.getString("car_remark"));

                carTypeList.add(cartype);


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
        return carTypeList;
    }

    /**
     * 查询所有车型
     */
    public List<Cartype> getCartype() {
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM car_type_info ";
        //发送给mysql执行
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Cartype> carTypeList = new ArrayList<>();
        try {
            pstmt = cn.prepareStatement(sql);
            //返回影响行数

            rs = pstmt.executeQuery();
            while (rs.next()) {
                Cartype cartype = new Cartype();

                cartype.setCar_type(rs.getString("car_type"));
                cartype.setCar_state(rs.getString("car_state"));
                cartype.setCar_volume(rs.getString("car_volume"));
                cartype.setCar_load(rs.getString("car_load"));
                cartype.setCar_remark(rs.getString("car_remark"));

                carTypeList.add(cartype);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return carTypeList;

    }
}
