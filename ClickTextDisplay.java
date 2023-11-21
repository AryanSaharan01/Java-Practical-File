import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickTextDisplay extends JFrame {

    private String message = "";
    private Color textColor = Color.WHITE;

    public ClickTextDisplay() {
        setTitle("Mouse Click Text Display");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) { // Left mouse button
                    message = "Hello";
                    textColor = Color.RED;
                } else if (e.getButton() == MouseEvent.BUTTON3) { // Right mouse button
                    message = "World";
                    textColor = Color.BLUE;
                }

                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(textColor);
        g.drawString(message, getWidth() / 2 - 20, getHeight() / 2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClickTextDisplay clickTextDisplay = new ClickTextDisplay();
            clickTextDisplay.setVisible(true);
        });
    }
}
