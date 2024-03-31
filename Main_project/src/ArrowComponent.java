import java.awt.*;
import javax.swing.*;

public class ArrowComponent extends ActionShape{
    private int arrowHeight;

    public ArrowComponent() {
        this(80);
    }

    public ArrowComponent(int arrowHeight) {
        super();
        this.arrowHeight = arrowHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(new Color(102,102,102));
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(5,0,5,(arrowHeight/2)-10);

        g2.drawLine(5, ((arrowHeight/2)-4), 5, ((arrowHeight/2)+4));
        g2.drawLine(1, (arrowHeight/2), 9, (arrowHeight/2));

        g2.drawLine(5,(arrowHeight/2)+10,5,arrowHeight);
        g2.drawLine(5, arrowHeight,10, arrowHeight-5);
        g2.drawLine(5, arrowHeight, 0, arrowHeight-5);
    }

    public void setArrowHeight(int arrowHeight) {
        this.arrowHeight = arrowHeight;
        setSize(new Dimension(10, arrowHeight+1));
        repaint();
    }

    public int getArrowHeight() {
        return arrowHeight;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10, arrowHeight);
    }
}
