package com.example.demo.newSignInDoc;

import com.example.demo.dao.newSignInDocDAO;
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

public class newSignInDocController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        goodgetfcity.getItems().addAll(
                "天津",
                "上海",
                "北京",
                "山西",
                "黑龙江",
                "江苏",
                "陕西",
                "广东",
                "广西",
                "山东",
                "湖南",
                "湖北"

        );
        //数据源为空时显示
        goodgetfcity.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        goodgetfcity.setEditable(true);
        goodgetfcity.setPromptText("选择发货城市");
        //设置可见行数, 超过显示滚动条
        goodgetfcity.setVisibleRowCount(12);

        goodgetfhouse.getItems().addAll(
                "天津",
                "上海",
                "北京",
                "山西",
                "黑龙江",
                "江苏",
                "陕西",
                "广东",
                "广西",
                "山东",
                "湖南",
                "湖北"
        );
        //数据源为空时显示
        goodgetfhouse.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        goodgetfhouse.setEditable(true);
        goodgetfhouse.setPromptText("选择发货地址");
        //设置可见行数, 超过显示滚动条
        goodgetfhouse.setVisibleRowCount(12);


        goodgetrunway.getItems().addAll(
                "海",
                "陆",
                "空"
        );
        //数据源为空时显示
        goodgetrunway.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        goodgetrunway.setEditable(true);
        goodgetrunway.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        goodgetrunway.setVisibleRowCount(3);




        goodgetlcity.getItems().addAll(
                "天津",
                "上海",
                "北京",
                "山西",
                "黑龙江",
                "江苏",
                "陕西",
                "广东",
                "广西",
                "山东",
                "湖南",
                "湖北"
        );
        //数据源为空时显示
        goodgetlcity.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        goodgetlcity.setEditable(true);
        goodgetlcity.setPromptText("选择接受城市");
        //设置可见行数, 超过显示滚动条
        goodgetlcity.setVisibleRowCount(12);


        goodgetlhouse.getItems().addAll(
                "天津",
                "上海",
                "北京",
                "山西",
                "黑龙江",
                "江苏",
                "陕西",
                "广东",
                "广西",
                "山东",
                "湖南",
                "湖北"
        );
        //数据源为空时显示
        goodgetlhouse.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        goodgetlhouse.setEditable(true);
        goodgetlhouse.setPromptText("选择接受地址");
        //设置可见行数, 超过显示滚动条
        goodgetlhouse.setVisibleRowCount(12);

        goodgetpeople.getItems().addAll(
                "京东",
                "顺丰",
                "申通",
                "韵达"
        );
        //数据源为空时显示
        goodgetpeople.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        goodgetpeople.setEditable(true);
        goodgetpeople.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        goodgetpeople.setVisibleRowCount(4);


        goodgeType.getItems().addAll(
                "内配发货",
                "采配发货",
                "贵品发货",
                "奢侈品发货",
                "图书退货",
                "非图书退货",
                "耗材",
                "行政物资"
        );
        //数据源为空时显示
        goodgeType.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        goodgeType.setEditable(true);
        goodgeType.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        goodgeType.setVisibleRowCount(8);
    }




    @FXML
    private TextField goodgetnub;
    @FXML
    private TextField goodgetgoodarea;
    @FXML
    private TextField goodgetgoodmuch;
    @FXML
    private TextField goodgetgetarea;
    @FXML
    private TextField goodgetwrite;

    @FXML
    private Button goodgetGet;
    @FXML
    private Button closeBtn;

    @FXML
    private ComboBox goodgetfcity;
    @FXML
    private ComboBox goodgetfhouse;
    @FXML
    private ComboBox goodgetrunway;
    @FXML
    private ComboBox goodgetlcity;
    @FXML
    private ComboBox goodgetlhouse;
    @FXML
    private ComboBox goodgetpeople;
    @FXML
    private ComboBox goodgeType;




    @FXML
    void SAVE(ActionEvent event) throws SQLException {
        String getNub = goodgetnub.getText();
        String getGoodarea = goodgetgoodarea.getText();
        String getGoodmuch = goodgetgoodmuch.getText();
        String getGetarea = goodgetgetarea.getText();
        String getWrite = goodgetwrite.getText();
        String getFcity = goodgetfcity.getValue().toString();
        String getFhouse = goodgetfhouse.getValue().toString();
        String getRunway = goodgetrunway.getValue().toString();
        String getLcity = goodgetlcity.getValue().toString();
        String getLhouse = goodgetlhouse.getValue().toString();
        String getPeople = goodgetpeople.getValue().toString();
        String getType = goodgeType.getValue().toString();
        String getAction = "查看";

        newSignInDocDAO NewSignInDocDAO = new newSignInDocDAO();

        NewSignInDocDAO.addNewSignInDoc(getNub,getFcity,getFhouse,getLcity,getLhouse,getGoodarea,getGetarea,getPeople,getRunway,getType,getGoodmuch,getWrite,getAction);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();
        this.goodgetnub.clear();
        this.goodgetgoodarea.clear();
        this.goodgetgoodmuch.clear();
        this.goodgetgetarea.clear();
        this.goodgetwrite.clear();


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
