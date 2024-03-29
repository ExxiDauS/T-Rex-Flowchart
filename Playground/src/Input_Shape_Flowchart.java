import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Input_Shape_Flowchart extends Input_Shape implements MouseListener, KeyListener {
    Flowchart_panel f;
    public Input_Shape_Flowchart(Flowchart_panel f){
        super();
        this.f = f;
        addMouseListener(this);
        addKeyListener(this); 
    }
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
        f.deleteInputShape(this);
    }        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
