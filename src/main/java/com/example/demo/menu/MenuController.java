package com.example.demo.menu;
import com.example.demo.accountManagement.accountManagementMain;
import com.example.demo.business.businessmain;
import com.example.demo.carrierManagement.carrierManagementMain;
import com.example.demo.dao.BuisnessDAO;
import com.example.demo.dao.accountManagementDAO;
import com.example.demo.vo.Buisness;
import com.example.demo.vo.accountManagement;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class MenuController implements Initializable{

    /**
     * 业务类型管理
     */
    @FXML
    private Button businesscheckBtn;
    @FXML
    private TextField businessText;
    @FXML
    private TableColumn<Buisness, String> businessDistribution;
    @FXML
    private TableColumn<Buisness, String> businessOperate;
    @FXML
    private TableColumn<Buisness, String> businessType;
    @FXML
    private TableColumn<Buisness, String> businessRemark;
    @FXML
    private TableColumn<Buisness,String> businessState;
    @FXML
    private TableColumn<accountManagement,String> amstate;
    @FXML
    private TableColumn<accountManagement,String> amaccount;
    @FXML
    private TableColumn<accountManagement,String> amname;
    @FXML
    private TableColumn<accountManagement,String> aminstitution;
    @FXML
    private TableColumn<accountManagement,String> amcity;
    @FXML
    private TableColumn<accountManagement,String> amnode;
    @FXML
    private TableColumn<accountManagement,String> amtel;
    @FXML
    private TableColumn<accountManagement,String> ammail;
    @FXML
    private TableColumn<accountManagement,String> amremark;
    @FXML
    private TableColumn<accountManagement,String> amoperate;



    @FXML
    void businesscheck(ActionEvent event) {
            tableView.getItems().clear();
            String typeText = this.businessText.getText();
        //添加数据, 这些数据可以从数据库中查询出
        BuisnessDAO buisnessDAO = new BuisnessDAO();

        Iterator<Buisness> iter = buisnessDAO.getBusinessByBusinessType(typeText).iterator();
        while(iter.hasNext()) {
            businessdata.add(iter.next());
        }

        //设置每列的数据
        businessState.setCellValueFactory(cellData-> cellData.getValue().business_stateProperty());
        businessType.setCellValueFactory( cellData-> cellData.getValue().business_typeProperty());
        businessDistribution.setCellValueFactory( cellData-> cellData.getValue().business_distributionProperty());
        businessRemark.setCellValueFactory( cellData-> cellData.getValue().business_remarkProperty());

        //设置表格数据
        tableView.setItems(businessdata);


    }
    @FXML
    //创建TableView
    private TableView<Buisness> tableView = new TableView<>();
    //创建数据集合
    private ObservableList<Buisness> businessdata = FXCollections.observableArrayList();

    @FXML
    //创建TableView
    private TableView<accountManagement> amtableView = new TableView<>();
    //创建数据集合
    private ObservableList<accountManagement> accountManagementdata = FXCollections.observableArrayList();

    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
        //动态添加HBox容器，在HBox容器中动态添加label和textfield
        Label label = new Label("名称:");
        TextField textField1 = new TextField();
        hBox.getChildren().add(label);
        hBox.getChildren().add(textField1);
        rootPane.setCenter(hBox);
        */

        //添加数据, 这些数据可以从数据库中查询出
        BuisnessDAO buisnessDAO = new BuisnessDAO();
        Iterator<Buisness> iter = buisnessDAO.getBusiness().iterator();
        while(iter.hasNext()) {
            businessdata.add(iter.next());
        }

        //设置每列的数据
        businessState.setCellValueFactory(cellData-> cellData.getValue().business_stateProperty());
        businessType.setCellValueFactory( cellData-> cellData.getValue().business_typeProperty());
        businessDistribution.setCellValueFactory( cellData-> cellData.getValue().business_distributionProperty());
        businessRemark.setCellValueFactory( cellData-> cellData.getValue().business_remarkProperty());
        //businessOperate.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Buisness, String>, ObservableValue<String>>) new Button());
        //businessOperate.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Buisness, String>, ObservableValue<String>>) new Button());


        //设置表格数据
        tableView.setItems(businessdata);

        //将表格添加到root
        //.setCenter(tableView);
        businessOperate.setCellFactory((col)->{

                    //UserLoad换成你自己的实体名称
                    TableCell<Buisness, String> cell = new TableCell<Buisness, String>(){
                        @Override
                        protected void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            Button button1 = new Button("编辑");
                            button1.setStyle("-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                            button1.setOnMouseClicked((col) -> {

                                //获取list列表中的位置，进而获取列表对应的信息数据
                               // Buisness buisness = list.get(getIndex());
                                //按钮事件自己添加

                            });

                            if (empty) {
                                //如果此列为空默认不添加元素
                                setText(null);
                                setGraphic(null);
                            } else {
                                this.setGraphic(button1);
                            }
                        }
                    };
                    return cell;
                }
        );


        //accountManagement
        accountManagementDAO accountManagementdao = new accountManagementDAO();
        Iterator<accountManagement> iteram= accountManagementdao.getAccountManagement().iterator();

        while(iteram.hasNext()) {
           accountManagementdata.add(iteram.next());
        }

        //设置每列的数据
        amaccount.setCellValueFactory(cellData-> cellData.getValue().am_accountProperty());
        amname.setCellValueFactory( cellData-> cellData.getValue().am_nameProperty());
        aminstitution.setCellValueFactory( cellData-> cellData.getValue().am_institutionProperty());
        amcity.setCellValueFactory( cellData-> cellData.getValue().am_cityProperty());
        amnode.setCellValueFactory( cellData-> cellData.getValue().am_nodeProperty());
        amtel.setCellValueFactory( cellData-> cellData.getValue().am_contactProperty());
        ammail.setCellValueFactory( cellData-> cellData.getValue().am_mailProperty());


        //设置表格数据
        amtableView.setItems(accountManagementdata);

    }
    @FXML
    private Button buildBusinessBtn;
    @FXML
    void buildBusiness(ActionEvent event) {
            //businessmain business = new businessmain();
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) buildBusinessBtn.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new businessmain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    @FXML
    private Button amnewaccount;
    @FXML
    void newAccountChecked(ActionEvent event){
        Platform.runLater(()->{
            //获取按钮所在的窗口
            //BtSign可以为当前窗口任意一个控件
            Stage primaryStage = (Stage) amnewaccount.getScene().getWindow();
            //当前窗口隐藏
            primaryStage.hide();
            //加载注册窗口
            try {
                new accountManagementMain().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private Button newCarrier;
    @FXML
    void newCarrierChecked(ActionEvent event) {
        Stage primaryStage = (Stage) newCarrier.getScene().getWindow();
        //当前窗口隐藏
        primaryStage.hide();
        //加载注册窗口
        try {
            new carrierManagementMain().start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

















/**
 * 城市管理
 */


}
