package com.example.demo.vo;

import javafx.beans.property.StringProperty;

public class accountManagement {
    private final StringProperty am_account;
    private final StringProperty am_name;
    private final StringProperty am_password;
    private final StringProperty am_institution;
    private final StringProperty am_city;
    private final StringProperty am_node;
    private final StringProperty am_contact;
    private final StringProperty am_mail;

    public accountManagement() {
        am_city = null;
        am_account = null;
        am_password=null;
        am_name = null;
        am_institution = null;
        am_node  = null;
        am_contact=null;
        am_mail=null;
    }

    public accountManagement(StringProperty am_account, StringProperty am_name, StringProperty am_password, StringProperty am_institution, StringProperty am_city, StringProperty am_node, StringProperty am_contact, StringProperty am_mail) {
        this.am_account = am_account;
        this.am_name = am_name;
        this.am_password = am_password;
        this.am_institution = am_institution;
        this.am_city = am_city;
        this.am_node = am_node;
        this.am_contact = am_contact;
        this.am_mail = am_mail;
    }

    public String getAm_account() {
        return am_account.get();
    }

    public StringProperty am_accountProperty() {
        return am_account;
    }

    public void setAm_account(String am_account) {
        this.am_account.set(am_account);
    }

    public String getAm_name() {
        return am_name.get();
    }

    public StringProperty am_nameProperty() {
        return am_name;
    }

    public void setAm_name(String am_name) {
        this.am_name.set(am_name);
    }

    public String getAm_password() {
        return am_password.get();
    }

    public StringProperty am_passwordProperty() {
        return am_password;
    }

    public void setAm_password(String am_password) {
        this.am_password.set(am_password);
    }

    public String getAm_institution() {
        return am_institution.get();
    }

    public StringProperty am_institutionProperty() {
        return am_institution;
    }

    public void setAm_institution(String am_institution) {
        this.am_institution.set(am_institution);
    }

    public String getAm_city() {
        return am_city.get();
    }

    public StringProperty am_cityProperty() {
        return am_city;
    }

    public void setAm_city(String am_city) {
        this.am_city.set(am_city);
    }

    public String getAm_node() {
        return am_node.get();
    }

    public StringProperty am_nodeProperty() {
        return am_node;
    }

    public void setAm_node(String am_node) {
        this.am_node.set(am_node);
    }

    public String getAm_contact() {
        return am_contact.get();
    }

    public StringProperty am_contactProperty() {
        return am_contact;
    }

    public void setAm_contact(String am_contact) {
        this.am_contact.set(am_contact);
    }

    public String getAm_mail() {
        return am_mail.get();
    }

    public StringProperty am_mailProperty() {
        return am_mail;
    }

    public void setAm_mail(String am_mail) {
        this.am_mail.set(am_mail);
    }
}
