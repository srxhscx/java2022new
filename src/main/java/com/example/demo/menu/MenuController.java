package com.example.demo.menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable{

    @FXML
    private ListView<?> mylistView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ListView list = new ListView<>();

        ObservableList items = FXCollections.observableArrayList (

                "城市管理", "节点管理", "车型管理", "车辆备案","货物名称管理","业务类型管理","GPS车辆部门管理","GPS车辆信息管理");

        mylistView.setPrefSize(165, 551);
        mylistView.getItems().addAll(items);


}
}
