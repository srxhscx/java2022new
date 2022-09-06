package com.example.demo.routeManagement;

import com.example.demo.dao.accountManagementDAO;
import com.example.demo.dao.routeManagmentDAO;
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

public class routeManagementController  implements Initializable {
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        type.getItems().addAll(
                "仓到点",
                "仓到仓",
                "点到仓",
                "点到点"
        );
        allone.getItems().addAll(
                "整车",
                "零担"
        );
        firstFreight.getItems().addAll(
                "中通快递",
                "顺丰速递",
                "中国东方航空",
                "大众汽车公司",
                "中国南方航空",
                "东风汽车公司"
        );
        secondFreight.getItems().addAll(
                "中通快递",
                "顺丰速递",
                "中国东方航空",
                "大众汽车公司",
                "中国南方航空",
                "东风汽车公司",
                "圆通速递"
        );

        startCity.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        startCity.setEditable(true);
        startCity.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        startCity.setVisibleRowCount(4);

        destinationCity.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        destinationCity.setEditable(true);
        destinationCity.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        destinationCity.setVisibleRowCount(4);

        type.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        type.setEditable(true);
        type.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        type.setVisibleRowCount(4);

        allone.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        allone.setEditable(true);
        allone.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        allone.setVisibleRowCount(4);

        firstFreight.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        firstFreight.setEditable(true);
        firstFreight.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        firstFreight.setVisibleRowCount(4);

        secondFreight.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        secondFreight.setEditable(true);
        secondFreight.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        secondFreight.setVisibleRowCount(4);



    }

    @FXML
    private ComboBox startCity;

    @FXML
    private ComboBox destinationCity;

    @FXML
    private TextField transportManner;

    @FXML
    private Button save;

    @FXML
    private TextField remark;

    @FXML
    private ComboBox secondFreight;

    @FXML
    private TextField time;

    @FXML
    private ComboBox type;

    @FXML
    private Button close;

    @FXML
    private ComboBox firstFreight;

    @FXML
    private ComboBox allone;
    @FXML
    void checkSave(ActionEvent event) throws SQLException {

        routeManagmentDAO routeManagementdao=new routeManagmentDAO();
        routeManagementdao.addRouteManagement(startCity.getValue().toString(),destinationCity.getValue().toString(),
                                              type.getValue().toString(),transportManner.getText(),
                                              allone.getValue().toString(),time.getText(),firstFreight.getValue().toString(),
                                              secondFreight.getValue().toString(),remark.getText());
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();

    }

    @FXML
    void checkClose(ActionEvent event) {
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
