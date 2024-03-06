import javax.swing.*;
import java.awt.*;

public class test2 extends JFrame {
    private JButton button1;
    private JButton button2;

    public test2() {
        setTitle("Flowchart Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");

        setLayout(new FlowLayout()); // Consider using a layout manager for better organization

        button1.setBounds(50, 50, 100, 50);
        button2.setBounds(200, 50, 100, 50);

        add(button1);
        add(button2);

        // Ensure ArrowPanel is drawn on top (optional)
        add(new ArrowPanel(button1, button2));

        setVisible(true);
    }

    public static void main(String[] args) {
        new test2();
    }

    class ArrowPanel extends JPanel {
        private JButton startButton;
        private JButton endButton;

        public ArrowPanel(JButton startButton, JButton endButton) {
            this.startButton = startButton;
            this.endButton = endButton;
            setOpaque(false); // Make panel transparent
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Point start = startButton.getLocation();
            Point end = endButton.getLocation();

            // Calculate coordinates using button centers
            int centerX1 = start.x + startButton.getWidth() / 2;
            int centerY1 = start.y + startButton.getHeight() / 2;
            int centerX2 = end.x + endButton.getWidth() / 2;
            int centerY2 = end.y + endButton.getHeight() / 2;

            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.RED);
            g2d.drawLine(centerX1, centerY1, centerX2, centerY2);
        }
    }
}
