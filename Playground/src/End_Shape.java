import java.awt.*;
import javax.swing.*;
public class End_Shape extends ShapeForFlowchart {
    @Override
    public void paintComponent(Graphics g){
        
        Graphics2D g2 = (Graphics2D)g; // cast เพื่อใช้ Java2D
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Arial", Font.PLAIN, 13);
        g2.setColor(Color.WHITE);
        g2.fillOval(0, 0, 100, 50); // ใช้ตำแหน่ง xPosition และ yPosition
        

        g2.setColor(Color.BLACK);
        g2.drawOval(0, 0, 100, 50);
        
        g2.setFont(f);
        g2.setColor(Color.BLACK);
        g2.drawString("End", 35, 28);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 50); // กำหนดขนาดของ Processing_Shape
    }    
}
