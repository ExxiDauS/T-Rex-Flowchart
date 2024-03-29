import java.awt.*;

public class OutputShape extends ActionShape{
    private int xPosition;
    private int yPosition;
    private boolean clicked;

    public OutputShape() {
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
        int[] xPoints = {xPosition, xPosition + getWidth()/6, xPosition + getWidth(), xPosition + (getWidth()*5)/6};
        int[] yPoints = {yPosition + (getHeight()*4)/5, yPosition, yPosition, (getHeight()*4)/5};

        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(new Color(33, 150, 243));
        }

        g2.drawPolygon(xPoints, yPoints, 4);
        int[] xPoints2 = {xPosition+1, xPosition + (getWidth()/6)+1, xPosition + (getWidth())-1, xPosition + ((getWidth()*5)/6)-1};
        int[] yPoints2 = {yPosition + (getHeight()*4)/5 - 1, yPosition+1, yPosition+1, yPosition + (getHeight()*4)/5 - 1};
        g2.setColor(Color.WHITE);
        g2.fillPolygon(xPoints2, yPoints2, 4);
        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(new Color(33, 150, 243));
        }

        g2.setFont(f);
        drawCenteredString(g2, "Output", new Rectangle(getWidth(), getHeight()), f);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 50);
    }

}
