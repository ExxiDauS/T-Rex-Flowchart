/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trex;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;
/**
 *
 * @author User
 */
public class resultFrame {
    private JPanel caseShow;
    private JFrame frame;
    private ArrayList resultAL = new ArrayList(Arrays.asList(true, false, false, true, false, true, true, false, false, true, false, true));
    private JPanel container, containerLay;
    private JLabel status;
    private Font boldFont;
    public resultFrame(){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        for(int i=0; i < resultAL.size();i++){
            System.out.println(resultAL.get(i));
            container.add(block(i, (boolean)resultAL.get(i)));
            container.setBorder(null);
        }
        
        JScrollPane scrollPanel = new JScrollPane(container);
        scrollPanel.setPreferredSize(new Dimension(450, 600));
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar vScrollBar = scrollPanel.getVerticalScrollBar();
        vScrollBar.setUnitIncrement(40);
        vScrollBar.setBlockIncrement(10);

        frame.add(scrollPanel, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    public JPanel block(int number, boolean tf){      
        containerLay = new JPanel();
        containerLay.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 0));
        caseShow = new JPanel();
        caseShow.setPreferredSize(new Dimension(380, 30));
        caseShow.setLayout(new GridLayout(1,2));

        roundBorder block = new roundBorder(10);
        JLabel text = new JLabel("Case "+number+" :");
        if (tf == true){
            status = new JLabel("Pass");
            status.setForeground(Color.white);
            block.setBackground(new java.awt.Color(0, 200, 0));
            block.add(status);
        }else{
            status = new JLabel("Not Pass");
            status.setForeground(Color.white);
            block.setBackground(new java.awt.Color(255, 0, 0));
            block.add(status);
        }

        caseShow.add(text);
        caseShow.add(block);
        
        containerLay.add(caseShow);
        
        
        return  containerLay;
    }
}
