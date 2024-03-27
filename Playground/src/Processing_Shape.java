import java.awt.*;
import javax.swing.*;
public class Processing_Shape extends JPanel{

    private int xPosition;
    private int yPosition;
    private Boolean clicked;

    public Processing_Shape() {
        xPosition = 0;
        yPosition = 0; 
        clicked = false;
    }
    public Boolean IsClicked(){
        return clicked;
    }
    public void paintWhenClicked(){
        clicked = !clicked;
       repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g; // cast เพื่อใช้ Java2D
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);        
        Font f = new Font("Arial", Font.PLAIN, 13);
        
        if(!clicked){
            g2.setColor(Color.BLACK);
        }else{
            g2.setColor(Color.red);
        }
        g2.drawRect(xPosition, yPosition, 100, 50);
         
        g2.setColor(Color.WHITE);
        g2.fillRect(xPosition+1, yPosition+1, 97, 47); // ใช้ตำแหน่ง xPosition และ yPosition        
        
        g2.setFont(f);
        if(!clicked){
            g2.setColor(Color.BLACK);
        }else{
            g2.setColor(Color.red);
        }
        g2.drawString("Processing", xPosition+20, yPosition+28);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(105, 55); // กำหนดขนาดของ Processing_Shape
    }

    public static void main(String[] args) {
        JFrame fr = new JFrame();
        JPanel panel = new JPanel();
        Processing_Shape pro = new Processing_Shape();
        panel.add(pro);
        fr.add(panel);
        fr.pack(); // ปรับขนาดของ JFrame ให้พอดีกับขนาดของ JPanel
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

