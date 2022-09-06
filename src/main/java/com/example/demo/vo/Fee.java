package com.example.demo.vo;

import javafx.beans.property.*;

public class Fee {

    private final StringProperty fee_booknode;
    private final StringProperty fee_transnode;
    private final StringProperty fee_subprimemoney;
    private final StringProperty fee_latemoney;
    private final StringProperty fee_othermoney;
    private final StringProperty fee_whyothermoney;

    public StringProperty fee_booknode() {
        return fee_booknode;
    }

    public StringProperty fee_transnode() {
        return fee_transnode;
    }

    public StringProperty fee_subprimemoney() {
        return fee_subprimemoney;
    }

    public StringProperty fee_latemoney() {
        return fee_latemoney;
    }

    public StringProperty fee_othermoney() {
        return fee_othermoney;
    }

    public StringProperty fee_whyothermoney() {
        return fee_whyothermoney;
    }

    public Fee(){
        this(null,null,null,null,null,null);
    }

    public Fee(String fee_booknode, String fee_transnode , String fee_subprimemoney, String fee_latemoney, String fee_othermoney, String fee_whyothermoney){
        this.fee_booknode = new SimpleStringProperty(fee_booknode);
        this.fee_transnode = new SimpleStringProperty(fee_transnode);
        this.fee_subprimemoney = new SimpleStringProperty(fee_subprimemoney);
        this.fee_latemoney = new SimpleStringProperty(fee_latemoney);
        this.fee_othermoney = new SimpleStringProperty(fee_othermoney);
        this.fee_whyothermoney = new SimpleStringProperty(fee_whyothermoney);
        //数据类型double this.price = new SimpleDoubleProperty(price);
    }

    public String getFee_booknode() {
        return fee_booknode.get();
    }

    public StringProperty fee_booknodeProperty() {
        return fee_booknode;
    }

    public void setFee_booknode(String fee_booknode) {
        this.fee_booknode.set(fee_booknode);
    }

    public String getFee_transnode() {
        return fee_transnode.get();
    }

    public StringProperty fee_transnodeProperty() {
        return fee_transnode;
    }

    public void setFee_transnode(String fee_transnode) {
        this.fee_transnode.set(fee_transnode);
    }

    public String getFee_subprimemoney() {
        return fee_subprimemoney.get();
    }

    public StringProperty fee_subprimemoneyProperty() {
        return fee_subprimemoney;
    }

    public void setFee_subprimemoney(String fee_subprimemoney) {
        this.fee_subprimemoney.set(fee_subprimemoney);
    }

    public String getFee_latemoney() {
        return fee_latemoney.get();
    }

    public StringProperty fee_latemoneyProperty() {
        return fee_latemoney;
    }

    public void setFee_latemoney(String fee_latemoney) {
        this.fee_latemoney.set(fee_latemoney);
    }

    public String getFee_othermoney() {
        return fee_othermoney.get();
    }

    public StringProperty fee_othermoneyProperty() {
        return fee_othermoney;
    }

    public void setFee_othermoney(String fee_othermoney) {
        this.fee_othermoney.set(fee_othermoney);
    }

    public String getFee_whyothermoney() {
        return fee_whyothermoney.get();
    }

    public StringProperty fee_whyothermoneyProperty() {
        return fee_whyothermoney;
    }

    public void setFee_whyothermoney(String fee_whyothermoney) {
        this.fee_whyothermoney.set(fee_whyothermoney);
    }
}
