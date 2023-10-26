import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField output;
    long num1;
    long num2;
    String operator = "";

    @FXML
    public void processNum(ActionEvent event) {

        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    public void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operator.isEmpty()) {
                return;
            }
            operator = value;
            num1 = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if (operator.isEmpty()) {
                return;
            }
            num2 = Long.parseLong(output.getText());
            // output.setText(String.valueOf(model.calculation(num1, Long.parseLong(output.getText()), operator)));
            calculation(num1, num2, operator);
            operator = "";
        }


    }

    public void calculation(long a, long b, String operator) {
        switch (operator) {
            case "+":
                output.setText(a + b + "");
                break;
            case "-":
                output.setText(a - b + "");
                break;
            case "*":
                output.setText(a * b + "");
                break;
            case "/":
                if (b == 0) {
                    output.setText("0");
                    break;
                }
                output.setText(a / b + "");
        }

    }
}


