/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trex;
import Trex.cases;
import Trex.problem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.net.*;


/**
 *
 * @author User
 */
public class problemFrame implements ActionListener, MouseListener{
    private JFrame frame;
    private JPanel showProb, probLst, dropClose;
    private JButton btn;
    private cases case1 = new cases("sssssssssssssssssssssssssssssssssssssssssssssssss\nssssssss", "3");
    private cases case2 = new cases("1", "2");
    // {new cases("hey", "ha")}
    
    private problem[] problemLst = {new problem("DebtCalculation", 
            "../problemPanel/src/Trex/images/1-10.jpg",
    "Ni ai wo wo ai ni\n" +
    "Mi xue bing cheng tianmi mi\n" +
    "Ni ai wo wo ai ni\n" +
    "Mi xue bing cheng tianmi mi\n"
  ,  new cases[]{case1, case2}),
    new problem("Tim", "../problemPanel/src/Trex/images/v6wirw3s76g91.jpg","jekjek\nasdsdsad",  new cases[]{case1, case2}),
    new problem("T$E", 
 "14255",
    "jekjek",  new cases[]{case1, case2})
    };
    
    private int selectProb = 1;
    private JPanel titlePanel, imgPanel, desHPanel, descriptionPanel, sampleTestPanel, testCasePanel;
    private JLabel title, img, desH, description, sampleTest;
    private JTable testCase;
    DefaultTableModel tModel;
    private problem current;
    private Border roundBorder;
    private JLabel closeAroow;
    
