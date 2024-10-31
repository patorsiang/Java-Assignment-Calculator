package kent.co871.a2calculator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.OptionalDouble;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final Model model;
    private final StringProperty formula;
    private final StringProperty display;

    @FXML
    public Label lblDisplay;

    @FXML
    public Label lblFormula;

    public Controller() {

        model = new Model();
        formula = new SimpleStringProperty("");
        display = new SimpleStringProperty("");
    }

    public String getFormula() { return formula.get(); }

    public void setFormula(String formula) { this.formula.set(formula); }

    public String getDisplay() { return display.get(); }

    public void setDisplay(String display) { this.display.set(display); }

    public Model getModel() { return model; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblFormula.textProperty().bind(formula);
        lblDisplay.textProperty().bind(display);
        clearAll();
    }

    @FXML
    public void clearAll() {

        //TODO
    }

    @FXML
    public void delete() {

        //TODO
    }

    @FXML
    public void processNumber(ActionEvent event) {

        //TODO
    }

    @FXML
    public void processBinaryOperator(ActionEvent event) {

        //TODO
    }

    @FXML
    public void processUnaryOperator(ActionEvent event) {

        //TODO
    }

    @FXML
    public void doCalculation() {

        //TODO
    }

    ///////////////////////////////////////////////////
    // Define your own methods after this line please
    ///////////////////////////////////////////////////

}