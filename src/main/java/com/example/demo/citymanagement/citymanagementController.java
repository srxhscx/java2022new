package com.example.demo.citymanagement;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.dao.city_nodeDAO;
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

public class citymanagementController {

    @FXML
    private TextField cityinstitutionText;

    @FXML
    private TextField citydistributionText;

    @FXML
    private Button citysaveBtn;

    @FXML
    private TextField citynameText;

    @FXML
    private TextField cityidText;

    @FXML
    private Button citycloseBtn;

    @FXML
    void citysave(ActionEvent event) throws SQLException {
        String citycityname = this.citynameText.getText();
        String citynameid = this.cityidText.getText();
        String cityinstitution = this.cityinstitutionText.getText();
        String citydistribution = this.citydistributionText.getText();
        String citystate = "正常";


        city_nodeDAO city_nodeDAO1 = new city_nodeDAO();

        city_nodeDAO1.addCity(citycityname,citynameid,citystate,cityinstitution,citydistribution);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();
        this.citynameText.clear();
        this.cityidText.clear();
        this.cityinstitutionText.clear();
        this.citydistributionText.clear();
    }

    @FXML
    void cityclose(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) citycloseBtn.getScene().getWindow();
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
