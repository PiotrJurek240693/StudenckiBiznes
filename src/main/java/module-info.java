module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens gui to javafx.fxml;
    exports gui;
}