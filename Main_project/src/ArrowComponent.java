import java.awt.*;
import javax.swing.*;

public class ArrowComponent extends JComponent {
    private JButton startButton;

    public ArrowComponent(JButton startButton) {
        this.startButton = startButton;
    }

    public ArrowComponent() {
        this(null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLACK);

        int startX = startButton.getX() + startButton.getWidth() / 2;
        int startY = startButton.getY();

        g2d.drawLine(startX, startY, startX, startY + 110);
        g2d.drawLine(startX + 7, startY + 100, startX, startY + 115);
        g2d.drawLine(startX - 7, startY + 100, startX, startY + 115);

//        int arrowSize = 10;
//        double angle = Math.atan2(endY - startY, endX - startX);
//        int x1 = (int) (endX - arrowSize * Math.cos(angle - Math.PI / 6));
//        int y1 = (int) (endY - arrowSize * Math.sin(angle - Math.PI / 6));
//        int x2 = (int) (endX - arrowSize * Math.cos(angle + Math.PI / 6));
//        int y2 = (int) (endY - arrowSize * Math.sin(angle + Math.PI / 6));
//
//        g2d.drawLine(endX, endY, x1, y1);
//        g2d.drawLine(endX, endY, x2, y2);
    }
}