package com.example.demo.vo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class characterManagement {
    private final StringProperty cmstate;
    private final StringProperty cmrole;
    private final StringProperty cmremark;
    private final StringProperty cmpermission;
    private final StringProperty cmoperate;

    public characterManagement() {
        this(null,null,null,null,null);
    }

    public characterManagement(String cmstate, String cmrole, String cmremark, String cmpermission, String cmoperate) {
        this.cmstate = new SimpleStringProperty(cmstate);
        this.cmrole = new  SimpleStringProperty(cmrole);
        this.cmremark = new  SimpleStringProperty(cmremark);
        this.cmpermission = new SimpleStringProperty(cmpermission);
        this.cmoperate = new  SimpleStringProperty(cmoperate);
    }

    public String getCmstate() {
        return cmstate.get();
    }

    public StringProperty cmstateProperty() {
        return cmstate;
    }

    public void setCmstate(String cmstate) {
        this.cmstate.set(cmstate);
    }

    public String getCmrole() {
        return cmrole.get();
    }

    public StringProperty cmroleProperty() {
        return cmrole;
    }

    public void setCmrole(String cmrole) {
        this.cmrole.set(cmrole);
    }

    public String getCmremark() {
        return cmremark.get();
    }

    public StringProperty cmremarkProperty() {
        return cmremark;
    }

    public void setCmremark(String cmremark) {
        this.cmremark.set(cmremark);
    }

    public String getCmpermission() {
        return cmpermission.get();
    }

    public StringProperty cmpermissionProperty() {
        return cmpermission;
    }

    public void setCmpermission(String cmpermission) {
        this.cmpermission.set(cmpermission);
    }

    public String getCmoperate() {
        return cmoperate.get();
    }

    public StringProperty cmoperateProperty() {
        return cmoperate;
    }

    public void setCmoperate(String cmoperate) {
        this.cmoperate.set(cmoperate);
    }
}
