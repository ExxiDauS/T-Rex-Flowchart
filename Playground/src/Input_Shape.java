import java.awt.*;
import javax.swing.*;
public class Input_Shape extends ShapeForFlowchart {
    private int xPosition;
    private int yPosition;
    private boolean clicked;
    
    public Input_Shape(){
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
//        Stroke oldStroke = g2.getStroke();
//        g2.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int[] xPoints = {xPosition, xPosition + 20, xPosition + 120, xPosition + 100};
        int[] yPoints = {yPosition + 40, yPosition, yPosition, yPosition+40};

        if(!clicked){
            g2.setColor(Color.BLACK);
        }else{
            g2.setColor(Color.red);
        }
        g2.drawPolygon(xPoints, yPoints, 4);
        g2.setStroke(new BasicStroke(2));
//        g2.setStroke(oldStroke);
//        int[] xPoints2 = {xPosition+1, xPosition + 21, xPosition + 119, xPosition + 99};
//        int[] yPoints2 = {yPosition + 39, yPosition+3, yPosition+3, yPosition+39};
//        g2.setColor(Color.WHITE);
//        g2.fillPolygon(xPoints2, yPoints2, 4);
        Font f = new Font("Arial", Font.PLAIN, 13);
        g2.setFont(f);
        if(!clicked){
            g2.setColor(Color.BLACK);
        }else{
            g2.setColor(Color.red);
        }
        g2.drawString("Input", xPosition+43, yPosition+27);
        
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 45); // กำหนดขนาดของ Processing_Shape
    }
//        public static void main(String[] args) {
//        JFrame fr = new JFrame();
//        JPanel panel = new JPanel();
//        Input_Shape input = new Input_Shape();
//        panel.add(input);
//        fr.add(panel);
//        fr.pack(); // ปรับขนาดของ JFrame ให้พอดีกับขนาดของ JPanel
//        fr.setVisible(true);
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
}
