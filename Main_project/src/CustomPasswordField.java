import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomPasswordField extends JPasswordField {
    public CustomPasswordField(){
        setOpaque(false);
        setColumns(22);
        setEchoChar((char)0);
        setFont(new Font("Montserrat", Font.PLAIN, 24));
        setBorder(new EmptyBorder(10, 0, 10, 0));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = getWidth();
        int height = getHeight();
        g2.setColor(Color.BLACK);
        g2.fillRect(2, height - 1, width - 4, 1);
        g2.dispose();
    }
}
