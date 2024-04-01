import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomButton extends JButton {
    public CustomButton(){
        setOpaque(false);
        setContentAreaFilled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFont(new Font("Montserrat", Font.BOLD, 24));
        setBorder(new EmptyBorder(20,3,20,3));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = getWidth();
        int height = getHeight();
        g2.setStroke(new BasicStroke(3));
        g2.setColor(new Color(45,45,45));
        g2.drawRoundRect(2,2, width-5, height-5, 75, 75);
        g2.dispose();
    }
}
