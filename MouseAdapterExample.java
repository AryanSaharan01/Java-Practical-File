import java.awt.*;
import java.awt.event.*;

public class MouseAdapterExample {
    private Frame frame;

    public MouseAdapterExample() {
        frame = new Frame("Mouse Adapter Example");

        // Register a MouseAdapter for the frame
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked at: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse Pressed at: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse Released at: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse Entered the frame.");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse Exited the frame.");
            }
        });

        frame.setSize(400, 300);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new MouseAdapterExample();
    }
}
