module com.example.realestatemanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.realestatemanager to javafx.fxml;
    exports com.example.realestatemanager;
}