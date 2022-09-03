package com.example.demo.signInfomationChange;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class signInfomationChangeMain extends Application {
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("signInfomationChange.fxml"));
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("菜单");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
