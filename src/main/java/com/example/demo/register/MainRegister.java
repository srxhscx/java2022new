package com.example.demo.register;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainRegister extends Application {

    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("mainregister.fxml"));
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("账号注册");

        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

}
