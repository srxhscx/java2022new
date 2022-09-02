package com.example.demo.model;

public class Role {
    private int user_id;
    private String user_account;

    public Role(){}

    public Role(int user_id, String user_account) {
        this.user_id = user_id;
        this.user_account = user_account;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }
}
