package com.example.demo.transportationPlanGeneration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
    public class transportationPlanGenerationMain extends Application {
        public void start(Stage primaryStage) throws Exception {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("transportationPlanGeneration.fxml"));
            Scene scene = new Scene(anchorPane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("菜单");
            primaryStage.show();
        }
        public static void main(String[] args) {
            launch(args);
        }
    }

