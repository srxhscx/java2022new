package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Buisness;
import com.example.demo.vo.CarRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class carRecordDAO {
    /**
     *增加车辆备案
     */
    public int addCarRecord(String carNumber,String trailerNumber,String carType,String carState,String carCarrier,String carVolume,String carLoad,String carPeople,String carTelephone,String carRemark) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into car_record_info(car_number, trailer_number,car_type,car_state,car_carrier,car_volume,car_load,car_people,car_telephone,car_remark)values('"+carNumber+"','"+trailerNumber+"','"+carType+"','"+carState+"','"+carCarrier+"','"+carVolume+"','"+carLoad+"','"+carPeople+"','"+carTelephone+"','"+carRemark+"')";
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

    public List<CarRecord> getCarRecordByCarrier(String carCarrier){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM car_record_info WHERE car_carrier = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<CarRecord> carRecordsList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,carCarrier);

            rs=pstmt.executeQuery();
            while (rs.next()){
                CarRecord carRecord =new CarRecord();

                carRecord.setCar_number(rs.getString("car_number"));
                carRecord.setTrailer_number(rs.getString("trailer_number"));
                carRecord.setCar_type(rs.getString("car_type"));
                carRecord.setCar_state(rs.getString("car_state"));
                carRecord.setCar_carrier(rs.getString("car_carrier"));
                carRecord.setCar_volume(rs.getString("car_volume"));
                carRecord.setCar_load(rs.getString("car_load"));
                carRecord.setCar_people(rs.getString("car_people"));
                carRecord.setCar_telephone(rs.getString("car_telephone"));
                carRecord.setCar_remark(rs.getString("car_remark"));


                carRecordsList.add(carRecord);
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
        return carRecordsList;
    }

    public List<CarRecord> getCarRecordByCarnumber(String carnumber){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM car_record_info WHERE car_number = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<CarRecord> carRecordsList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,carnumber);

            rs=pstmt.executeQuery();
            while (rs.next()){
                CarRecord carRecord =new CarRecord();

                carRecord.setCar_number(rs.getString("car_number"));
                carRecord.setTrailer_number(rs.getString("trailer_number"));
                carRecord.setCar_type(rs.getString("car_type"));
                carRecord.setCar_state(rs.getString("car_state"));
                carRecord.setCar_carrier(rs.getString("car_carrier"));
                carRecord.setCar_volume(rs.getString("car_volume"));
                carRecord.setCar_load(rs.getString("car_load"));
                carRecord.setCar_people(rs.getString("car_people"));
                carRecord.setCar_telephone(rs.getString("car_telephone"));
                carRecord.setCar_remark(rs.getString("car_remark"));


                carRecordsList.add(carRecord);
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
        return carRecordsList;
    }

    public List<CarRecord> getCarRecord(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM car_record_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<CarRecord> carRecordsList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                CarRecord carRecord =new CarRecord();

                carRecord.setCar_number(rs.getString("car_number"));
                carRecord.setTrailer_number(rs.getString("trailer_number"));
                carRecord.setCar_type(rs.getString("car_type"));
                carRecord.setCar_state(rs.getString("car_state"));
                carRecord.setCar_carrier(rs.getString("car_carrier"));
                carRecord.setCar_volume(rs.getString("car_volume"));
                carRecord.setCar_load(rs.getString("car_load"));
                carRecord.setCar_people(rs.getString("car_people"));
                carRecord.setCar_telephone(rs.getString("car_telephone"));
                carRecord.setCar_remark(rs.getString("car_remark"));


                carRecordsList.add(carRecord);
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
        return carRecordsList;
    }
}
