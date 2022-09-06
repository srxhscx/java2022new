package com.example.demo.carRecord;

import com.example.demo.dao.BuisnessDAO;
import com.example.demo.dao.carRecordDAO;
import com.example.demo.menu.MainMenu;
import com.example.demo.vo.CarRecord;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class carRecordController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CRcarrierCB.getItems().addAll(
                "中国第一汽车集团公司",
                "大众汽车公司",
                "中国长安汽车集团股份有限公司",
                "奇瑞汽车股份有限公司",
                "北京现代汽车有限公司",
                "东风汽车公司"
        );
        //数据源为空时显示
        CRcarrierCB.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        CRcarrierCB.setEditable(true);
        CRcarrierCB.setPromptText("选择承运商");
        //设置可见行数, 超过显示滚动条
        CRcarrierCB.setVisibleRowCount(4);

        CRcartypeCB.getItems().addAll(
                "7米2",
                "9米6",
                "5米8",
                "6米9"
        );
        //数据源为空时显示
        CRcartypeCB.setPlaceholder(new Label("Placeholder"));
        //设置可编辑
        CRcartypeCB.setEditable(true);
        CRcartypeCB.setPromptText("选择车型");
        //设置可见行数, 超过显示滚动条
        CRcartypeCB.setVisibleRowCount(4);
    }

    @FXML
    private ComboBox CRcarrierCB;

    @FXML
    private ComboBox CRcartypeCB;
    @FXML
    private Button CRSaveBtn;

    @FXML
    private TextField carRecordremark;

    @FXML
    private TextField carRecordload;

    @FXML
    private Button CRCloseBtn;

    @FXML
    private TextField carRecordnumber1;


    @FXML
    private TextField carRecordnumber2;

    @FXML
    private TextField carRecordpeople;

    @FXML
    private TextField carRecordvolume;

    @FXML
    private TextField carRecordtel;



    @FXML
    void CRSave(ActionEvent event) throws SQLException {
        String carNumber = this.carRecordnumber1.getText();
        String trailerNumber = this.carRecordnumber2.getText();
        String carType = this.CRcartypeCB.getValue().toString();
        String carState = "正常";
        String carCarrier = this.CRcarrierCB.getValue().toString();
        String carVolume = this.carRecordvolume.getText();
        String carLoad = this.carRecordload.getText();
        String carPeople = this.carRecordpeople.getText();
        String carTelephone = this.carRecordtel.getText();
        String carRemark = this.carRecordremark.getText();
        carRecordDAO carRecordDAO1 = new carRecordDAO();

        carRecordDAO1.addCarRecord(carNumber,trailerNumber,carType,carState,carCarrier, carVolume,carLoad,carPeople, carTelephone, carRemark);
        new Alert(Alert.AlertType.NONE, "保存成功", new ButtonType[]{ButtonType.CLOSE}).show();
        this.carRecordnumber1.clear();
        this.carRecordnumber2.clear();
        this.carRecordvolume.clear();
        this.carRecordload.clear();
        this.carRecordpeople.clear();
        this.carRecordtel.clear();
        this.carRecordremark.clear();

    }

    @FXML
    void CRClose(ActionEvent event) {
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) CRCloseBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new MainMenu().start(primaryStage);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }


}
