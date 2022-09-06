package com.example.demo.dao;

import com.example.demo.model.Role;
import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Buisness;
import com.example.demo.vo.Fee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeeDAO {

    /**
     *增加业务类型
     */
    public int addFee(String feeBooknode,String feeTransnode,String feeSubprimemoney,String feeLatemoney,String feeOthermoney,String feeWhyothermoney) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into fee_info(fee_booknode,fee_transnode,fee_subprimemoney,fee_latemoney,fee_othermoney,fee_whyothermoney)values('"+feeBooknode+"','"+feeTransnode+"','"+feeSubprimemoney+"','"+feeLatemoney+"','"+feeOthermoney+"','"+feeWhyothermoney+"')";
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

    public List<Fee> getFeeByFeeBooknode(String feeBooknode){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM fee_info WHERE fee_booknode = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<Fee> feeList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,feeBooknode);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Fee fee =new Fee();

                fee.setFee_booknode(rs.getString("fee_booknode"));
                fee.setFee_transnode(rs.getString("fee_transnode"));
                fee.setFee_subprimemoney(rs.getString("fee_subprimemoney"));
                fee.setFee_latemoney(rs.getString("fee_latemoney"));
                fee.setFee_othermoney(rs.getString("fee_othermoney"));
                fee.setFee_whyothermoney(rs.getString("fee_whyothermoney"));

                feeList.add(fee);
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
        return feeList;
    }

    public List<Fee> getFee(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM fee_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<Fee> feeList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Fee fee =new Fee();

                fee.setFee_booknode(rs.getString("fee_booknode"));
                fee.setFee_transnode(rs.getString("fee_transnode"));
                fee.setFee_subprimemoney(rs.getString("fee_subprimemoney"));
                fee.setFee_latemoney(rs.getString("fee_latemoney"));
                fee.setFee_othermoney(rs.getString("fee_othermoney"));
                fee.setFee_whyothermoney(rs.getString("fee_whyothermoney"));

                feeList.add(fee);
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
        return feeList;
    }



}
