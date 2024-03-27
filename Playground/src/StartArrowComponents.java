import java.awt.*;
import  javax.swing.*;
public class StartArrowComponents extends JPanel {


    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(5, 0, 5, 40);
        g.drawLine(5, 40,10, 35);
        g.drawLine(5, 40, 0, 35);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10, 40);
    }   
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        JPanel panel = new JPanel();
        StartArrowComponents pro = new StartArrowComponents();
        panel.add(pro);
        fr.add(panel);
        fr.pack();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
