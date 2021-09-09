module com.example.randomfacegenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.randomfacegenerator to javafx.fxml;
    exports com.example.randomfacegenerator;
}