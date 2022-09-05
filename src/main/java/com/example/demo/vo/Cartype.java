package com.example.demo.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cartype {
    private final StringProperty car_type;
    private final StringProperty car_volume;
    private final StringProperty car_load;
    private final StringProperty car_state;
    private final StringProperty car_remark;
    public Cartype(){
        this(null,null,null,null,null);
    }
    public Cartype(String car_type,String car_volume,String car_load,String car_state,String car_remark){
        this.car_type = new SimpleStringProperty(car_type);
        this.car_volume = new SimpleStringProperty(car_volume);
        this.car_load = new SimpleStringProperty(car_state);
        this.car_state = new SimpleStringProperty(car_state);
        this.car_remark = new SimpleStringProperty(car_remark);

    }

    public String getCar_type() {
        return car_type.get();
    }

    public StringProperty car_typeProperty() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type.set(car_type);
    }

    public String getCar_volume() {
        return car_volume.get();
    }

    public StringProperty car_volumeProperty() {
        return car_volume;
    }

    public void setCar_volume(String car_volume) {
        this.car_volume.set(car_volume);
    }

    public String getCar_load() {
        return car_load.get();
    }

    public StringProperty car_loadProperty() {
        return car_load;
    }

    public void setCar_load(String car_load) {
        this.car_load.set(car_load);
    }

    public String getCar_state() {
        return car_state.get();
    }

    public StringProperty car_stateProperty() {
        return car_state;
    }

    public void setCar_state(String car_state) {
        this.car_state.set(car_state);
    }

    public String getCar_remark() {
        return car_remark.get();
    }

    public StringProperty car_remarkProperty() {
        return car_remark;
    }

    public void setCar_remark(String car_remark) {
        this.car_remark.set(car_remark);
    }
}
