import java.awt.*;
import javax.swing.*;

public class ProcessShape extends ActionShape{
    private int xPosition;
    private int yPosition;
    private boolean clicked;

    public ProcessShape() {
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Montserrat", Font.PLAIN, 18);

        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(new Color(255, 193, 7));
        }

        g2.drawRoundRect(xPosition, yPosition, getWidth()-1, getHeight()-1, 10, 10);

        g2.setColor(Color.WHITE);
        g2.fillRoundRect(xPosition+1, yPosition+1, getWidth()-3, getHeight()-3, 10, 10);

        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(new Color(255, 193, 7));
        }

        g2.setFont(f);
        drawCenteredString(g2, "Process", new Rectangle(getWidth(), getHeight()), f);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(105, 55);
    }

}
