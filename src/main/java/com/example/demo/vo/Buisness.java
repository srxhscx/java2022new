package com.example.demo.vo;

import javafx.beans.property.*;

public class Buisness {

    private final IntegerProperty business_id;
    private final StringProperty business_type;
    private final StringProperty business_state;
    private final StringProperty business_distribution;
    private final StringProperty business_remark;

    public StringProperty business_typeProperty() {
        return business_type;
    }

    public StringProperty business_stateProperty() {
        return business_state;
    }

    public StringProperty business_distributionProperty() {
        return business_distribution;
    }

    public StringProperty business_remarkProperty() {
        return business_remark;
    }

    public Buisness(){
        this(0,null,null,null,null);
    }

    public Buisness(int business_id,String business_state ,String business_type,String business_distribution, String business_remark){
        this.business_id = new SimpleIntegerProperty(business_id);
        this.business_state = new SimpleStringProperty(business_state);
        this.business_type = new SimpleStringProperty(business_type);
        this.business_distribution = new SimpleStringProperty(business_distribution);
        this.business_remark = new SimpleStringProperty(business_remark);
       //数据类型double this.price = new SimpleDoubleProperty(price);
    }

    public int getBusiness_id() {
        return business_id.get();
    }

    public void setBusiness_type(String business_type) {
        this.business_type.set(business_type);
    }


    public IntegerProperty business_idProperty() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id.set(business_id);
    }

    public void setBusiness_state(String business_state) {
        this.business_state.set(business_state);
    }

    public void setBusiness_distribution(String business_distribution) {
        this.business_distribution.set(business_distribution);
    }

    public void setBusiness_remark(String business_remark) {
        this.business_remark.set(business_remark);
    }
}
