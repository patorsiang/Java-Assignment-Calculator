package kent.co871.a2calculator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
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

    public String getFormula() {
        return formula.get();
    }

    public void setFormula(String formula) {
        this.formula.set(formula);
    }

    public String getDisplay() {
        return display.get();
    }

    public void setDisplay(String display) {
        this.display.set(display);
    }

    public Model getModel() {
        return model;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblFormula.textProperty().bind(formula);
        lblDisplay.textProperty().bind(display);
        clearAll();
    }

    @FXML
    public void clearAll() {
        setDisplay("");
        setFormula("");
    }

    @FXML
    public void delete() {
        var text = getDisplay();
        if (text.isEmpty()) {
            text = getFormula();
            setFormula(stringWithoutLastChar(text));
        } else {
            setDisplay(stringWithoutLastChar(text));
        }
    }

    @FXML
    public void processNumber(ActionEvent event) {
        var text = getDisplay();
        var buttonText = ((Button) event.getSource()).getText();
        var num = "";
        if (buttonText.equals(".")) {
            num = concat(text, buttonText);
        } else {
            num = round(Double.parseDouble(concat(text, buttonText)));
        }

        setDisplay(num);
    }

    @FXML
    public void processBinaryOperator(ActionEvent event) {
        var buttonText = " " + ((Button) event.getSource()).getText() + " ";
        var displayText = getDisplay();
        var formulaText = getFormula();

        if (displayText.isEmpty()) {
            var formulaArray = formulaText.split(" ");
            if (List.of("+", "-", "*", "÷").contains(formulaArray[formulaArray.length - 1])) {
                buttonText = "";
            }
        } else {
            formulaText = concat(formulaText, displayText);
            setDisplay("");
        }
        setFormula(concat(formulaText, buttonText));
    }

    @FXML
    public void processUnaryOperator(ActionEvent event) {
        String textButton = ((Button) event.getSource()).getText();
        String text = getDisplay();

        if (textButton.equals("√")) {
            setDisplay(sqrt(text));
        } else {
            setDisplay(convert(text));
        }
    }

    @FXML
    public void doCalculation() {

        //TODO
    }

    ///////////////////////////////////////////////////
    // Define your own methods after this line please
    ///////////////////////////////////////////////////

    public String concat(String s1, String s2) {
        if (s1 == null && s2 == null ) {
            return "";
        } else if (s1 != null && s1.isEmpty() && s2 != null && s2.isEmpty()) {
            return "";
        } else if (s1 == null || s1.isEmpty()) {
            return s2;
        } else if (s2 == null || s2.isEmpty()) {
            return s1;
        }

        if (s2.equals(".") && s1.contains(".")) {
            return s1;
        }

        return s1 + s2;
    }

    public String sqrt(String s1) {
        if (s1 == null || s1.isEmpty()) {
            return "";
        }
        return round(Math.sqrt(Double.parseDouble(s1)));
    }

    public String convert(String s1) {
        if (s1 == null || s1.isEmpty()) {
            return "";
        }
        return round(Double.parseDouble(s1) * -1);
    }

    public String round(Double num) {
        if (num % 1 == 0) {
            return "" + num.intValue();
        }
        return "" + num;
    }

    public String stringWithoutLastChar(String s1) {
        if (s1 == null || s1.isEmpty()) {
            return "";
        }
        var remove = 1;
        boolean compare = s1.charAt(s1.length() - 1) == ' ';
        if (compare) {
            remove += 2;
        }
        return s1.substring(0, s1.length() - remove);
    }


}