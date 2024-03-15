import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Input_Shape_GUI extends JPanel implements MouseListener{
    
    public Input_Shape_GUI(){
        this.addMouseListener(this);
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.drawRect(0, 0, 100, 50);
        
                
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Input_Shape_GUI input = new Input_Shape_GUI();
        frame.add(input);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(105, 55);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Input input = new Input();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
