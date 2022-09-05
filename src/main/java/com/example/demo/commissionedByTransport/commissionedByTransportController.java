package com.example.demo.commissionedByTransport;

import com.example.demo.menu.MainMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class commissionedByTransportController {
    @FXML
    private Button closeBtn;

    @FXML
    public void close(ActionEvent event) {
        Platform.runLater(()->{
            Stage primaryStage = (Stage) closeBtn.getScene().getWindow();
            primaryStage.hide();
            try {
                new MainMenu().start(primaryStage);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
