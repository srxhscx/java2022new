package com.example.demo.commissionedByFee;

import com.example.demo.dao.FeeDAO;
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

public class commissionedByFeeController {
    @FXML
    private TextField cbooknodeText;

    @FXML
    private TextField ctransnodeText;

    @FXML
    private TextField csubprimemoneyText;

    @FXML
    private TextField clatemoneyText;

    @FXML
    private TextField cothermoneyText;

    @FXML
    private TextField cwhyothermoneyText;

    @FXML
    private Button csaveBtn;

    @FXML
    private Button ccloseBtn;

    @FXML
    void csave(ActionEvent event) throws SQLException {
        String cbooknode = this.cbooknodeText.getText();
        String ctransnode = this.ctransnodeText.getText();
        String csubprimemoney = this.csubprimemoneyText.getText();
        String clatemoney = this.clatemoneyText.getText();
        String cothermoney = this.cothermoneyText.getText();
        String cwhyothermoney = this.cwhyothermoneyText.getText();


        FeeDAO feeDAO = new FeeDAO();

        feeDAO.addFee(cbooknode,ctransnode,csubprimemoney,clatemoney,cothermoney,cwhyothermoney);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();
        this.cbooknodeText.clear();
        this.ctransnodeText.clear();
        this.csubprimemoneyText.clear();
        this.clatemoneyText.clear();
        this.cothermoneyText.clear();
        this.cwhyothermoneyText.clear();
    }

    @FXML
    void cclose(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) ccloseBtn.getScene().getWindow();
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
