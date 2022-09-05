package com.example.demo.dao;

import com.example.demo.util.ConnectionUtil;
import com.example.demo.vo.Buisness;
import com.example.demo.vo.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {
    /**
     *增加货物
     */
    public int addGoods(String goodName,String goodState,String goodRemark) throws SQLException {
        //获取连接
        Connection cn = ConnectionUtil.getConnection();
        String sql = "insert into good_info(good_name, good_state, good_remark)values('"+goodName+"','"+goodState+"','"+goodRemark+"')";
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
     * 通过货物名称查询
     */
    public List<Goods> getGoodsBygoodName(String goodName){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM good_info WHERE good_name = ?";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs=null;

        List<Goods> goodsList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            pstmt.setString(1,goodName);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Goods goods =new Goods();
                goods.setGood_name(rs.getString("good_name"));
                goods.setGood_state(rs.getString("good_state"));
                goods.setGood_remark(rs.getString("good_remark"));

                goodsList.add(goods);


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
        return goodsList;
    }

    /**
     * 查询所有货物
     */
    public List<Goods> getGoods(){
        Connection cn = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM good_info";
        //发送给mysql执行
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        List<Goods> goodsList = new ArrayList<>();
        try{
            pstmt = cn.prepareStatement(sql);
            //返回影响行数
            //pstmt.setString(1,businessType);
            rs=pstmt.executeQuery();
            while (rs.next()){

                Goods goods = new Goods();

                goods.setGood_name(rs.getString("good_name"));
                goods.setGood_state(rs.getString("good_state"));
                goods.setGood_remark(rs.getString("good_remark"));

                goodsList.add(goods);
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
        return goodsList;
    }

}
