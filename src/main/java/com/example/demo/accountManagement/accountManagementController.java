package com.example.demo.accountManagement;

import com.example.demo.dao.accountManagementDAO;
import com.example.demo.menu.MainMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class accountManagementController implements Initializable {

    @FXML
    private ComboBox institutionText;

    @FXML
    private TextField contactText;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField mailText;

    @FXML
    private Button save;

    @FXML
    private TextField accountText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField passwordConfirmText;

    @FXML
    private Button close;

    @FXML
    private ComboBox cityText;

    @FXML
    private ComboBox nodeText;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cityText.getItems().addAll(
                "北京",
                "沈阳",
                "长沙",
                "上海",
                "长春","哈尔滨","呼和浩特","天津","石家庄","济南","西安","兰州","武汉","南京","广州","深圳","南京"
        );
        nodeText.getItems().addAll(
                "代理结点",
                "转运中心",
                "总代理结点"
        );
        institutionText.getItems().addAll(
                "中国第一汽车集团公司",
                "大众汽车公司",
                "中国长安汽车集团股份有限公司",
                "奇瑞汽车股份有限公司",
                "北京现代汽车有限公司",
                "东风汽车公司"
        );
        cityText.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        cityText.setEditable(true);
        cityText.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        cityText.setVisibleRowCount(4);

        nodeText.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        nodeText.setEditable(true);
        nodeText.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        nodeText.setVisibleRowCount(4);

        institutionText.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        institutionText.setEditable(true);
        institutionText.setPromptText("选择配送模式");
        //设置可见行数, 超过显示滚动条
        institutionText.setVisibleRowCount(4);


    }
    @FXML
    void checkSave(ActionEvent event) throws SQLException{
        String account=this.accountText.getText();
        String name=this.nameText.getText();
        String password=this.passwordText.getText();
        String institution=this.institutionText.getValue().toString();
        String city=this.cityText.getValue().toString();
        String node=this.nodeText.getValue().toString();
        String contact=this.contactText.getText();
        String mail=this.mailText.getText();


        accountManagementDAO accountManagementdao=new accountManagementDAO();
        accountManagementdao.addAccountManagement(account,name,password,institution,city,node,contact,mail);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();

    }

    @FXML
    void checkedClose(ActionEvent event) {
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


