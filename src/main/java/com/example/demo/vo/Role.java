package com.example.demo.vo;

public class Role {
    private String role_name;
    private String role_permission;

    public Role(){

    }
    public Role(String role_name,String role_permission){
        this.role_name = role_name;
        this.role_permission = role_permission;
    }
    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_permission() {
        return role_permission;
    }

    public void setRole_permission(String role_permission) {
        this.role_permission = role_permission;
    }
}
