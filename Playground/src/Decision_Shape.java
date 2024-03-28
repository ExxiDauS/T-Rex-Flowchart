import java.awt.*;
import javax.swing.*;
public class Decision_Shape extends ShapeForFlowchart {
    private int yPosition;
    private int xPosition;
    private boolean clicked;
    
    public Decision_Shape(){
        xPosition = 0;
        yPosition = 0; 
        clicked = false;
    }
    @Override
    public boolean IsClicked(){
        return clicked;
    }
    @Override
    public void paintWhenClicked(){
        clicked = !clicked;
       repaint();
    }
    
     @Override   
    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D)g; // cast เพื่อใช้ Java2D
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int[] xPoints = {xPosition + 40, xPosition+80, xPosition + 40, xPosition};
        int[] yPoints = {yPosition, yPosition + 40, yPosition+80, yPosition+40};
        if(!clicked){
            g2.setColor(Color.BLACK);
        }else{
            g2.setColor(Color.red);
        }
        g2.drawPolygon(xPoints, yPoints, 4);
//        int[] xPoints2 = {xPosition + 40, xPosition+80, xPosition + 41, xPosition};
//        int[] yPoints2 = {yPosition, yPosition + 40, yPosition+81, yPosition+40};     
//        g2.setColor(Color.WHITE);
//        g2.fillPolygon(xPoints2, yPoints2, 4);
//        
        if(!clicked){
            g2.setColor(Color.BLACK);
        }else{
            g2.setColor(Color.red);
        }
        g2.drawString("Condition", xPosition+18, yPosition+45);
    }
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        JPanel panel = new JPanel();
        Decision_Shape input = new Decision_Shape();
        panel.add(input);
        fr.add(panel);
        fr.pack(); // ปรับขนาดของ JFrame ให้พอดีกับขนาดของ JPanel
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(80, 90); // กำหนดขนาดของ Processing_Shape
    }
}
