module kent.co871.a2calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens kent.co871.a2calculator to javafx.fxml;
    exports kent.co871.a2calculator;
}