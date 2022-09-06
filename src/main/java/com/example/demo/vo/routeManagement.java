package com.example.demo.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class routeManagement {
    private final StringProperty rmstate;
    private final StringProperty rmstartcity;
    private final StringProperty rmdestinationcity;
    private final StringProperty rmmode;
    private final StringProperty rmallone;
    private final StringProperty rmtype;
    private final StringProperty rmfirstfreight;
    private final StringProperty rmlastfreight;
    private final StringProperty rmstarttime;
    private final StringProperty rmoperate;

    public routeManagement(){
        this(null,null,null,null,null,null,null,null,null,null);
    }
    public routeManagement(String rmstate, String rmstartcity, String rmdestinationcity, String rmmode, String rmallone, String rmtype, String rmfirstfreight, String rmlastfreight, String rmstarttime, String rmoperate) {
        this.rmstate = new SimpleStringProperty(rmstate);
        this.rmstartcity = new SimpleStringProperty(rmstartcity);
        this.rmdestinationcity = new SimpleStringProperty(rmdestinationcity);
        this.rmmode = new SimpleStringProperty(rmmode);
        this.rmallone = new SimpleStringProperty(rmallone);
        this.rmtype = new SimpleStringProperty(rmtype);
        this.rmfirstfreight = new SimpleStringProperty(rmfirstfreight);
        this.rmlastfreight = new SimpleStringProperty(rmlastfreight);
        this.rmstarttime = new SimpleStringProperty(rmstarttime);
        this.rmoperate = new SimpleStringProperty(rmoperate);

    }

    public String getRmstate() {
        return rmstate.get();
    }

    public StringProperty rmstateProperty() {
        return rmstate;
    }

    public void setRmstate(String rmstate) {
        this.rmstate.set(rmstate);
    }

    public String getRmstartcity() {
        return rmstartcity.get();
    }

    public StringProperty rmstartcityProperty() {
        return rmstartcity;
    }

    public void setRmstartcity(String rmstartcity) {
        this.rmstartcity.set(rmstartcity);
    }

    public String getRmdestinationcity() {
        return rmdestinationcity.get();
    }

    public StringProperty rmdestinationcityProperty() {
        return rmdestinationcity;
    }

    public void setRmdestinationcity(String rmdestinationcity) {
        this.rmdestinationcity.set(rmdestinationcity);
    }

    public String getRmmode() {
        return rmmode.get();
    }

    public StringProperty rmmodeProperty() {
        return rmmode;
    }

    public void setRmmode(String rmmode) {
        this.rmmode.set(rmmode);
    }

    public String getRmallone() {
        return rmallone.get();
    }

    public StringProperty rmalloneProperty() {
        return rmallone;
    }

    public void setRmallone(String rmallone) {
        this.rmallone.set(rmallone);
    }

    public String getRmtype() {
        return rmtype.get();
    }

    public StringProperty rmtypeProperty() {
        return rmtype;
    }

    public void setRmtype(String rmtype) {
        this.rmtype.set(rmtype);
    }

    public String getRmfirstfreight() {
        return rmfirstfreight.get();
    }

    public StringProperty rmfirstfreightProperty() {
        return rmfirstfreight;
    }

    public void setRmfirstfreight(String rmfirstfreight) {
        this.rmfirstfreight.set(rmfirstfreight);
    }

    public String getRmlastfreight() {
        return rmlastfreight.get();
    }

    public StringProperty rmlastfreightProperty() {
        return rmlastfreight;
    }

    public void setRmlastfreight(String rmlastfreight) {
        this.rmlastfreight.set(rmlastfreight);
    }

    public String getRmstarttime() {
        return rmstarttime.get();
    }

    public StringProperty rmstarttimeProperty() {
        return rmstarttime;
    }

    public void setRmstarttime(String rmstarttime) {
        this.rmstarttime.set(rmstarttime);
    }

    public String getRmoperate() {
        return rmoperate.get();
    }

    public StringProperty rmoperateProperty() {
        return rmoperate;
    }

    public void setRmoperate(String rmoperate) {
        this.rmoperate.set(rmoperate);
    }
}

