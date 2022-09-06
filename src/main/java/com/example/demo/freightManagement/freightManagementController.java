package com.example.demo.freightManagement;

import com.example.demo.dao.accountManagementDAO;
import com.example.demo.dao.freightManagementDAO;
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

public class freightManagementController implements Initializable {

    @FXML
    private ComboBox startCity;

    @FXML
    private TextField deadTime;

    @FXML
    private Button save;

    @FXML
    private TextField weight;

    @FXML
    private TextField volumn;

    @FXML
    private ComboBox allOne;

    @FXML
    private ComboBox destinationCity;

    @FXML
    private TextField premium;

    @FXML
    private TextField freightNum;

    @FXML
    private ComboBox transportMode;

    @FXML
    private TextField startTime;

    @FXML
    private TextField time;

    @FXML
    private Button close;

    @FXML
    private ComboBox freightName;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transportMode.getItems().addAll(
                "仓到点",
                "仓到仓",
                "点到仓",
                "点到点"
        );
        allOne.getItems().addAll(
                "整车",
                "零担"
        );
        freightName.getItems().addAll(
                "中通快递",
                "顺丰速递",
                "中国东方航空",
                "大众汽车公司",
                "中国南方航空",
                "东风汽车公司"
        );
        startCity.getItems().addAll(
                "北京",
                "沈阳",
                "长沙",
                "上海",
                "长春","哈尔滨","呼和浩特","天津","石家庄","济南","西安","兰州","武汉","南京","广州","深圳","南京"
        );
        destinationCity.getItems().addAll(
                "北京",
                "沈阳",
                "长沙",
                "上海",
                "长春","哈尔滨","呼和浩特","天津","石家庄","济南","西安","兰州","武汉","南京","广州","深圳","南京"
        );
        transportMode.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        transportMode.setEditable(true);
        transportMode.setPromptText("");
        //设置可见行数, 超过显示滚动条
        transportMode.setVisibleRowCount(4);

        allOne.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        allOne.setEditable(true);
        allOne.setPromptText("");
        //设置可见行数, 超过显示滚动条
        allOne.setVisibleRowCount(4);

        freightName.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        freightName.setEditable(true);
        freightName.setPromptText("");
        //设置可见行数, 超过显示滚动条
        freightName.setVisibleRowCount(4);

        startCity.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        startCity.setEditable(true);
        startCity.setPromptText("");
        //设置可见行数, 超过显示滚动条
        startCity.setVisibleRowCount(4);

        destinationCity.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        destinationCity.setEditable(true);
        destinationCity.setPromptText("");
        //设置可见行数, 超过显示滚动条
        destinationCity.setVisibleRowCount(4);


    }

    @FXML
    void checkedsave(ActionEvent event) throws SQLException {
        freightManagementDAO freightManagementdao=new freightManagementDAO();
        freightManagementdao.addFreightManagement(transportMode.getValue().toString(),allOne.getValue().toString(),
                                                  freightNum.getText(),freightName.getValue().toString(),startCity.getValue().toString(),
                                                  destinationCity.getValue().toString(),weight.getText(),volumn.getText(),time.getText(),
                                                  premium.getText(),startTime.getText(),deadTime.getText());
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();

    }

    @FXML
    void checkedclose(ActionEvent event) {
        Platform.runLater(()-> {
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

