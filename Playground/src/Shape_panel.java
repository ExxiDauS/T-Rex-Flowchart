import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
public class Shape_panel extends JPanel implements MouseListener{
    private static Processing_Shape process;
    private static Input_Shape input;
    private static Output_Shape output;
    private static Decision_Shape decision;
    public Shape_panel(){
        process = new Processing_Shape();
        input = new Input_Shape();
        output = new Output_Shape();
        decision = new Decision_Shape();
        process.addMouseListener(this);
        input.addMouseListener(this);
        output.addMouseListener(this);
        decision.addMouseListener(this);
        process.setBounds(40, 10, 101, 51);
        this.add(process);
        input.setBounds(30, 80, 120, 45);
        this.add(input);
        output.setBounds(35,150,120, 45);
        this.add(output);
        decision.setBounds(50, 210, 82, 82);
        this.add(decision);        
    }
    public void checkClicked(Object o){
        if (process.IsClicked() & !o.equals(process)){
            process.paintWhenClicked();
        }else if(input.IsClicked()& !o.equals(input)){
            input.paintWhenClicked();
        }else if(output.IsClicked()& !o.equals(output)){
            output.paintWhenClicked();
        }else if(decision.IsClicked()& !o.equals(decision)){
            decision.paintWhenClicked();
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(process)){
            checkClicked(e.getSource());
            process.paintWhenClicked();
        }else if(e.getSource().equals(input)){
            checkClicked(e.getSource());
            input.paintWhenClicked();
        }else if(e.getSource().equals(output)){
            checkClicked(e.getSource());
            output.paintWhenClicked();
        }else if(e.getSource().equals(decision)){
            checkClicked(e.getSource());
            decision.paintWhenClicked();
        }
        this.repaint();        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(process)){
            process.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if(e.getSource().equals(input)){
            input.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if(e.getSource().equals(output)){
            output.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if(e.getSource().equals(decision)){
            decision.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }        
    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    public static Processing_Shape getProcess(){
        return process;
    }
    public static Input_Shape getInput(){
        return input;
    }
    public static Output_Shape getOutput(){
        return output;
    }
    public static Decision_Shape getDecision(){
        return decision;
    }
}
