import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DoneCustomButton extends JButton {
    public DoneCustomButton(){
        this("");
    }
    public DoneCustomButton(String text){
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFont(new Font("Montserrat", Font.BOLD, 16));
        setBorder(new EmptyBorder(10,0,10,0));
        this.setText(text);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Graphics2D filling = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = getWidth();
        int height = getHeight();
        filling.setColor(new Color(76, 175, 80));
        filling.fillRoundRect(3,3, width-5, height-5, 15, 15);
//        g2.setStroke(new BasicStroke(2));
//        g2.setColor(new Color(45,45,45));
//        g2.drawRoundRect(2,2, width-5, height-5, 15, 15);
        super.paint(g);
        g2.dispose();
        filling.dispose();
    }
}