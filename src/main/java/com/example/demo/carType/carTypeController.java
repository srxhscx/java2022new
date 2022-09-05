package com.example.demo.carType;

import com.example.demo.dao.CarTypeDAO;
import com.example.demo.dao.GoodsDAO;
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

public class carTypeController {

    @FXML
    private TextField CarVolumeText;

    @FXML
    private TextField CartypeText;

    @FXML
    private TextField CarLoadText;

    @FXML
    private TextField carTypeRemark;

    @FXML
    private Button CarCloseBtn;

    @FXML
    private Button CarSaveBtn;

    @FXML
    void CarSave(ActionEvent event) throws SQLException {
        String carType = this.CartypeText.getText();
        String carVolume = this.CarVolumeText.getText();
        String carTypestate = "正常";
        String carLoad = this.CarLoadText.getText();
        String carRemark = this.carTypeRemark.getText();
        CarTypeDAO carTypeDAO = new CarTypeDAO();

        carTypeDAO.addCarType(carType,carVolume,carLoad,carTypestate,carRemark);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();
        this.CartypeText.clear();
        this.CarVolumeText.clear();
        this.CarLoadText.clear();
        this.carTypeRemark.clear();
    }


    @FXML
    void CarClose(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) CarCloseBtn.getScene().getWindow();
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
