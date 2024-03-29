import javax.swing.*;
import java.awt.*;

public class DecisionShape extends ActionShape{
    private int xPosition;
    private int yPosition;
    private boolean clicked;

    public DecisionShape(Dimension panelSize) {
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
        parentSize = panelSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Montserrat", Font.PLAIN, 18);
        int[] xPoints = {xPosition + getWidth()/2, xPosition + getWidth(), xPosition + getWidth()/2, xPosition};
        int[] yPoints = {yPosition, yPosition + getHeight()/2, yPosition+getHeight(), yPosition+getHeight()/2};

        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(new Color(255,87,34));
        }

        g2.drawPolygon(xPoints, yPoints, 4);
        int[] xPoints2 = {xPosition + getWidth()/2, xPosition + getWidth()-1, xPosition + getWidth()/2, xPosition + 1};
        int[] yPoints2 = {yPosition + 1, yPosition + getHeight()/2, yPosition + getHeight()-1, yPosition + getHeight()/2};
        g2.setColor(Color.WHITE);
        g2.fillPolygon(xPoints2, yPoints2, 4);
        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(new Color(255,87,34));
        }

        g2.setFont(f);
        drawCenteredString(g2, "Condition", new Rectangle(getWidth(), getHeight()), f);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int)parentSize.getHeight()/3, (int)parentSize.getHeight()/3);
    }
}
