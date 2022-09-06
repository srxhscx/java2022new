package com.example.demo.transportationPlanGeneration;

import com.example.demo.dao.TransportationPlanGenerationDAO;
import com.example.demo.menu.MainMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.net.URL;
import java.util.ResourceBundle;

public class transportationPlanGenerationController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transportPlanIdText.setEditable(false);

        transportationPlanGenerationType.getItems().addAll(
                "内配发货",
                "采配发货",
                "贵品发货",
                "奢侈品发货",
                "图书退货",
                "非图书退货",
                "耗材",
                "行政物资"
        );
        transportationPlanGenerationFromCity.getItems().addAll(
                "city1",
                "city2",
                "city3",
                "city4"
        );

        transportationPlanGenerationToCity.getItems().addAll(
                "city1",
                "city2",
                "city3",
                "city4"
        );

        transportationPlanGenerationFromBase.getItems().addAll(
                "warehouse1",
                "warehouse2",
                "warehouse3",
                "warehouse4"
        );

        transportationPlanGenerationToBase.getItems().addAll(
                "warehouse1",
                "warehouse2",
                "warehouse3",
                "warehouse4"
        );
    }
    @FXML
    private TextField transportPlanIdText;

//    transportationPlanGenerationState
//    transportationPlanGenerationType
//        transportationPlanGenerationFromCity
//    transportationPlanGenerationToCity
//        transportationPlanGenerationFromBase
//    transportationPlanGenerationToBase
//        transportationPlanGenerationNumber
//    transportationPlanGenerationVolume
//    transportationPlanGenerationWeight
//            transportationPlanGenerationRemark

    @FXML
    private ChoiceBox transportationPlanGenerationFromCity;

    @FXML
    private ChoiceBox transportationPlanGenerationToCity;

    @FXML
    private ChoiceBox transportationPlanGenerationFromBase;

    @FXML
    private ChoiceBox transportationPlanGenerationToBase;

    @FXML
    private ChoiceBox transportationPlanGenerationType;

    @FXML
    private TextField transportationPlanGenerationState;

    @FXML
    private TextField transportationPlanGenerationNumber;

    @FXML
    private TextField transportationPlanGenerationVolume;

    @FXML
    private TextField transportationPlanGenerationWeight;

    @FXML
    private TextField transportationPlanGenerationRemark;














    @FXML
    private Button saveBtn;

    @FXML
    void save(ActionEvent event) throws SQLException {
//        String businesstype = this.businesstypeText.getText();
//        String businessremark = this.businessremarkText.getText();
//        String businessstate = "正常";
//        String distribution = distributionText.getValue().toString();

//          String TPGState = "正常";

          String TPGType = transportationPlanGenerationType.getValue().toString();
          String TPGFromCity = transportationPlanGenerationFromCity.getValue().toString();
          String TPGToCity = transportationPlanGenerationToCity.getValue().toString();
          String TPGFromBase = transportationPlanGenerationFromBase.getValue().toString();
          String TPGToBase = transportationPlanGenerationToBase.getValue().toString();
          String TPGState = transportationPlanGenerationState.getText();
          String TPGNumber = transportationPlanGenerationNumber.getText();
          String TPGVolume = transportationPlanGenerationVolume.getText();
          String TPGWeight = transportationPlanGenerationWeight.getText();
          String TPGRemark = transportationPlanGenerationRemark.getText();


        TransportationPlanGenerationDAO transportationPlanGenerationDAO = new TransportationPlanGenerationDAO();
        transportationPlanGenerationDAO.addTransportationPlanGeneration(TPGState,TPGType,TPGFromCity,TPGToCity,TPGFromBase,TPGToBase,TPGNumber,TPGVolume,TPGWeight,TPGRemark);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();

        this.transportationPlanGenerationNumber.clear();
        this.transportationPlanGenerationVolume.clear();
        this.transportationPlanGenerationWeight.clear();

    }

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

//    @FXML
//    public void flash(ActionEvent event) {
//        Date t = new Date();
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
//        String number = originatingCityChoiceBox.getValue() + df.format(t);
//        transportPlanIdText.setText(number);
//    }
}