import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Processing_Shape_Flowchart extends Processing_Shape implements MouseListener, KeyListener{
    Flowchart_panel f;
    public Processing_Shape_Flowchart(Flowchart_panel f){
        super();
        this.f = f;
        addMouseListener(this);
        addKeyListener(this); 
    }
//    public static void main(String[] args) {
//        JFrame fr = new JFrame();
//        JPanel panel = new JPanel();
//        Processing_Shape_Flowchart pro = new Processing_Shape_Flowchart();
//        panel.add(pro);
//        fr.add(panel);
//        fr.pack(); // ปรับขนาดของ JFrame ให้พอดีกับขนาดของ JPanel
//        fr.setVisible(true);
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }    
    
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        paintWhenClicked();
        f.repaint();
        ArrayList<ShapeForFlowchart> a = f.getOrder();
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
        f.deleteProcessShape(this);
    }        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
