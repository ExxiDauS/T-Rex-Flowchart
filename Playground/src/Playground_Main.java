import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Playground_Main implements ActionListener{
    private JFrame frame;
    private Shape_panel shape_panel;
    private Flowchart_panel flowchart_panel;
    private JMenuBar menu;
    private JMenu m1,m2,m3;
    private JScrollPane scrollForFlowchart;
    private JButton runButton;
//    ที่ต้องทำเพิ่ม การ insert พวก shape ทำ shape อื่นๆ เอาของคนอื่นมาเชื่อม ทำ class แยกที่สืบทอดมาจากคลาสแม่
    
    public Playground_Main(){
        frame = new JFrame("Playground");
        shape_panel = new Shape_panel();
        flowchart_panel = new Flowchart_panel();
        scrollForFlowchart = new JScrollPane(flowchart_panel);
        runButton = new JButton("Run");
        menu = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("About");
        m3 = new JMenu("Help");
        scrollForFlowchart.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollForFlowchart.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollForFlowchart.setBounds(230, 45, 730, 650);
        
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        

        
        frame.setJMenuBar(menu);
        frame.setLayout(null);
        frame.setBounds(220, 20, 1000, 800);
        frame.setResizable(false);
        frame.add(shape_panel);
        frame.add(scrollForFlowchart);
        frame.add(runButton);
        runButton.setBounds(750, 10, 80, 30);
        runButton.addActionListener(this);
        

        flowchart_panel.setLayout(null);
        flowchart_panel.setBounds(230, 45, 730, 650);
        flowchart_panel.setBackground(Color.WHITE);
        flowchart_panel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        flowchart_panel.setAutoscrolls(false);

        
        
        shape_panel.setBounds(30, 45, 200, 450);
        shape_panel.setBackground(Color.WHITE);
        shape_panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 0, Color.black));
        shape_panel.setLayout(null);
 
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }  
    
    
    public static void main(String[] args) {
        new Playground_Main();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        flowchart_panel.run();
    }
}
