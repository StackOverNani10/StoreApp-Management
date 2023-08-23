module com.example.storeapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.storeapp to javafx.fxml;
    exports com.example.storeapp;
    exports controller;
    opens controller to javafx.fxml;
    exports models;
    opens models to javafx.fxml;
}

