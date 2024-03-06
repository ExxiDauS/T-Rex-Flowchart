import java.awt.*;
import javax.swing.*;

public class ArrowComponent extends JComponent {
    private JButton startButton;
    private JButton endButton;

    public ArrowComponent(JButton startButton, JButton endButton) {
        this.startButton = startButton;
        this.endButton = endButton;
    }

    public ArrowComponent() {
        this(null, null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLACK);

        int startX = startButton.getX() + startButton.getWidth() / 2;
        int startY = startButton.getY();
        int endX = endButton.getX() + endButton.getWidth() / 2;
        int endY = endButton.getY() + endButton.getHeight() / 2;

        g2d.drawLine(startX, startY, endX, endY);

        int arrowSize = 10;
        double angle = Math.atan2(endY - startY, endX - startX);
        int x1 = (int) (endX - arrowSize * Math.cos(angle - Math.PI / 6));
        int y1 = (int) (endY - arrowSize * Math.sin(angle - Math.PI / 6));
        int x2 = (int) (endX - arrowSize * Math.cos(angle + Math.PI / 6));
        int y2 = (int) (endY - arrowSize * Math.sin(angle + Math.PI / 6));

        g2d.drawLine(endX, endY, x1, y1);
        g2d.drawLine(endX, endY, x2, y2);
    }
}
