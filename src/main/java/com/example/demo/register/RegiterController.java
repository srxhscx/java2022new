package com.example.demo.register;


import com.example.demo.dao.RoleDAO;
import com.example.demo.dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.print.DocFlavor;
import java.sql.SQLException;


public class RegiterController {

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
       // private ComboBox permission = new ComboBox();
        private ComboBox<String> permission = new ComboBox<>();






        @FXML
        void regiter(ActionEvent event) throws SQLException {
                String tel = this.idText.getText();
                String password = this.passText.getText();
                String userName = this.nameText.getText();

                permission.getItems().addAll(
                        "1(管理员，修改)",
                        "2(店长，控制)",
                        "3(客户，只读)"
                );
//数据源为空时显示
                permission.setPlaceholder(new Label("Placeholder"));
//设置可编辑
                permission.setEditable(true);
                permission.setPromptText("PromptText");
//设置可见行数, 超过显示滚动条
                permission.setVisibleRowCount(3);



                permission.setValue("Normal");

                //MainRegister mainRegister = new MainRegister();
                //String roleId = mainRegister.comboBox.getValue().toString();
                //int role_id = roleId.charAt(0);

                UserDAO userDAO = new UserDAO();
//                userDAO.addRole(tel,password,userName,role_id);

        }

}


