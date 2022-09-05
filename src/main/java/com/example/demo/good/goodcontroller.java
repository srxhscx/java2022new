package com.example.demo.good;

import com.example.demo.dao.BuisnessDAO;
import com.example.demo.dao.GoodsDAO;
import com.example.demo.menu.MainMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class goodcontroller{

    @FXML
    private TextField goodRemarkText;

    @FXML
    private Button closeBtn;

    @FXML
    private TextField goodnameText;

    @FXML
    private Button saveBtn;

    @FXML
    void close(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) closeBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new MainMenu().start(primaryStage);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    void save(ActionEvent event) throws SQLException {
        String goodname = this.goodnameText.getText();
        String goodremark = this.goodRemarkText.getText();
        String goodstate = "正常";

        GoodsDAO goodsDAO = new GoodsDAO();

        goodsDAO.addGoods(goodname,goodstate,goodremark);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();
        this.goodnameText.clear();
        this.goodRemarkText.clear();
    }
}
