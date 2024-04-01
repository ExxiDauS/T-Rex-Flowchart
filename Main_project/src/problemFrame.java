/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
public class problemFrame extends JInternalFrame implements ActionListener, MouseListener{
    private JPanel showProb, probLst;
    private JButton btn;
    private DatabaseConnect databaseConnect;

    private ArrayList problemLst = new ArrayList();
    
    private int selectProb = 1;
    private JPanel titlePanel, imgPanel, desHPanel, descriptionPanel, sampleTestPanel, testCasePanel;
    private JLabel title, img, desH,description, sampleTest;
    private JTable testCase;
    DefaultTableModel tModel;
    private problem current;
    private Border roundBorder;
    private JLabel closeAroow;
    private int iTmp = 0;
    
    public problemFrame(){
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Thin.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Regular.ttf")));
        }
        catch(IOException|FontFormatException e) {
            e.printStackTrace();
        }
        setLayout(new BorderLayout());
        setBackground(new java.awt.Color(217, 217, 217));
        
        showProb = new JPanel();
        showProb.setLayout(new BoxLayout(showProb, BoxLayout.Y_AXIS));

        
        closeAroow = new JLabel(">");
        closeAroow.setHorizontalAlignment(JLabel.CENTER);
        
        databaseConnect = new DatabaseConnect();

        problemLst = databaseConnect.getAllProblem();
        
//        set container
        titlePanel = new JPanel();      titlePanel.setLayout(new FlowLayout(10, 25, 10));
        
        imgPanel = new JPanel();        imgPanel.setLayout(new FlowLayout( 10, 25, 10));
        
        desHPanel = new JPanel();       desHPanel.setLayout(new FlowLayout(10, 25, 10));
       
        descriptionPanel = new JPanel();        descriptionPanel.setLayout(new FlowLayout(10, 40, 7));
        
        sampleTestPanel = new JPanel();     sampleTestPanel.setLayout(new FlowLayout(10, 25, 10));
        
        testCasePanel = new JPanel();       testCasePanel.setLayout(new FlowLayout(10, 40, 10));
        
        current = (problem) problemLst.get(selectProb - 1);
        
        //      set Column name
        testCase = new JTable();
        testCase.setFont(new Font("Montserrat", Font.PLAIN, 20));
        
        roundBorder = new LineBorder(Color.black, 1, true);
        
        tModel = (DefaultTableModel)testCase.getModel();
        tModel.setColumnIdentifiers(new String[]{"Input", "Output"});
        testCase.setBorder(roundBorder);

        DefaultTableCellRenderer leftAlign = new DefaultTableCellRenderer();
        leftAlign.setHorizontalAlignment(SwingConstants.LEFT);
        leftAlign.setVerticalAlignment(SwingConstants.TOP); // Align to the top
        testCase.setDefaultRenderer(Object.class, leftAlign);

        setShowPanel(current);
        
        probLst = new JPanel();
        probLst.setPreferredSize(new Dimension(50,600));

        JScrollPane scrollPanel = new JScrollPane(showProb);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar vScrollBar = scrollPanel.getVerticalScrollBar();
        vScrollBar.setUnitIncrement(40);
        vScrollBar.setBlockIncrement(10);

        add(scrollPanel, BorderLayout.CENTER);
        
        ArrayList<Integer> myVariables = new ArrayList<>();
        for (int i=0; i < problemLst.size();i++){
            btn = new JButton(i+1+"");
            btn.setFont(new Font("Montserrat", Font.BOLD, 20));
            btn.setBackground(new Color(51,51,51));
//            btn.setForeground(new Color(255,255,255));
            btn.addActionListener(this);
            probLst.add(btn);
            System.out.println(btn.getText());

        }
//        add from setShowPanel (For avoid thw bug)


        add(probLst,BorderLayout.EAST);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    public void setShowPanel(problem current){

        System.out.println(current.getTitleName());
        title = new JLabel(current.getTitleName());
        title.setFont(new Font("Montserrat", Font.BOLD, 48));
        
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
            BufferedImage image = ImageIO.read(new File("Main_project\\src\\picture\\404.jpg"));
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
        
        desH = new JLabel("Problems Discription");     desH.setFont(new Font("Montserrat", Font.BOLD, 32));
        desHPanel.add(desH);        showProb.add(desHPanel);
        
        description = new JLabel(strManage(current.getDescription()));     description.setFont(new Font("Montserrat", Font.PLAIN, 24));
        descriptionPanel.add(description);      showProb.add( descriptionPanel);
        
        sampleTest = new JLabel("Sample Testcase");     sampleTest.setFont(new Font("Montserrat", Font.BOLD, 32));
        sampleTestPanel.add(sampleTest);        showProb.add(sampleTestPanel);
        
        testCase.setRowHeight(125);
        
        for (int i=0; i < current.getTestCase().size(); i++){
            tModel.addRow(new Object[]{strManage(current.getInput(i)), strManage(current.getOutput(i))});
            
        }   
        testCase.getColumnModel().getColumn(0).setPreferredWidth(425);
        testCase.getColumnModel().getColumn(1).setPreferredWidth(425);
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
            setShowPanel((problem) problemLst.get(selected));
            
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
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
    }
}
