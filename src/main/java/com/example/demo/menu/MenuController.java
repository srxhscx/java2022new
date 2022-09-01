package com.example.demo.menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable{

    @FXML
    private ListView<?> mylistView;

    @FXML
    private ListView<?> permissionListview=new ListView<>();

    @FXML
    private ListView<?> checkedListview=new ListView<>();

    @FXML
    private ListView<?> transportationListview=new ListView<>();

    @FXML
    void mylistView(ActionEvent event)
    {


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ListView list = new ListView<>();

        ObservableList items = FXCollections.observableArrayList (

                "城市管理", "节点管理", "车型管理", "车辆备案","货物名称管理","业务类型管理","GPS车辆部门管理","GPS车辆信息管理");

        //*************************

        ObservableList permissionItems = FXCollections.observableArrayList (

                "账户管理","角色管理","用户权限管理");

        ObservableList checkedItems = FXCollections.observableArrayList (

                "发货信息变更","签收信息变更" , "索赔信息变更");

        ObservableList transportationItems = FXCollections.observableArrayList (

                "运输网络管理","运价管理","用户权限管理");


        mylistView.setPrefSize(165, 551);
        mylistView.getItems().addAll(items);

        permissionListview.setPrefSize(165,551);
        permissionListview.getItems().addAll(permissionItems);

        checkedListview.setPrefSize(165,551);
        checkedListview.getItems().addAll(checkedItems);

        transportationListview.setPrefSize(165,551);
        transportationListview.getItems().addAll(transportationItems);
    }
}
