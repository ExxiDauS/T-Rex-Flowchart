import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import  javax.swing.*;
public class ArrowComponent extends JPanel implements MouseListener{
    private Flowchart_panel FlowchartForArrow;
    public ArrowComponent(Flowchart_panel f) {
        FlowchartForArrow = f;
        addMouseListener(this);
    }
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
        return new Dimension(10, 38);
    }   
//    public static void main(String[] args) {
//        JFrame fr = new JFrame();
//        JPanel panel = new JPanel();
//        ArrowComponent pro = new ArrowComponent();
//        panel.add(pro);
//        fr.add(panel);
//        fr.pack();
//        fr.setVisible(true);
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
    public void addProcess(MouseEvent e){
        Processing_Shape_Flowchart s = new Processing_Shape_Flowchart(FlowchartForArrow);
        ArrowComponent newArrow = new ArrowComponent(FlowchartForArrow);       
        int index = FlowchartForArrow.getOrder().indexOf(e.getSource());
        FlowchartForArrow.addShape(s, index+1);
        s.setBounds(this.getX() - 45, this.getY() + 41, 101, 53);
        FlowchartForArrow.addShape(newArrow, index+2);
        newArrow.setBounds(this.getX(), this.getY() + 92, 10, 43);
        for(int i = index+3; i < FlowchartForArrow.getOrder().size(); i++){
            JPanel pa = (JPanel)(FlowchartForArrow.getOrder().get(i));
            pa.setLocation(pa.getX(), pa.getY() + 92);
            FlowchartForArrow.checkBoundsAndAdjustPanel(pa);
        }
    }
    public void addInput(MouseEvent e){
        Input_Shape_Flowchart in = new Input_Shape_Flowchart(FlowchartForArrow);
        ArrowComponent newArrow = new ArrowComponent(FlowchartForArrow);       
        int index = FlowchartForArrow.getOrder().indexOf(e.getSource());
        FlowchartForArrow.addShape(in, index+1);
        in.setBounds(this.getX() - 50, this.getY() + 41, 120, 45);
        FlowchartForArrow.addShape(newArrow, index+2);
        newArrow.setBounds(this.getX(), this.getY() + 84, 10, 43);
        for(int i = index+3; i < FlowchartForArrow.getOrder().size(); i++){
            JPanel pa = (JPanel)(FlowchartForArrow.getOrder().get(i));
            pa.setLocation(pa.getX(), pa.getY() + 84);
            FlowchartForArrow.checkBoundsAndAdjustPanel(pa);
        }
    }
    public void addOutput(MouseEvent e){
        Output_Shape_Flowchart in = new Output_Shape_Flowchart(FlowchartForArrow);
        ArrowComponent newArrow = new ArrowComponent(FlowchartForArrow);       
        int index = FlowchartForArrow.getOrder().indexOf(e.getSource());
        FlowchartForArrow.addShape(in, index+1);
        in.setBounds(this.getX() - 50, this.getY() + 41, 120, 45);
        FlowchartForArrow.addShape(newArrow, index+2);
        newArrow.setBounds(this.getX(), this.getY() + 84, 10, 43);
        for(int i = index+3; i < FlowchartForArrow.getOrder().size(); i++){
            JPanel pa = (JPanel)(FlowchartForArrow.getOrder().get(i));
            pa.setLocation(pa.getX(), pa.getY() + 84);
            FlowchartForArrow.checkBoundsAndAdjustPanel(pa);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(Shape_panel.getProcess().IsClicked()){
            addProcess(e);
        }else if(Shape_panel.getInput().IsClicked()){
            addInput(e);
        }else if(Shape_panel.getOutput().IsClicked()){
            addOutput(e);
        }else if(Shape_panel.getDecision().IsClicked()){
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
