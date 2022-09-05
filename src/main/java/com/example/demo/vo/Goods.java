package com.example.demo.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Goods {

    private final StringProperty good_name;
    private final StringProperty good_state;
    private final StringProperty good_remark;

    public Goods() {
        this(null,null,null);
    }

    public StringProperty good_nameProperty() {
        return good_name;
    }

    public StringProperty good_stateProperty() {
        return good_state;
    }

    public StringProperty good_remarkProperty() {
        return good_remark;
    }



    public Goods(String good_name ,String good_state,String good_remark){
        this.good_name = new SimpleStringProperty(good_name);
        this.good_state = new SimpleStringProperty(good_state);
        this.good_remark = new SimpleStringProperty(good_remark);

        //数据类型double this.price = new SimpleDoubleProperty(price);
    }

    public void setGood_name(String good_name) {
        this.good_name.set(good_name);
    }

    public void setGood_state(String good_state) {
        this.good_state.set(good_state);
    }

    public void setGood_remark(String good_remark) {
        this.good_remark.set(good_remark);
    }
}
