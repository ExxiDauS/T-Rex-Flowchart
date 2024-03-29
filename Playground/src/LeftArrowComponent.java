import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import  javax.swing.*;
import java.util.ArrayList;
public class LeftArrowComponent extends ShapeForFlowchart implements MouseListener{
    private Decision_Shape_Flowchart decision;
    private ArrayList<ShapeForFlowchart> leftOrder;
    private boolean clicked;
    public LeftArrowComponent(Decision_Shape_Flowchart d){
        decision = d;
        leftOrder = new ArrayList<>();
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
        for(ShapeForFlowchart o: leftOrder){
            if (!o.equals(this)){
                if (o.IsClicked()){
                    o.paintWhenClicked();
                    if (o.getClass().getName().equals("Decision_Shape_Flowchart")){
                        ((Decision_Shape_Flowchart)o).getLeft().paintWhenClicked();
                        ((Decision_Shape_Flowchart)o).getRight().paintWhenClicked();
                    }
                    decision.repaint();
                }
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        if(!clicked){
        g.setColor(Color.BLACK);
        }else{
        g.setColor(Color.red);
        }
        g.drawLine(5, 0, 5, 60);
        g.drawLine(5, 60,10, 55);
        g.drawLine(5, 60, 0, 55);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10, 62);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
