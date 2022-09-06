package com.example.demo.vo;

import javafx.beans.property.*;

public class CommissionedByTransport {
    private final StringProperty commissionedByTransport_number;
    private final StringProperty commissionedByTransport_type;
    private final StringProperty commissionedByTransport_carrier;
    private final StringProperty commissionedByTransport_way;
    private final StringProperty commissionedByTransport_from_peo;
    private final StringProperty commissionedByTransport_to_peo;
    private final StringProperty commissionedByTransport_remark;

    public CommissionedByTransport(){
        this(null,null,null,null,null,null,null);
    }

    public CommissionedByTransport(String commissionedByTransport_number ,String commissionedByTransport_type ,String commissionedByTransport_carrier ,String commissionedByTransport_way ,String commissionedByTransport_from_peo ,String commissionedByTransport_to_peo ,String commissionedByTransport_remark){
        this.commissionedByTransport_number = new SimpleStringProperty(commissionedByTransport_number);
        this.commissionedByTransport_type = new SimpleStringProperty(commissionedByTransport_type);
        this.commissionedByTransport_carrier = new SimpleStringProperty(commissionedByTransport_carrier);
        this.commissionedByTransport_way = new SimpleStringProperty(commissionedByTransport_way);
        this.commissionedByTransport_from_peo = new SimpleStringProperty(commissionedByTransport_from_peo);
        this.commissionedByTransport_to_peo = new SimpleStringProperty(commissionedByTransport_to_peo);
        this.commissionedByTransport_remark = new SimpleStringProperty(commissionedByTransport_remark);

    }

    public String getCommissionedByTransport_number() {
        return commissionedByTransport_number.get();
    }

    public StringProperty commissionedByTransport_numberProperty() {
        return commissionedByTransport_number;
    }

    public void setCommissionedByTransport_number(String commissionedByTransport_number) {
        this.commissionedByTransport_number.set(commissionedByTransport_number);
    }

    public String getCommissionedByTransport_type() {
        return commissionedByTransport_type.get();
    }

    public StringProperty commissionedByTransport_typeProperty() {
        return commissionedByTransport_type;
    }

    public void setCommissionedByTransport_type(String commissionedByTransport_type) {
        this.commissionedByTransport_type.set(commissionedByTransport_type);
    }

    public String getCommissionedByTransport_carrier() {
        return commissionedByTransport_carrier.get();
    }

    public StringProperty commissionedByTransport_carrierProperty() {
        return commissionedByTransport_carrier;
    }

    public void setCommissionedByTransport_carrier(String commissionedByTransport_carrier) {
        this.commissionedByTransport_carrier.set(commissionedByTransport_carrier);
    }

    public String getCommissionedByTransport_way() {
        return commissionedByTransport_way.get();
    }

    public StringProperty commissionedByTransport_wayProperty() {
        return commissionedByTransport_way;
    }

    public void setCommissionedByTransport_way(String commissionedByTransport_way) {
        this.commissionedByTransport_way.set(commissionedByTransport_way);
    }

    public String getCommissionedByTransport_from_peo() {
        return commissionedByTransport_from_peo.get();
    }

    public StringProperty commissionedByTransport_from_peoProperty() {
        return commissionedByTransport_from_peo;
    }

    public void setCommissionedByTransport_from_peo(String commissionedByTransport_from_peo) {
        this.commissionedByTransport_from_peo.set(commissionedByTransport_from_peo);
    }

    public String getCommissionedByTransport_to_peo() {
        return commissionedByTransport_to_peo.get();
    }

    public StringProperty commissionedByTransport_to_peoProperty() {
        return commissionedByTransport_to_peo;
    }

    public void setCommissionedByTransport_to_peo(String commissionedByTransport_to_peo) {
        this.commissionedByTransport_to_peo.set(commissionedByTransport_to_peo);
    }

    public String getCommissionedByTransport_remark() {
        return commissionedByTransport_remark.get();
    }

    public StringProperty commissionedByTransport_remarkProperty() {
        return commissionedByTransport_remark;
    }

    public void setCommissionedByTransport_remark(String commissionedByTransport_remark) {
        this.commissionedByTransport_remark.set(commissionedByTransport_remark);
    }
}
