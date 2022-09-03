package com.example.demo.homepage;

import com.example.demo.dao.UserDAO;
import com.example.demo.menu.MainMenu;
import com.example.demo.register.MainRegister;

import com.example.demo.vo.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.demo.homepage.VerificationCode.*;


public class Controller {

    @FXML
    private Label idLabel;

    @FXML
    private TextField passText;

    @FXML
    private ImageView imageView;

    @FXML
    private Label passLabel;

    @FXML
    private TextField idText;

    @FXML
    private Label vercode;

    @FXML
    private Label tipLabel;
    @FXML
    private Button checkBtn;
    @FXML
    private Button regiterBtn;

    @FXML
    private TextField VerText;

    @FXML
    private Label tippassword;
    @FXML
    private ImageView verCodeImageView;

    //访问数据库的DAO对象
    private UserDAO userDAO = new UserDAO();
    @FXML
    void check(ActionEvent event) {
        //获取用户输入的账户信息
        String account = this.idText.getText();
        //验证是否是已注册用户
        User user = userDAO.login(account);
        if (user == null) {

            tipLabel.setText("用户不存在");
        }
        else {
            //密码是否正确
            String password = this.passText.getText();
            String pass = user.getUser_password();

            if (!password.equals(pass)) {

                tippassword.setText("密码错误");
            }
            else {
                //验证是否是已注册用户
                try{
                    if(!this.VerText.getText().equals(str1))
                    {
                        //System.out.println(str1);
                        new Alert(Alert.AlertType.NONE, "验证码错误", new ButtonType[]{ButtonType.CLOSE}).show();
                        //若验证码输入错误，则刷新验证码
                        try {
                            str1 = VerificationCode.getcode();

                            Image image = new Image("file:code.jpg");
                            verCodeImageView.setImage(image);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        Platform.runLater(()->{
                            //获取按钮所在的窗口
                            //BtSign可以为当前窗口任意一个控件
                            Stage primaryStage = (Stage) checkBtn.getScene().getWindow();
                            //当前窗口隐藏
                            primaryStage.hide();
                            //加载注册窗口
                            try {
                                new MainMenu().start(primaryStage);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                        //new Alert(Alert.AlertType.NONE, "登陆成功", new ButtonType[]{ButtonType.CLOSE}).show();
                    }


                }catch (Exception e){
                    System.out.println("Error");
                }
            }

        }


    }
    @FXML
    void regiter(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) regiterBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new MainRegister().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    String str1 ;//保存验证码
    @FXML
    void OnCodeChange(MouseEvent event) {

                try {
                     str1 = VerificationCode.getcode();

                    Image image = new Image("file:code.jpg");
                    verCodeImageView.setImage(image);

                } catch (Exception e) {
                    e.printStackTrace();
                }


        }

    public void getcode(){
        try {
            str1 = VerificationCode.getcode();

            Image image = new Image("file:code.jpg");
            verCodeImageView.setImage(image);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}








