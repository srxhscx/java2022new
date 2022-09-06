package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.newSignInDoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class newSignInDocDAO {
    public int addNewSignInDoc(String goodgetNub,String goodgetFcity,String goodgetFhouse,String goodgetLcity,String goodgetLhouse,String goodgetGoodarea,String goodgetGetarea,String goodgetPeople,String goodgetRunway,String goodgetType,String goodgetGoodmuch,String goodgetWrite,String goodgetAction) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into goodget_info(goodget_nub,goodget_fcity ,goodget_fhouse,goodget_lcity,goodget_lhouse, goodget_goodarea, goodget_getarea,goodget_people, goodget_runway,goodget_type,goodget_goodmuch,goodget_write,goodget_action)values('"+goodgetNub+"','"+goodgetFcity+"','"+goodgetFhouse+"','"+goodgetLcity+"','"+goodgetLhouse+"','"+goodgetGoodarea+"','"+goodgetGetarea+"','"+goodgetPeople+"','"+goodgetRunway+"','"+goodgetType+"','"+goodgetGoodmuch+"','"+goodgetWrite+"','"+goodgetAction+"')";
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

    public List<newSignInDoc> getNewSignInDocByGoodGetType(String goodgetType){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM goodget_info WHERE goodget_type = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<newSignInDoc> newSignInDocList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,goodgetType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                newSignInDoc newSignInDoc =new newSignInDoc();

                newSignInDoc.setGoodget_type(rs.getString("goodget_type"));
                newSignInDoc.setGoodget_fcity(rs.getString("goodget_fcity"));
                newSignInDoc.setGoodget_lcity(rs.getString("goodget_lcity"));
                newSignInDoc.setGoodget_people(rs.getString("goodget_people"));
                newSignInDoc.setGoodget_nub(rs.getString("goodget_nub"));
                newSignInDoc.setGoodget_fhouse(rs.getString("goodget_fhouse"));
                newSignInDoc.setGoodget_lhouse(rs.getString("goodget_lhouse"));
                newSignInDoc.setGoodget_runway(rs.getString("goodget_runway"));
                newSignInDoc.setGoodget_goodarea(rs.getString("goodget_goodarea"));
                newSignInDoc.setGoodget_getarea(rs.getString("goodget_getarea"));
                newSignInDoc.setGoodget_goodmuch(rs.getString("goodget_goodmuch"));
                newSignInDoc.setGoodget_write(rs.getString("goodget_write"));
                newSignInDoc.setGoodget_action(rs.getString("goodget_action"));




                newSignInDocList.add(newSignInDoc);
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
        return newSignInDocList;
    }

    public List<newSignInDoc> getNewSignInDoc(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM goodget_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<newSignInDoc> newSignInDocList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){
                newSignInDoc newSignInDoc =new newSignInDoc();

                newSignInDoc.setGoodget_type(rs.getString("goodget_type"));
                newSignInDoc.setGoodget_fcity(rs.getString("goodget_fcity"));
                newSignInDoc.setGoodget_lcity(rs.getString("goodget_lcity"));
                newSignInDoc.setGoodget_people(rs.getString("goodget_people"));
                newSignInDoc.setGoodget_nub(rs.getString("goodget_nub"));
                newSignInDoc.setGoodget_fhouse(rs.getString("goodget_fhouse"));
                newSignInDoc.setGoodget_lhouse(rs.getString("goodget_lhouse"));
                newSignInDoc.setGoodget_runway(rs.getString("goodget_runway"));
                newSignInDoc.setGoodget_goodarea(rs.getString("goodget_goodarea"));
                newSignInDoc.setGoodget_getarea(rs.getString("goodget_getarea"));
                newSignInDoc.setGoodget_goodmuch(rs.getString("goodget_goodmuch"));
                newSignInDoc.setGoodget_write(rs.getString("goodget_write"));
                newSignInDoc.setGoodget_action(rs.getString("goodget_action"));

                newSignInDocList.add(newSignInDoc);
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
        return newSignInDocList;
    }
    /**
     * 更新业务类型状态
     */




}
