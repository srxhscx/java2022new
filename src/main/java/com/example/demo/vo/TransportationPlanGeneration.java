package com.example.demo.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class TransportationPlanGeneration {
    private final StringProperty transportationPlanGeneration_state;
    private final StringProperty transportationPlanGeneration_type;
    private final StringProperty transportationPlanGeneration_from_city;
    private final StringProperty transportationPlanGeneration_to_city;
    private final StringProperty transportationPlanGeneration_from_base;
    private final StringProperty transportationPlanGeneration_to_base;
    private final StringProperty transportationPlanGeneration_number;
    private final StringProperty transportationPlanGeneration_volume;
    private final StringProperty transportationPlanGeneration_weight;
    private final StringProperty transportationPlanGeneration_remark;

    public TransportationPlanGeneration() {
        this(null,null,null,null,null,null,null,null,null,null);
    }

    public TransportationPlanGeneration(String transportationPlanGeneration_state, String transportationPlanGeneration_type, String transportationPlanGeneration_from_city, String transportationPlanGeneration_to_city, String transportationPlanGeneration_from_base, String transportationPlanGeneration_to_base, String transportationPlanGeneration_number, String transportationPlanGeneration_volume, String transportationPlanGeneration_weight, String transportationPlanGeneration_remark){
        this.transportationPlanGeneration_state = new SimpleStringProperty(transportationPlanGeneration_state);
        this.transportationPlanGeneration_type = new SimpleStringProperty(transportationPlanGeneration_type);
        this.transportationPlanGeneration_from_city = new SimpleStringProperty(transportationPlanGeneration_from_city);
        this.transportationPlanGeneration_to_city = new SimpleStringProperty(transportationPlanGeneration_to_city);
        this.transportationPlanGeneration_from_base = new SimpleStringProperty(transportationPlanGeneration_from_base);
        this.transportationPlanGeneration_to_base = new SimpleStringProperty(transportationPlanGeneration_to_base);
        this.transportationPlanGeneration_number = new SimpleStringProperty(transportationPlanGeneration_number);
        this.transportationPlanGeneration_volume = new SimpleStringProperty(transportationPlanGeneration_volume);
        this.transportationPlanGeneration_weight = new SimpleStringProperty(transportationPlanGeneration_weight);
        this.transportationPlanGeneration_remark = new SimpleStringProperty(transportationPlanGeneration_remark);
    }




    public String getTransportationPlanGeneration_state() {
        return transportationPlanGeneration_state.get();
    }

    public StringProperty transportationPlanGeneration_stateProperty() {
        return transportationPlanGeneration_state;
    }

    public String getTransportationPlanGeneration_type() {
        return transportationPlanGeneration_type.get();
    }

    public StringProperty transportationPlanGeneration_typeProperty() {
        return transportationPlanGeneration_type;
    }

    public String getTransportationPlanGeneration_from_city() {
        return transportationPlanGeneration_from_city.get();
    }

    public StringProperty transportationPlanGeneration_from_cityProperty() {
        return transportationPlanGeneration_from_city;
    }

    public String getTransportationPlanGeneration_to_city() {
        return transportationPlanGeneration_to_city.get();
    }

    public StringProperty transportationPlanGeneration_to_cityProperty() {
        return transportationPlanGeneration_to_city;
    }

    public String getTransportationPlanGeneration_from_base() {
        return transportationPlanGeneration_from_base.get();
    }

    public StringProperty transportationPlanGeneration_from_baseProperty() {
        return transportationPlanGeneration_from_base;
    }

    public String getTransportationPlanGeneration_to_base() {
        return transportationPlanGeneration_to_base.get();
    }

    public StringProperty transportationPlanGeneration_to_baseProperty() {
        return transportationPlanGeneration_to_base;
    }

    public String getTransportationPlanGeneration_number() {
        return transportationPlanGeneration_number.get();
    }

    public StringProperty transportationPlanGeneration_numberProperty() {
        return transportationPlanGeneration_number;
    }

    public String getTransportationPlanGeneration_volume() {
        return transportationPlanGeneration_volume.get();
    }

    public StringProperty transportationPlanGeneration_volumeProperty() {
        return transportationPlanGeneration_volume;
    }

    public String getTransportationPlanGeneration_weight() {
        return transportationPlanGeneration_weight.get();
    }

    public StringProperty transportationPlanGeneration_weightProperty() {
        return transportationPlanGeneration_weight;
    }

    public String getTransportationPlanGeneration_remark() {
        return transportationPlanGeneration_remark.get();
    }

    public StringProperty transportationPlanGeneration_remarkProperty() {
        return transportationPlanGeneration_remark;
    }


    public void setTransportationPlanGeneration_state(String transportationPlanGeneration_state) {
        this.transportationPlanGeneration_state.set(transportationPlanGeneration_state);
    }

    public void setTransportationPlanGeneration_type(String transportationPlanGeneration_type) {
        this.transportationPlanGeneration_type.set(transportationPlanGeneration_type);
    }

    public void setTransportationPlanGeneration_from_city(String transportationPlanGeneration_from_city) {
        this.transportationPlanGeneration_from_city.set(transportationPlanGeneration_from_city);
    }

    public void setTransportationPlanGeneration_to_city(String transportationPlanGeneration_to_city) {
        this.transportationPlanGeneration_to_city.set(transportationPlanGeneration_to_city);
    }

    public void setTransportationPlanGeneration_from_base(String transportationPlanGeneration_from_base) {
        this.transportationPlanGeneration_from_base.set(transportationPlanGeneration_from_base);
    }

    public void setTransportationPlanGeneration_to_base(String transportationPlanGeneration_to_base) {
        this.transportationPlanGeneration_to_base.set(transportationPlanGeneration_to_base);
    }

    public void setTransportationPlanGeneration_number(String transportationPlanGeneration_number) {
        this.transportationPlanGeneration_number.set(transportationPlanGeneration_number);
    }

    public void setTransportationPlanGeneration_volume(String transportationPlanGeneration_volume) {
        this.transportationPlanGeneration_volume.set(transportationPlanGeneration_volume);
    }

    public void setTransportationPlanGeneration_weight(String transportationPlanGeneration_weight) {
        this.transportationPlanGeneration_weight.set(transportationPlanGeneration_weight);
    }

    public void setTransportationPlanGeneration_remark(String transportationPlanGeneration_remark) {
        this.transportationPlanGeneration_remark.set(transportationPlanGeneration_remark);
    }


}

