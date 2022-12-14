
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
        opens com.example.demo.business to javafx.fxml;
        opens com.example.demo.shippingInfomationChange to javafx.fxml;
        opens com.example.demo.carrierManagement to javafx.fxml;
        opens com.example.demo.freightManagement to javafx.fxml;
        opens com.example.demo.signInfomationChange to javafx.fxml;
        opens com.example.demo.claimChange to javafx.fxml;
        opens com.example.demo.characterManagement to javafx.fxml;
        opens com.example.demo.good to javafx.fxml;
        opens com.example.demo.transportationPlanGeneration to javafx.fxml;
        opens com.example.demo.commissionedByTransport to javafx.fxml;
        opens com.example.demo.newClaimLetter to javafx.fxml;
        opens com.example.demo.confirmDoc to javafx.fxml;
        opens com.example.demo.newSignInDoc to javafx.fxml;
        opens com.example.demo.changeClaimLetter to javafx.fxml;
        opens com.example.demo.confirmationOfLetter to javafx.fxml;
        opens com.example.demo.routeManagement to javafx.fxml;
        opens com.example.demo.carType to javafx.fxml;
        opens com.example.demo.citymanagement to javafx.fxml;
        opens com.example.demo.carRecord to javafx.fxml;
        opens com.example.demo.node to javafx.fxml;


        exports com.example.demo.register;
        exports com.example.demo.homepage;
        exports com.example.demo.menu;
        exports com.example.demo.accountManagement;
        exports com.example.demo.business;
        exports com.example.demo.shippingInfomationChange;
        exports com.example.demo.carrierManagement;
        exports com.example.demo.freightManagement;
        exports com.example.demo.routeManagement;
        exports com.example.demo.signInfomationChange;
        exports com.example.demo.claimChange;
        exports com.example.demo.characterManagement;
        exports com.example.demo.good;
        exports com.example.demo.transportationPlanGeneration;
        exports com.example.demo.commissionedByTransport;
        exports com.example.demo.newClaimLetter;
        exports com.example.demo.carType;
        exports com.example.demo.changeClaimLetter;
        exports com.example.demo.newSignInDoc;
        exports com.example.demo.confirmDoc;
        exports com.example.demo.confirmationOfLetter;
        exports com.example.demo.carRecord;
        exports com.example.demo.node;



        }