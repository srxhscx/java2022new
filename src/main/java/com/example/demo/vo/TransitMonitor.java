package com.example.demo.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TransitMonitor {
    private final StringProperty information_number;
    private final StringProperty information_license;
    private final StringProperty information_state;
    private final StringProperty information_carrier;
    private final StringProperty information_on_way;

    public TransitMonitor() {
        this(null,null,null,null,null);
    }
    public TransitMonitor(String information_number,String information_license,String information_state,String information_carrier,String information_on_way) {
        this.information_number = new SimpleStringProperty(information_number);
        this.information_license = new SimpleStringProperty(information_license);
        this.information_state = new SimpleStringProperty(information_state);
        this.information_carrier = new SimpleStringProperty(information_carrier);
        this.information_on_way = new SimpleStringProperty(information_on_way);
    }

    public String getInformation_number() {
        return information_number.get();
    }

    public StringProperty information_numberProperty() {
        return information_number;
    }

    public void setInformation_number(String information_number) {
        this.information_number.set(information_number);
    }

    public String getInformation_license() {
        return information_license.get();
    }

    public StringProperty information_licenseProperty() {
        return information_license;
    }

    public void setInformation_license(String information_license) {
        this.information_license.set(information_license);
    }

    public String getInformation_state() {
        return information_state.get();
    }

    public StringProperty information_stateProperty() {
        return information_state;
    }

    public void setInformation_state(String information_state) {
        this.information_state.set(information_state);
    }

    public String getInformation_carrier() {
        return information_carrier.get();
    }

    public StringProperty information_carrierProperty() {
        return information_carrier;
    }

    public void setInformation_carrier(String information_carrier) {
        this.information_carrier.set(information_carrier);
    }

    public String getInformation_on_way() {
        return information_on_way.get();
    }

    public StringProperty information_on_wayProperty() {
        return information_on_way;
    }

    public void setInformation_on_way(String information_on_way) {
        this.information_on_way.set(information_on_way);
    }
}