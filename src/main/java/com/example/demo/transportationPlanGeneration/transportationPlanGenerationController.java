package com.example.demo.transportationPlanGeneration;

import com.example.demo.menu.MainMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.net.URL;
import java.util.ResourceBundle;

public class transportationPlanGenerationController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transportPlanNumberTextField.setEditable(false);

        businessTypeChoiceBox.getItems().addAll(
                "内配发货",
                "采配发货",
                "贵品发货",
                "奢侈品发货",
                "图书退货",
                "非图书退货",
                "耗材",
                "行政物资"
        );
        originatingCityChoiceBox.getItems().addAll(
                "city1",
                "city2",
                "city3",
                "city4"
        );

        destinationCityChoiceBox.getItems().addAll(
                "city1",
                "city2",
                "city3",
                "city4"
        );

        originatingWarehouseChoiceBox.getItems().addAll(
                "warehouse1",
                "warehouse2",
                "warehouse3",
                "warehouse4"
        );

        destinationWarehouseChoiceBox.getItems().addAll(
                "warehouse1",
                "warehouse2",
                "warehouse3",
                "warehouse4"
        );
    }
    @FXML
    private TextField transportPlanNumberTextField;

    @FXML
    private ChoiceBox businessTypeChoiceBox;

    @FXML
    private ChoiceBox originatingCityChoiceBox;

    @FXML
    private ChoiceBox destinationCityChoiceBox;

    @FXML
    private ChoiceBox originatingWarehouseChoiceBox;

    @FXML
    private ChoiceBox destinationWarehouseChoiceBox;

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

    @FXML
    public void flash(ActionEvent event) {
        Date t = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
        String number = originatingCityChoiceBox.getValue() + df.format(t);
        transportPlanNumberTextField.setText(number);
    }
}