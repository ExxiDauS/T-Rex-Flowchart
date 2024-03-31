import java.awt.*;
import javax.swing.*;

public class ArrowComponent extends ActionShape{

    public ArrowComponent() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(new Color(102,102,102));
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(5,0,5,40);
        g2.drawLine(5, 40,10, 35);
        g2.drawLine(5, 40, 0, 35);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10, 40);
    }
}
