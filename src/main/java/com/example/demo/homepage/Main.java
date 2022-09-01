package com.example.demo.homepage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
      //  AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("main.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();

        Scene scene = new Scene(anchorPane);

        try {
            Controller controller = fxmlLoader.getController();
            controller.getcode();

        }catch (Exception e1){

        }
        stage.setScene(scene);
        stage.setTitle("京东仓储TMS系统");
        stage.show();

    }

}
