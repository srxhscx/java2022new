package com.example.demo.register;


import com.example.demo.dao.RoleDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.menu.MainMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class RegiterController implements Initializable {

        @FXML
        private Button regiterBtn;

        @FXML
        private TextField passText;

        @FXML
        private TextField pass1Text;

        @FXML
        private TextField idText;

        @FXML
        private TextField nameText;

        @FXML
        private ComboBox permission;


        @FXML
        private Label tipaccount;
        @FXML
        private Label passLabel;
        @FXML
        void regiter(ActionEvent event) throws SQLException {
                String tel = this.idText.getText();
                String password = this.passText.getText();
                String password1 = this.pass1Text.getText();
                String userName = this.nameText.getText();

                String roleId = permission.getValue().toString();
                int role_id = roleId.charAt(0) - 48;
                //System.out.println(role_id);


                UserDAO userDAO = new UserDAO();

                if(userDAO.login(tel) != null){
                        tipaccount.setText("用户已存在");
                }
                else{
                        if (password.equals(password1)){

                                userDAO.addRole(tel,password,userName,role_id);
                                //new Alert(Alert.AlertType.NONE, "注册成功", new ButtonType[]{ButtonType.CLOSE}).show();
                        }
                        else{
                                passLabel.setText("两次密码不一致");
                        }
                        Platform.runLater(()->{
                                //获取按钮所在的窗口
                                //BtSign可以为当前窗口任意一个控件
                                Stage primaryStage = (Stage) regiterBtn.getScene().getWindow();
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

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                permission.getItems().addAll(
                        "1(管理员，修改)",
                        "2(店长，控制)",
                        "3(客户，只读)"
                );
                //数据源为空时显示
                permission.setPlaceholder(new Label("Placeholder"));
                //设置可编辑
                permission.setEditable(true);
                permission.setPromptText("请选择您的角色");
                //设置可见行数, 超过显示滚动条
                permission.setVisibleRowCount(3);


        }
}


