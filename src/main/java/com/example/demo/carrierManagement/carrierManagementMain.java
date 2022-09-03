package com.example.demo.carrierManagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class carrierManagementMain extends Application {
    public void start(Stage primaryStage) throws Exception {

        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("carrierManagement.fxml"));
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("业务类型");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}
