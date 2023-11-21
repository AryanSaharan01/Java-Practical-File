import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hlo {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Factorial Calculator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 100);

        JButton clickButton = new JButton("Click");
        mainFrame.add(clickButton);
        mainFrame.setLayout(new FlowLayout());

        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame factorialFrame = new JFrame("Factorial");
                factorialFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                factorialFrame.setSize(300, 150);

                JLabel inputLabel = new JLabel("Enter a number:");
                JTextField inputTextField = new JTextField(10);
                JButton calculateButton = new JButton("Calculate Factorial");

                factorialFrame.setLayout(new FlowLayout());
                factorialFrame.add(inputLabel);
                factorialFrame.add(inputTextField);
                factorialFrame.add(calculateButton);

                calculateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int number = Integer.parseInt(inputTextField.getText());
                            long factorial = calculateFactorial(number);
                            JOptionPane.showMessageDialog(factorialFrame, "Factorial of " + number + " is " + factorial, "Result", JOptionPane.INFORMATION_MESSAGE);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(factorialFrame, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                factorialFrame.setVisible(true);
            }
        });

        mainFrame.setVisible(true);
    }

    private static long calculateFactorial(int n) {
        if (n < 0) {
            return -1; // Invalid input
        } else if (n == 0 || n == 1) {
            return 1;
        }

        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
