package com.example.demo.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class carrierManagement {
    private final StringProperty fmstate;
    private final StringProperty fmnum;
    private final StringProperty fmname;
    private final StringProperty fmshortname;
    private final StringProperty fmcontact;
    private final StringProperty fmphone;
    private final StringProperty fmtel;
    private final StringProperty fmaddress;
    private final StringProperty fmremark;
    private final StringProperty fmoperate;
    public carrierManagement(){
        this(null,null,null,null,null,null,null,null,null,null);
    }
    public carrierManagement(String fmstate, String fmnum, String fmname, String fmshortname, String fmcontact, String fmphone, String fmtel, String fmaddress, String fmremark, String fmoperate) {
        this.fmstate =  new SimpleStringProperty(fmstate);
        this.fmnum = new SimpleStringProperty(fmnum);
        this.fmname =new SimpleStringProperty(fmname);
        this.fmshortname =new SimpleStringProperty(fmshortname);
        this.fmcontact =new SimpleStringProperty(fmcontact);
        this.fmphone =new SimpleStringProperty(fmphone);
        this.fmtel =new SimpleStringProperty(fmtel);
        this.fmaddress =new SimpleStringProperty(fmaddress);
        this.fmremark =new SimpleStringProperty(fmremark);
        this.fmoperate =new SimpleStringProperty(fmoperate);
    }

    public String getFmstate() {
        return fmstate.get();
    }

    public StringProperty fmstateProperty() {
        return fmstate;
    }

    public void setFmstate(String fmstate) {
        this.fmstate.set(fmstate);
    }

    public String getFmnum() {
        return fmnum.get();
    }

    public StringProperty fmnumProperty() {
        return fmnum;
    }

    public void setFmnum(String fmnum) {
        this.fmnum.set(fmnum);
    }

    public String getFmname() {
        return fmname.get();
    }

    public StringProperty fmnameProperty() {
        return fmname;
    }

    public void setFmname(String fmname) {
        this.fmname.set(fmname);
    }

    public String getFmshortname() {
        return fmshortname.get();
    }

    public StringProperty fmshortnameProperty() {
        return fmshortname;
    }

    public void setFmshortname(String fmshortname) {
        this.fmshortname.set(fmshortname);
    }

    public String getFmcontact() {
        return fmcontact.get();
    }

    public StringProperty fmcontactProperty() {
        return fmcontact;
    }

    public void setFmcontact(String fmcontact) {
        this.fmcontact.set(fmcontact);
    }

    public String getFmphone() {
        return fmphone.get();
    }

    public StringProperty fmphoneProperty() {
        return fmphone;
    }

    public void setFmphone(String fmphone) {
        this.fmphone.set(fmphone);
    }

    public String getFmtel() {
        return fmtel.get();
    }

    public StringProperty fmtelProperty() {
        return fmtel;
    }

    public void setFmtel(String fmtel) {
        this.fmtel.set(fmtel);
    }

    public String getFmaddress() {
        return fmaddress.get();
    }

    public StringProperty fmaddressProperty() {
        return fmaddress;
    }

    public void setFmaddress(String fmaddress) {
        this.fmaddress.set(fmaddress);
    }

    public String getFmremark() {
        return fmremark.get();
    }

    public StringProperty fmremarkProperty() {
        return fmremark;
    }

    public void setFmremark(String fmremark) {
        this.fmremark.set(fmremark);
    }

    public String getFmoperate() {
        return fmoperate.get();
    }

    public StringProperty fmoperateProperty() {
        return fmoperate;
    }

    public void setFmoperate(String fmoperate) {
        this.fmoperate.set(fmoperate);
    }
}
