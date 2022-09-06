package com.example.demo.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class freightManagement {
    private final StringProperty frid;
    private final StringProperty frcarrier;
    private final StringProperty frstartcity;
    private final StringProperty frdestinationcity;
    private final StringProperty frtransport;
    private final StringProperty froneall;
    private final StringProperty frweight;
    private final StringProperty frtime;
    private final StringProperty frpermium;
    private final StringProperty frstarttime;
    private final StringProperty frdeadtime;
    private final StringProperty froperator;

    public freightManagement(){
        this(null,null,null,null,null,null,null,null,null,null,null,null);
    }
    public freightManagement(String frid, String frcarrier, String frstartcity, String frdestinationcity, String frtransport, String froneall, String frweight, String frtime, String frpermium, String frstarttime, String frdeadtime, String froperator) {
        this.frid =  new SimpleStringProperty(frid);
        this.frcarrier =  new SimpleStringProperty(frcarrier);
        this.frstartcity =  new SimpleStringProperty(frstartcity);
        this.frdestinationcity =  new SimpleStringProperty(frdestinationcity);
        this.frtransport =  new SimpleStringProperty(frtransport);
        this.froneall =  new SimpleStringProperty(froneall);
        this.frweight =  new SimpleStringProperty(frweight);
        this.frtime =  new SimpleStringProperty(frtime);
        this.frpermium =  new SimpleStringProperty(frpermium);
        this.frstarttime =  new SimpleStringProperty(frstarttime);
        this.frdeadtime =  new SimpleStringProperty(frdeadtime);
        this.froperator =  new SimpleStringProperty(froperator);
    }

    public String getFrid() {
        return frid.get();
    }

    public StringProperty fridProperty() {
        return frid;
    }

    public void setFrid(String frid) {
        this.frid.set(frid);
    }

    public String getFrcarrier() {
        return frcarrier.get();
    }

    public StringProperty frcarrierProperty() {
        return frcarrier;
    }

    public void setFrcarrier(String frcarrier) {
        this.frcarrier.set(frcarrier);
    }

    public String getFrstartcity() {
        return frstartcity.get();
    }

    public StringProperty frstartcityProperty() {
        return frstartcity;
    }

    public void setFrstartcity(String frstartcity) {
        this.frstartcity.set(frstartcity);
    }

    public String getFrdestinationcity() {
        return frdestinationcity.get();
    }

    public StringProperty frdestinationcityProperty() {
        return frdestinationcity;
    }

    public void setFrdestinationcity(String frdestinationcity) {
        this.frdestinationcity.set(frdestinationcity);
    }

    public String getFrtransport() {
        return frtransport.get();
    }

    public StringProperty frtransportProperty() {
        return frtransport;
    }

    public void setFrtransport(String frtransport) {
        this.frtransport.set(frtransport);
    }

    public String getFroneall() {
        return froneall.get();
    }

    public StringProperty froneallProperty() {
        return froneall;
    }

    public void setFroneall(String froneall) {
        this.froneall.set(froneall);
    }

    public String getFrweight() {
        return frweight.get();
    }

    public StringProperty frweightProperty() {
        return frweight;
    }

    public void setFrweight(String frweight) {
        this.frweight.set(frweight);
    }

    public String getFrtime() {
        return frtime.get();
    }

    public StringProperty frtimeProperty() {
        return frtime;
    }

    public void setFrtime(String frtime) {
        this.frtime.set(frtime);
    }

    public String getFrpermium() {
        return frpermium.get();
    }

    public StringProperty frpermiumProperty() {
        return frpermium;
    }

    public void setFrpermium(String frpermium) {
        this.frpermium.set(frpermium);
    }

    public String getFrstarttime() {
        return frstarttime.get();
    }

    public StringProperty frstarttimeProperty() {
        return frstarttime;
    }

    public void setFrstarttime(String frstarttime) {
        this.frstarttime.set(frstarttime);
    }

    public String getFrdeadtime() {
        return frdeadtime.get();
    }

    public StringProperty frdeadtimeProperty() {
        return frdeadtime;
    }

    public void setFrdeadtime(String frdeadtime) {
        this.frdeadtime.set(frdeadtime);
    }

    public String getFroperator() {
        return froperator.get();
    }

    public StringProperty froperatorProperty() {
        return froperator;
    }

    public void setFroperator(String froperator) {
        this.froperator.set(froperator);
    }
}
