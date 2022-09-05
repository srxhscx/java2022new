package com.example.demo.business;

import com.example.demo.dao.BuisnessDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.homepage.Main;
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

public class businessController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        distributionText.getItems().addAll(
                "仓到点",
                "仓到仓",
                "点到仓",
                "点到点"
        );
        //数据源为空时显示
        distributionText.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        distributionText.setEditable(true);
        distributionText.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        distributionText.setVisibleRowCount(4);
    }

    @FXML
    private TextField businessremarkText;

    @FXML
    private Button closeBtn;

    @FXML
    private ComboBox distributionText;

    @FXML
    private TextField businesstypeText;

    @FXML
    private Button saveBtn;

    @FXML
    void save(ActionEvent event) throws SQLException {
            String businesstype = this.businesstypeText.getText();
            String businessremark = this.businessremarkText.getText();
            String businessstate = "正常";
            String distribution = distributionText.getValue().toString();

        BuisnessDAO businessDAO = new BuisnessDAO();

        businessDAO.addBusiness(businesstype,businessstate,distribution,businessremark);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();
        this.businessremarkText.clear();
        this.businesstypeText.clear();

    }

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


}
