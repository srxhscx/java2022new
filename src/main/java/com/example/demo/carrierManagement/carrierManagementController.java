package com.example.demo.carrierManagement;

import com.example.demo.dao.BuisnessDAO;
import com.example.demo.dao.carrierManagementDAO;
import com.example.demo.menu.MainMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLException;

public class carrierManagementController {

    @FXML
    private TextField address;

    @FXML
    private TextField phone;

    @FXML
    private TextField contact;

    @FXML
    private Button checkback;

    @FXML
    private TextField name;

    @FXML
    private TextField tel;

    @FXML
    private TextArea remark;

    @FXML
    private Button checksave;

    @FXML
    private TextField id;

    @FXML
    private TextField shortname;

    @FXML
    void save(ActionEvent event) throws SQLException {
        carrierManagementDAO carriermanagementDAO = new carrierManagementDAO();
        carriermanagementDAO.addCarrierManagement(Integer.valueOf(id.getText()).intValue(),name.getText(),shortname.getText(),address.getText(),contact.getText(),phone.getText(),tel.getText(),remark.getText());
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();
    }

    @FXML
    void back(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) checkback.getScene().getWindow();
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

