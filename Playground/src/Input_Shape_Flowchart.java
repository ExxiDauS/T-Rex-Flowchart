import java.awt.*;
import java.awt.event.*;
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
        for(Object o: f.getOrder()){
            if (o.getClass().getName().equals("Input_Shape_Flowchart") & !o.equals(this)){
                Input_Shape_Flowchart pro = (Input_Shape_Flowchart)o;
                if (pro.IsClicked()){
                    pro.paintWhenClicked();
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
