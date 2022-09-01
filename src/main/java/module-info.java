
module com.example.demo {
        requires javafx.controls;
        requires javafx.fxml;
        requires java.desktop;

        opens com.example.demo.homepage to javafx.fxml;
        opens com.example.demo to javafx.fxml;
        opens com.example.demo.register to javafx.fxml;
        opens com.example.demo.menu to javafx.fxml;

        exports com.example.demo.register;
        exports com.example.demo.homepage;
        exports com.example.demo.menu;



        }