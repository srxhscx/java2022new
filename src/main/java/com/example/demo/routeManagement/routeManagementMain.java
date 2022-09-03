package com.example.demo.routeManagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class routeManagementMain extends Application {
    public void start(Stage primaryStage) throws Exception {

        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("routeManagement.fxml"));
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("业务类型");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
