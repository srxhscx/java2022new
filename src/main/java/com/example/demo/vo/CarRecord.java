package com.example.demo.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CarRecord {
    private final StringProperty car_number;
    private final StringProperty trailer_number;
    private final StringProperty car_type;
    private final StringProperty car_state;
    private final StringProperty car_carrier;
    private final StringProperty car_volume;
    private final StringProperty car_load;
    private final StringProperty car_people;
    private final StringProperty car_telephone;
    private final StringProperty car_remark;

    public CarRecord(){
        this(null,null,null,null,null,null,null,null,null,null);
    }
    public CarRecord(String car_number, String trailer_number, String car_type, String car_state, String car_carrier, String car_volume, String car_load, String car_people, String car_telephone, String car_remark) {
        this.car_number = new SimpleStringProperty(car_number);
        this.trailer_number = new SimpleStringProperty(trailer_number);
        this.car_type = new SimpleStringProperty(car_type);
        this.car_state = new SimpleStringProperty(car_state);
        this.car_carrier = new SimpleStringProperty(car_carrier);
        this.car_volume = new SimpleStringProperty(car_volume);
        this.car_load = new SimpleStringProperty(car_load);
        this.car_people = new SimpleStringProperty(car_people);
        this.car_telephone = new SimpleStringProperty(car_telephone);
        this.car_remark = new SimpleStringProperty(car_remark);
    }


    public String getCar_number() {
        return car_number.get();
    }

    public StringProperty car_numberProperty() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number.set(car_number);
    }

    public String getTrailer_number() {
        return trailer_number.get();
    }

    public StringProperty trailer_numberProperty() {
        return trailer_number;
    }

    public void setTrailer_number(String trailer_number) {
        this.trailer_number.set(trailer_number);
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

    public String getCar_state() {
        return car_state.get();
    }

    public StringProperty car_stateProperty() {
        return car_state;
    }

    public void setCar_state(String car_state) {
        this.car_state.set(car_state);
    }

    public String getCar_carrier() {
        return car_carrier.get();
    }

    public StringProperty car_carrierProperty() {
        return car_carrier;
    }

    public void setCar_carrier(String car_carrier) {
        this.car_carrier.set(car_carrier);
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

    public String getCar_people() {
        return car_people.get();
    }

    public StringProperty car_peopleProperty() {
        return car_people;
    }

    public void setCar_people(String car_people) {
        this.car_people.set(car_people);
    }

    public String getCar_telephone() {
        return car_telephone.get();
    }

    public StringProperty car_telephoneProperty() {
        return car_telephone;
    }

    public void setCar_telephone(String car_telephone) {
        this.car_telephone.set(car_telephone);
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