    public problemFrame(){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setBackground(new java.awt.Color(217, 217, 217));
        
        showProb = new JPanel();
        showProb.setLayout(new BoxLayout(showProb, BoxLayout.Y_AXIS));
        
        dropClose = new JPanel();
        dropClose.setLayout(new BorderLayout());
        dropClose.setPreferredSize(new Dimension(25, 600));
        
        closeAroow = new JLabel(">");
        closeAroow.setHorizontalAlignment(JLabel.CENTER);
        dropClose.add(closeAroow, BorderLayout.CENTER);
        dropClose.addMouseListener(this);
        
//        set container
        titlePanel = new JPanel();      titlePanel.setLayout(new FlowLayout(10, 25, 10));
        
        imgPanel = new JPanel();        imgPanel.setLayout(new FlowLayout( 10, 25, 10));
        
        desHPanel = new JPanel();       desHPanel.setLayout(new FlowLayout(10, 25, 10));
       
        descriptionPanel = new JPanel();        descriptionPanel.setLayout(new FlowLayout(10, 40, 7));
        
        sampleTestPanel = new JPanel();     sampleTestPanel.setLayout(new FlowLayout(10, 25, 10));
        
        testCasePanel = new JPanel();       testCasePanel.setLayout(new FlowLayout(10, 40, 10));
        
        current = problemLst[selectProb - 1];
        
        //      set Column name
        testCase = new JTable();
        
        roundBorder = new LineBorder(Color.black, 1, true);
        
        tModel = (DefaultTableModel)testCase.getModel();
        tModel.setColumnIdentifiers(new String[]{"Input", "Output"});
        testCase.setBorder(roundBorder);

//        testCase.getModel(tModel);
//        testCase.getColumnModel().getColumn(0).setHeaderValue("New Name");
//        testCase.getColumnModel().getColumn(1).setHeaderValue("New Name");

        DefaultTableCellRenderer leftAlign = new DefaultTableCellRenderer();
        leftAlign.setHorizontalAlignment(SwingConstants.LEFT);
        leftAlign.setVerticalAlignment(SwingConstants.TOP); // Align to the top
        testCase.setDefaultRenderer(Object.class, leftAlign);
        
        
//      ** make Showing Panel (Left side) **
        setShowPanel(current);
        
        probLst = new JPanel();
        probLst.setPreferredSize(new Dimension(50,600));
//        probLst.setBackground(Color.green);
        
//        Scrollbar
        JScrollPane scrollPanel = new JScrollPane(showProb);
//        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar vScrollBar = scrollPanel.getVerticalScrollBar();
        vScrollBar.setUnitIncrement(40);
        vScrollBar.setBlockIncrement(10);
        frame.add(scrollPanel, BorderLayout.CENTER);
        
        ArrayList<Integer> myVariables = new ArrayList<>();
        for (int i=0; i < problemLst.length;i++){
            btn = new JButton(i+1+"");
            btn.addActionListener(this);
            probLst.add(btn);
            System.out.println(btn.getText());

        }
//        add from setShowPanel (For avoid thw bug)
        
        // add to Frame        
//        frame.add(showProb, BorderLayout.CENTER);
        frame.add(dropClose, BorderLayout.WEST);
        frame.add(probLst,BorderLayout.EAST);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    public void setShowPanel(problem current){

        System.out.println(current.getTitleName());
        title = new JLabel(current.getTitleName());
        title.setFont(new Font(null, Font.PLAIN, 30));
        
        titlePanel.add(title);          showProb.add(titlePanel);

        
//        showProb.add(title, FlowLayout.LEFT);
        try{
//            BufferedImage image = ImageIO.read(new File(current.getImg()));
            URL url = new URL(current.getImg());
            BufferedImage image = ImageIO.read(url);
            img = new JLabel(new ImageIcon(image));
            img.setPreferredSize(new Dimension(875, 425));
            imgPanel.add(img);      showProb.add(imgPanel);
            
        }catch (IOException ex){
            try{
            BufferedImage image = ImageIO.read(new File("../problemPanel/src/Trex//images/1-10.jpg"));
//            URL url = new URL("https://i0.wp.com/learn.onemonth.com/wp-content/uploads/2017/08/1-10.png?fit=845%2C503&ssl=1");
//            BufferedImage image = ImageIO.read(url);
            img = new JLabel(new ImageIcon(image));
            img.setPreferredSize(new Dimension(875, 425));
            imgPanel.add(img);      showProb.add(imgPanel);
            
            }catch (Exception e){
                System.out.println("404");
            }
            System.out.println("404");
        }
        
        desH = new JLabel("Problems Discription");     desH.setFont(new Font(null, Font.PLAIN, 27));
        desHPanel.add(desH);        showProb.add(desHPanel);
        
        description = new JLabel(strManage(current.getDescription()));     description.setFont(new Font(null, Font.PLAIN, 18));
        descriptionPanel.add(description);      showProb.add( descriptionPanel);
        
        sampleTest = new JLabel("Sample Testcase");     sampleTest.setFont(new Font(null, Font.PLAIN, 27));
        sampleTestPanel.add(sampleTest);        showProb.add(sampleTestPanel);
        
        testCase.setRowHeight(100);
        
        for (int i=0; i < current.getTestCase().length; i++){
            tModel.addRow(new Object[]{strManage(current.getTestCase()[i].getInput()), strManage(current.getTestCase()[i].getOutput())});
            testCase.getColumnModel().getColumn(i).setPreferredWidth(425);
        }   
        testCasePanel.add(testCase);        showProb.add(testCasePanel);  
        
    }
    
    public String strManage(String str){
        return "<html>" + str.replaceAll("\n", "<br>") + "</html>";
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
//        if (ae.getSource().equals(btn)){
//            titlePanel.removeAll();
//            imgPanel.removeAll();
//            desHPanel.removeAll();
//            descriptionPanel.removeAll();
//            sampleTestPanel.removeAll();
//            testCasePanel.removeAll();
//        
//            // Clear table model
//            tModel.setRowCount(0);
//            
//            setShowPanel(problemLst[Integer.parseInt(btn.getText())-1]);
//            showProb.revalidate();
//
//        }
        if (ae.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) ae.getSource();
            int selected = Integer.parseInt(clickedButton.getText()) - 1;
//            System.out.println(titlePanel.getSize());
     
//          Clear previous components (Panels)
            titlePanel.removeAll();
            imgPanel.removeAll();
            desHPanel.removeAll();
            descriptionPanel.removeAll();
            sampleTestPanel.removeAll();
            testCasePanel.removeAll();
            showProb.removeAll();

//          Clear all previous table's rows
            tModel.setRowCount(0);
            
//          Make smoother Maybe?
            showProb.revalidate();
            
//            Rebuild probPanel
            setShowPanel(problemLst[selected]);
            
            JScrollBar scrollValue = ((JScrollPane) showProb.getParent().getParent()).getVerticalScrollBar();
            scrollValue.setValue(0);
            
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {}
    
    @Override
    public void mousePressed(MouseEvent me) {}
    
    @Override
    public void mouseReleased(MouseEvent me) {}
    
    @Override
    public void mouseExited(MouseEvent me) {
        dropClose.setBackground(null);
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
        dropClose.setBackground(new java.awt.Color(200,200,200));
    }
}