package com.example.demo.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PreTransitMonitor {
    private final StringProperty PreInformation_number;
    private final StringProperty PreInformation_license;
    private final StringProperty PreInformation_state;
    private final StringProperty PreInformation_carrier;
    private final StringProperty PreInformation_on_way;

    public PreTransitMonitor() {
        this(null,null,null,null,null);
    }
    public PreTransitMonitor(String PreInformation_number,String PreInformation_license,String PreInformation_state,String PreInformation_carrier,String PreInformation_on_way) {
        this.PreInformation_number = new SimpleStringProperty(PreInformation_number);
        this.PreInformation_license = new SimpleStringProperty(PreInformation_license);
        this.PreInformation_state = new SimpleStringProperty(PreInformation_state);
        this.PreInformation_carrier = new SimpleStringProperty(PreInformation_carrier);
        this.PreInformation_on_way = new SimpleStringProperty(PreInformation_on_way);
    }

    public String getPreInformation_number() {
        return PreInformation_number.get();
    }

    public StringProperty preInformation_numberProperty() {
        return PreInformation_number;
    }

    public void setPreInformation_number(String preInformation_number) {
        this.PreInformation_number.set(preInformation_number);
    }

    public String getPreInformation_license() {
        return PreInformation_license.get();
    }

    public StringProperty preInformation_licenseProperty() {
        return PreInformation_license;
    }

    public void setPreInformation_license(String preInformation_license) {
        this.PreInformation_license.set(preInformation_license);
    }

    public String getPreInformation_state() {
        return PreInformation_state.get();
    }

    public StringProperty preInformation_stateProperty() {
        return PreInformation_state;
    }

    public void setPreInformation_state(String preInformation_state) {
        this.PreInformation_state.set(preInformation_state);
    }

    public String getPreInformation_carrier() {
        return PreInformation_carrier.get();
    }

    public StringProperty preInformation_carrierProperty() {
        return PreInformation_carrier;
    }

    public void setPreInformation_carrier(String preInformation_carrier) {
        this.PreInformation_carrier.set(preInformation_carrier);
    }

    public String getPreInformation_on_way() {
        return PreInformation_on_way.get();
    }

    public StringProperty preInformation_on_wayProperty() {
        return PreInformation_on_way;
    }

    public void setPreInformation_on_way(String preInformation_on_way) {
        this.PreInformation_on_way.set(preInformation_on_way);
    }
}
//    information_number
//    information_license
//    information_state
//    information_carrier
//    information_on_way