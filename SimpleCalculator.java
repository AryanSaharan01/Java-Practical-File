import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(5, 4));

        JTextField textField = new JTextField();
        panel.add(textField);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            panel.add(button);
            button.addActionListener(new CalculatorButtonListener(textField));
        }

        frame.setVisible(true);
    }
}

class CalculatorButtonListener implements ActionListener {
    private JTextField textField;

    public CalculatorButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("=")) {
            try {
                String expression = textField.getText();
                double result = evaluateExpression(expression);
                textField.setText(String.valueOf(result));
            } catch (ArithmeticException | NumberFormatException ex) {
                textField.setText("Error");
            }
        } else if (command.equals("C")) {
            textField.setText("");
        } else {
            textField.setText(textField.getText() + command);
        }
    }

    private double evaluateExpression(String expression) {
        String[] parts = expression.split("[+\\-*/]");
        double num1 = Double.parseDouble(parts[0]);
        double num2 = Double.parseDouble(parts[1]);
        if (expression.contains("+")) {
            return num1 + num2;
        } else if (expression.contains("-")) {
            return num1 - num2;
        } else if (expression.contains("*")) {
            return num1 * num2;
        } else if (expression.contains("/")) {
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return num1 / num2;
        } else {
            throw new NumberFormatException("Invalid expression");
        }
    }
}
