import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.HashSet;

public abstract class Shape extends JPanel implements Serializable{
    protected Dimension parentSize;
    public Shape() {
        setOpaque(false);
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Montserrat-Thin.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Montserrat-Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Montserrat-Regular.ttf")));
        }
        catch(IOException|FontFormatException e) {
            e.printStackTrace();
        }
    }
    public void convertToCode(File f, HashSet<String> variablePool) {}
    public void drawCenteredString(Graphics2D g2, String text, Rectangle rect, Font f) {
        FontMetrics metrics = g2.getFontMetrics();
        int x = rect.x + (((int)rect.getWidth() - metrics.stringWidth(text)) / 2)-2;
        int y = rect.y + (((int)rect.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent()-2;
        g2.setFont(f);
        g2.drawString(text, x, y);
    }

}
