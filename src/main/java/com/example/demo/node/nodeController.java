package com.example.demo.node;

import com.example.demo.dao.city_nodeDAO;
import com.example.demo.menu.MainMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class nodeController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameCB.getItems().addAll(
                "北京",
                "沈阳",
                "长沙",
                "上海",
                "长春","哈尔滨","呼和浩特","天津","石家庄","济南","西安","兰州","武汉","南京","广州","深圳","南京"
        );
        //数据源为空时显示
        nameCB.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        nameCB.setEditable(true);
        nameCB.setPromptText("选择城市");
        //设置可见行数, 超过显示滚动条
        nameCB.setVisibleRowCount(7);


        nodetypeCB.getItems().addAll(
                "节点",
                "仓库",
                "转运型节点",
                "储存型节点",
                "综合性节点"
        );
        //数据源为空时显示
        nodetypeCB.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        nodetypeCB.setEditable(true);
        nodetypeCB.setPromptText("选择节点类型");
        //设置可见行数, 超过显示滚动条
        nodetypeCB.setVisibleRowCount(7);
    }
    @FXML
    private ComboBox nameCB;

    @FXML
    private Button closeBtn;

    @FXML
    private TextField institutionnameText;

    @FXML
    private TextField nodenameText;

    @FXML
    private TextField remarkText;

    @FXML
    private ComboBox nodetypeCB;

    @FXML
    private Button saveBtn;


    @FXML
    void save(ActionEvent event) {
        String cityname = this.nameCB.getValue().toString();


        String nodename = this.nodenameText.getText();
        String nodetype = this.nodetypeCB.getValue().toString();

        city_nodeDAO city_nodeDAO1 = new city_nodeDAO();

        city_nodeDAO1.update(nodetype,nodename,cityname);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();
//        this.citynameText.clear();
//        this.cityidText.clear();
//        this.cityinstitutionText.clear();
//        this.citydistributionText.clear();
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

