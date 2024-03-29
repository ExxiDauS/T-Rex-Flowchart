import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import  javax.swing.*;
public class Decision_Shape_Flowchart extends ShapeForFlowchart implements MouseListener, KeyListener {
    private LeftArrowComponent left;
    private RightArrowComponent right;
    private boolean clicked;
    private Flowchart_panel f;
    private int yPosition;
    private int xPosition;
//    public Decision_Shape_Flowchart(){
//        super();
//        setLayout(null);
//        clicked = false;
//        left = new LeftArrowComponent(this);
//        right = new RightArrowComponent(this);
//        add(left);
//        add(right);
//        xPosition = 0;
//        yPosition = 0; 
//    }
    public Decision_Shape_Flowchart(Flowchart_panel f){
        this.f = f;
        clicked = false;
        left = new LeftArrowComponent(this);
        right = new RightArrowComponent(this);
        add(left);
        add(right);
        xPosition = 0;
        yPosition = 0; 
        addMouseListener(this);
        addKeyListener(this);
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
        super.paintComponent(g);
        setBackground(Color.WHITE);
        Graphics2D g2 = (Graphics2D)g; // cast เพื่อใช้ Java2D
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int[] xPoints = {xPosition + 40 + 60, xPosition+80 +60 , xPosition + 40 +60 , xPosition +60};
        int[] yPoints = {yPosition, yPosition + 40, yPosition+80, yPosition+40};
        if(!clicked){
        g2.setColor(Color.BLACK);
        }else{
        g2.setColor(Color.red);
        }
        g2.drawPolygon(xPoints, yPoints, 4);
        g2.drawLine(xPosition+80 +60, yPosition + 40, xPosition+80 +60 + 50, yPosition + 40);
        g2.drawLine(xPosition +60, yPosition + 40, xPosition +60 - 50, yPosition + 40);
        left.setBounds(xPosition +60 - 55, yPosition + 40, 10, 62);
        right.setBounds(xPosition+80 +60 + 45, yPosition + 40, 10, 62);
        g2.drawLine(xPosition +60 - 50, yPosition + 40 + 60, xPosition+80 +60 + 50, yPosition + 40 + 60);
        if(!clicked){
            g2.setColor(Color.BLACK);
        }else{
            g2.setColor(Color.red);
        }
        g2.drawString("Condition", xPosition+78, yPosition+45);
}
//    public static void main(String[] args) {
//        JFrame fr = new JFrame();
//        JPanel panel = new JPanel();
//        Decision_Shape_Flowchart input = new Decision_Shape_Flowchart();
//        panel.add(input);
//        fr.add(panel);
//        fr.pack(); // ปรับขนาดของ JFrame ให้พอดีกับขนาดของ JPanel
//        fr.setVisible(true);
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 100); // กำหนดขนาดของ Processing_Shape
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        paintWhenClicked();
        f.repaint();
        ArrayList<ShapeForFlowchart> a = f.getOrder();
        left.paintWhenClicked();
        right.paintWhenClicked();
        for(ShapeForFlowchart o: a){
            if (!o.equals(this)){
                if (o.IsClicked()){
                    o.paintWhenClicked();
                    if (o.getClass().getName().equals("Decision_Shape_Flowchart")){
                        ((Decision_Shape_Flowchart)o).getLeft().paintWhenClicked();
                        ((Decision_Shape_Flowchart)o).getRight().paintWhenClicked();
                    }
                    f.repaint();
                }
            }
        }
        requestFocus();
    }
    public LeftArrowComponent getLeft(){
        return left;
    }
    public RightArrowComponent getRight(){
        return right;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {       
    if (e.getKeyCode() == KeyEvent.VK_DELETE) {
        f.deleteDecisionShape(this);
    }        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
