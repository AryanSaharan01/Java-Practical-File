import java.awt.*;
import java.awt.event.*;

public class AWTControlsEventsExample {
    private Frame frame;
    private Label label;
    private Button button;
    private CheckboxGroup checkboxGroup;
    private Checkbox checkbox1, checkbox2;

    public AWTControlsEventsExample() {
        frame = new Frame("AWT Controls Events Example");

        // Label control
        label = new Label("Select an option:");
        label.setBounds(20, 50, 150, 30);

        // CheckboxGroup and Checkbox controls
        checkboxGroup = new CheckboxGroup();
        checkbox1 = new Checkbox("Option 1", checkboxGroup, false);
        checkbox1.setBounds(50, 100, 100, 30);
        checkbox2 = new Checkbox("Option 2", checkboxGroup, false);
        checkbox2.setBounds(50, 150, 100, 30);

        // Button control
        button = new Button("Submit");
        button.setBounds(50, 200, 80, 30);

        // Add ItemListener to the checkboxes
        ItemListener checkboxListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selectedOption = ((Checkbox) e.getItem()).getLabel();
                System.out.println("Selected option: " + selectedOption);
            }
        };

        checkbox1.addItemListener(checkboxListener);
        checkbox2.addItemListener(checkboxListener);

        // Add ActionListener to the Button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = checkboxGroup.getSelectedCheckbox().getLabel();
                System.out.println("Selected option: " + selectedOption);
            }
        });

        frame.setLayout(null);
        frame.add(label);
        frame.add(checkbox1);
        frame.add(checkbox2);
        frame.add(button);
        frame.setSize(250, 300);
        frame.setVisible(true);

        // Handle window closing event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new AWTControlsEventsExample();
    }
}
