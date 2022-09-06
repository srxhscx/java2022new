package com.example.demo.characterManagement;

import com.example.demo.dao.BuisnessDAO;
import com.example.demo.dao.characterManagementDAO;
import com.example.demo.menu.MainMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class characterManagementController {

    @FXML
    private Button save;

    @FXML
    private TextField name;

    @FXML
    private TextField remark;

    @FXML
    private TextField id;

    @FXML
    private Button close;

    @FXML
    void saveChecked(ActionEvent event) throws SQLException {
        characterManagementDAO characterManagementdao = new characterManagementDAO();
        characterManagementdao.addAccountManagement(Integer.valueOf(id.getText()),name.getText(),remark.getText());
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();
    }

    @FXML
    void closeChecked(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) close.getScene().getWindow();
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

}
