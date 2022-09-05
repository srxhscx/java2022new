
module com.example.demo {
        requires javafx.controls;
        requires javafx.fxml;
        requires java.desktop;
        requires java.sql;


        opens com.example.demo.homepage to javafx.fxml;
        opens com.example.demo to javafx.fxml;
        opens com.example.demo.register to javafx.fxml;
        opens com.example.demo.menu to javafx.fxml;
        opens com.example.demo.accountManagement to javafx.fxml;
        opens com.example.demo.roleManagement to javafx.fxml;
        opens com.example.demo.business to javafx.fxml;
        opens com.example.demo.shippingInfomationChange to javafx.fxml;
        opens com.example.demo.carrierManagement to javafx.fxml;
        opens com.example.demo.freightManagement to javafx.fxml;
        opens com.example.demo.signInfomationChange to javafx.fxml;
        opens com.example.demo.claimChange to javafx.fxml;
        opens com.example.demo.permissionManagement to javafx.fxml;
        opens com.example.demo.characterManagement to javafx.fxml;
        opens com.example.demo.good to javafx.fxml;



        exports com.example.demo.register;
        exports com.example.demo.homepage;
        exports com.example.demo.menu;
        exports com.example.demo.accountManagement;
        exports com.example.demo.roleManagement;
        exports com.example.demo.business;
        exports com.example.demo.shippingInfomationChange;
        exports com.example.demo.carrierManagement;
        exports com.example.demo.freightManagement;
        exports com.example.demo.routeManagement;
        exports com.example.demo.signInfomationChange;
        exports com.example.demo.claimChange;
        exports com.example.demo.permissionManagement;
        exports com.example.demo.characterManagement;
        exports com.example.demo.good;


        }