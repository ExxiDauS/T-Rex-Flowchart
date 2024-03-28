import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalButtonUI;

public class BarCustomButton extends JButton{
    private Color color;
    public BarCustomButton() {
        setOpaque(false);
        setContentAreaFilled(false);
        setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return getForeground();
            }
        });
        setFont(new Font("Montserrat", Font.BOLD, 20));
        setBorder(new EmptyBorder(5,10,5,10));
        color = new Color(45,45,45);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = getWidth();
        int height = getHeight();
        g2.setColor(color);
        g2.fillRoundRect(0,0, width-1, height-1, 20, 20);
        super.paint(g);
        g2.dispose();
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
