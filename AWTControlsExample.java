import java.awt.*;
import java.awt.event.*;

public class AWTControlsExample {
    private Frame frame;
    private Choice choice;
    private List list;
    private TextField textField;
    private Button submitButton;

    public AWTControlsExample() {
        frame = new Frame("AWT Controls Example");

        // Choice control
        choice = new Choice();
        choice.add("Option 1");
        choice.add("Option 2");
        choice.add("Option 3");
        choice.setBounds(50, 50, 100, 30);

        // List control
        list = new List(3, true);
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.setBounds(50, 100, 100, 60);

        // TextField control
        textField = new TextField(20);
        textField.setBounds(50, 200, 150, 30);

        // Button control
        submitButton = new Button("Submit");
        submitButton.setBounds(50, 250, 80, 30);

        // Add ActionListener to the Button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedChoice = choice.getSelectedItem();
                String[] selectedListItems = list.getSelectedItems();
                String enteredText = textField.getText();

                System.out.println("Choice: " + selectedChoice);
                System.out.print("List Items: ");
                for (String item : selectedListItems) {
                    System.out.print(item + " ");
                }
                System.out.println();
                System.out.println("Text Field: " + enteredText);
            }
        });

        frame.setLayout(null);
        frame.add(choice);
        frame.add(list);
        frame.add(textField);
        frame.add(submitButton);
        frame.setSize(300, 350);
        frame.setVisible(true);

        // Handle window closing event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new AWTControlsExample();
    }
}
