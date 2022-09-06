package com.example.demo.vo;
import javafx.beans.property.*;
public class newSignInDoc {

    private final StringProperty goodget_nub;
    private final StringProperty goodget_fcity;
    private final StringProperty goodget_fhouse;
    private final StringProperty goodget_lcity;
    private final StringProperty goodget_lhouse;
    private final StringProperty goodget_goodarea;
    private final StringProperty goodget_getarea;
    private final StringProperty goodget_people;
    private final StringProperty goodget_runway;
    private final StringProperty goodget_type;
    private final StringProperty goodget_goodmuch;
    private final StringProperty goodget_write;
    private final StringProperty goodget_action;






    public newSignInDoc(){
        this(null,null,null,null,null,null,null,null,null,null,null,null,null);
    }

    public newSignInDoc(String goodget_nub,String goodget_fcity ,String goodget_fhouse,String goodget_lcity,String goodget_lhouse, String goodget_goodarea, String goodget_getarea,
                        String goodget_people, String goodget_runway, String goodget_type, String goodget_goodmuch, String goodget_write,String goodget_action){
        this.goodget_type = new SimpleStringProperty(goodget_type);
        this.goodget_fcity = new SimpleStringProperty(goodget_fcity);
        this.goodget_lcity = new SimpleStringProperty(goodget_lcity);
        this.goodget_people = new SimpleStringProperty(goodget_people);
        this.goodget_nub = new SimpleStringProperty(goodget_nub);
        this.goodget_fhouse = new SimpleStringProperty(goodget_fhouse);
        this.goodget_lhouse = new SimpleStringProperty(goodget_lhouse);
        this.goodget_runway = new SimpleStringProperty(goodget_runway);
        this.goodget_goodarea = new SimpleStringProperty(goodget_goodarea);
        this.goodget_getarea = new SimpleStringProperty(goodget_getarea);
        this.goodget_goodmuch = new SimpleStringProperty(goodget_goodmuch);
        this.goodget_write = new SimpleStringProperty(goodget_write);
        this.goodget_action = new SimpleStringProperty(goodget_action);


        //数据类型double this.price = new SimpleDoubleProperty(price);
    }

    public String getGoodget_nub() {
        return goodget_nub.get();
    }

    public StringProperty goodget_nubProperty() {
        return goodget_nub;
    }

    public void setGoodget_nub(String goodget_nub) {
        this.goodget_nub.set(goodget_nub);
    }

    public String getGoodget_fcity() {
        return goodget_fcity.get();
    }

    public StringProperty goodget_fcityProperty() {
        return goodget_fcity;
    }

    public void setGoodget_fcity(String goodget_fcity) {
        this.goodget_fcity.set(goodget_fcity);
    }

    public String getGoodget_fhouse() {
        return goodget_fhouse.get();
    }

    public StringProperty goodget_fhouseProperty() {
        return goodget_fhouse;
    }

    public void setGoodget_fhouse(String goodget_fhouse) {
        this.goodget_fhouse.set(goodget_fhouse);
    }

    public String getGoodget_lcity() {
        return goodget_lcity.get();
    }

    public StringProperty goodget_lcityProperty() {
        return goodget_lcity;
    }

    public void setGoodget_lcity(String goodget_lcity) {
        this.goodget_lcity.set(goodget_lcity);
    }

    public String getGoodget_lhouse() {
        return goodget_lhouse.get();
    }

    public StringProperty goodget_lhouseProperty() {
        return goodget_lhouse;
    }

    public void setGoodget_lhouse(String goodget_lhouse) {
        this.goodget_lhouse.set(goodget_lhouse);
    }

    public String getGoodget_goodarea() {
        return goodget_goodarea.get();
    }

    public StringProperty goodget_goodareaProperty() {
        return goodget_goodarea;
    }

    public void setGoodget_goodarea(String goodget_goodarea) {
        this.goodget_goodarea.set(goodget_goodarea);
    }

    public String getGoodget_getarea() {
        return goodget_getarea.get();
    }

    public StringProperty goodget_getareaProperty() {
        return goodget_getarea;
    }

    public void setGoodget_getarea(String goodget_getarea) {
        this.goodget_getarea.set(goodget_getarea);
    }

    public String getGoodget_people() {
        return goodget_people.get();
    }

    public StringProperty goodget_peopleProperty() {
        return goodget_people;
    }

    public void setGoodget_people(String goodget_people) {
        this.goodget_people.set(goodget_people);
    }

    public String getGoodget_runway() {
        return goodget_runway.get();
    }

    public StringProperty goodget_runwayProperty() {
        return goodget_runway;
    }

    public void setGoodget_runway(String goodget_runway) {
        this.goodget_runway.set(goodget_runway);
    }

    public String getGoodget_type() {
        return goodget_type.get();
    }

    public StringProperty goodget_typeProperty() {
        return goodget_type;
    }

    public void setGoodget_type(String goodget_type) {
        this.goodget_type.set(goodget_type);
    }

    public String getGoodget_goodmuch() {
        return goodget_goodmuch.get();
    }

    public StringProperty goodget_goodmuchProperty() {
        return goodget_goodmuch;
    }

    public void setGoodget_goodmuch(String goodget_goodmuch) {
        this.goodget_goodmuch.set(goodget_goodmuch);
    }

    public String getGoodget_write() {
        return goodget_write.get();
    }

    public StringProperty goodget_writeProperty() {
        return goodget_write;
    }

    public void setGoodget_write(String goodget_write) {
        this.goodget_write.set(goodget_write);
    }

    public String getGoodget_action() {
        return goodget_action.get();
    }

    public StringProperty goodget_actionProperty() {
        return goodget_action;
    }

    public void setGoodget_action(String goodget_action) {
        this.goodget_action.set(goodget_action);
    }
}
