module com.example.csc221_project3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc221_project3 to javafx.fxml;
    exports com.example.csc221_project3;
}