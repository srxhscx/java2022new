package com.example.demo.vo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CityNode {
    private final StringProperty city_name;
    private final StringProperty city_id;
    private final StringProperty city_state;
    private final StringProperty city_institution;
    private final StringProperty city_distribution;
    private final StringProperty node_type;
    private final StringProperty node_name;

    public CityNode(){
        this(null,null,null,null,null,null,null);

    }
    public CityNode(String city_name, String city_id, String city_state, String city_institution, String city_distribution, String node_type, String node_name ){
        this.city_name = new SimpleStringProperty(city_name);
        this.city_id = new SimpleStringProperty(city_id);
        this.city_state  = new SimpleStringProperty(city_state);
        this.city_institution = new SimpleStringProperty(city_institution);
        this.city_distribution = new SimpleStringProperty(city_distribution);
        this.node_type = new SimpleStringProperty(node_type);
        this.node_name = new SimpleStringProperty(node_name);
    }

    public String getCity_name() {
        return city_name.get();
    }

    public StringProperty city_nameProperty() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name.set(city_name);
    }

    public String getCity_id() {
        return city_id.get();
    }

    public StringProperty city_idProperty() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id.set(city_id);
    }

    public String getCity_state() {
        return city_state.get();
    }

    public StringProperty city_stateProperty() {
        return city_state;
    }

    public void setCity_state(String city_state) {
        this.city_state.set(city_state);
    }

    public String getCity_institution() {
        return city_institution.get();
    }

    public StringProperty city_institutionProperty() {
        return city_institution;
    }

    public void setCity_institution(String city_institution) {
        this.city_institution.set(city_institution);
    }

    public String getCity_distribution() {
        return city_distribution.get();
    }

    public StringProperty city_distributionProperty() {
        return city_distribution;
    }

    public void setCity_distribution(String city_distribution) {
        this.city_distribution.set(city_distribution);
    }

    public String getNode_type() {
        return node_type.get();
    }

    public StringProperty node_typeProperty() {
        return node_type;
    }

    public void setNode_type(String node_type) {
        this.node_type.set(node_type);
    }

    public String getNode_name() {
        return node_name.get();
    }

    public StringProperty node_nameProperty() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name.set(node_name);
    }
}



