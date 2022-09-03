package com.example.demo.register;


import com.example.demo.dao.RoleDAO;
import com.example.demo.dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
                System.out.println(role_id);


                UserDAO userDAO = new UserDAO();

                if(userDAO.login(tel) != null){
                        tipaccount.setText("用户已存在");
                }
                else{
                        if (password.equals(password1)){

                                userDAO.addRole(tel,password,userName,role_id);

                        }
                        else{
                                passLabel.setText("两次密码不一致");
                        }
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


