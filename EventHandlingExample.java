import java.awt.*;
import java.awt.event.*;

public class EventHandlingExample {
    private Frame frame;
    private Button button;

    public EventHandlingExample() {
        frame = new Frame("Event Handling Example");
        button = new Button("Click Me");

        // Create an ActionListener to handle the button click event
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");
            }
        });

        // Add the button to the frame
        frame.add(button);
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 100);
        frame.setVisible(true);

        // Handle window closing event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new EventHandlingExample();
    }
}
