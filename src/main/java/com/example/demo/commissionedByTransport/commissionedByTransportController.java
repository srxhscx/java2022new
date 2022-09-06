package com.example.demo.commissionedByTransport;

import com.example.demo.dao.BuisnessDAO;
import com.example.demo.dao.commissionedByTransportDAO;
import com.example.demo.menu.MainMenu;
import com.example.demo.vo.CommissionedByTransport;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class commissionedByTransportController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        commissionedByTransportType.getItems().addAll(
                "内配发货",
                "采配发货",
                "贵品发货",
                "奢侈品发货",
                "图书退货",
                "非图书退货",
                "耗材",
                "行政物资"
        );
        commissionedByTransportWay.getItems().addAll(
                "海",
                "陆",
                "空"
        );
    }



    @FXML
    private TextField commissionedByTransportNumber;
    @FXML
    private TextField commissionedByTransportCarrier;
    @FXML
    private TextField commissionedByTransportFromPeo;
    @FXML
    private TextField commissionedByTransportToPeo;
    @FXML
    private TextField commissionedByTransportRemark;



    @FXML
    private ChoiceBox commissionedByTransportType;
    @FXML
    private ChoiceBox commissionedByTransportWay;










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
    private  Button saveBtn;

    @FXML
    public void save(ActionEvent event) throws SQLException {
        String CBTNumber = this.commissionedByTransportNumber.getText();
        String CBTCarrier = this.commissionedByTransportCarrier.getText();
        String CBTFromPeo = this.commissionedByTransportFromPeo.getText();
        String CBTToPeo = this.commissionedByTransportToPeo.getText();
        String CBTRemark = this.commissionedByTransportRemark.getText();


        String CBTType = this.commissionedByTransportType.getValue().toString();
        String CBTWay = this.commissionedByTransportWay.getValue().toString();



        commissionedByTransportDAO commissionedByTransportationDAO = new commissionedByTransportDAO();
        commissionedByTransportationDAO.addCommissionedByTransport(CBTNumber,CBTType,CBTCarrier,CBTWay,CBTFromPeo,CBTToPeo,CBTRemark);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();

        this.commissionedByTransportNumber.clear();
        this.commissionedByTransportCarrier.clear();
        this.commissionedByTransportFromPeo.clear();
        this.commissionedByTransportToPeo.clear();
        this.commissionedByTransportRemark.clear();
    }
}
