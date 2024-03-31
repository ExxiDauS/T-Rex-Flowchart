/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trex;

import Trex.problem;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 *
 * @author User
 */
public class Preview extends JPanel{
//    private JFrame realFrame;
    private JPanel frame, inputPanel;
    private JPanel showProb;
    private JPanel titlePanel, imgPanel, desHPanel, descriptionPanel, sampleTestPanel, testCasePanel;
    private JLabel title, img, desH, description, sampleTest;
    private JTable testCase;
    DefaultTableModel tModel;
    private problem current;
    private Border roundBorder;
    private JLabel closeAroow;
    private String titleName, imgUrl, discription;
    private ArrayList<cases> cases;
    
    public Preview(String titleName, String imgUrl, String discription, ArrayList<cases> cases){
        this.titleName = titleName;
        this.imgUrl = imgUrl;
        this.discription = discription;
        this.cases = cases;
        
//        realFrame = new JFrame()realFrame ;
        frame = new JPanel();
        frame.setLayout(new BorderLayout());
//        frame.setBackground(new java.awt.Color(217, 217, 217));
        
        inputPanel = new JPanel();
        
        this.setLayout(new BorderLayout());
        
        
        showProb = new JPanel();
        showProb.setLayout(new BoxLayout(showProb, BoxLayout.Y_AXIS));
        

        
//        set container
        titlePanel = new JPanel();      titlePanel.setLayout(new FlowLayout(10, 25, 10));
        
        imgPanel = new JPanel();        imgPanel.setLayout(new FlowLayout( 10, 25, 10));
        
        desHPanel = new JPanel();       desHPanel.setLayout(new FlowLayout(10, 25, 10));
       
        descriptionPanel = new JPanel();        descriptionPanel.setLayout(new FlowLayout(10, 40, 0));
        
        sampleTestPanel = new JPanel();     sampleTestPanel.setLayout(new FlowLayout(10, 25, 10));
        
        testCasePanel = new JPanel();       testCasePanel.setLayout(new FlowLayout(10, 40, 10));
        
        //      set Column name
        testCase = new JTable();
        
        JScrollPane scrollTable = new JScrollPane(testCase);
        scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        
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
        
//      ** make Showing Panel (Left side) ** ---------------------------------------------------------
        title = new JLabel(titleName);
        title.setFont(new Font(null, Font.PLAIN, 30));
       
        titlePanel.add(title);          showProb.add(titlePanel);

        
//        showProb.add(title, FlowLayout.LEFT);
        try{
//            BufferedImage image = ImageIO.read(new File(current.getImg()));
            URL url = new URL(imgUrl);
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
        
        description = new JLabel(strManage(discription));     description.setFont(new Font(null, Font.PLAIN, 18));
        descriptionPanel.add(description);      showProb.add( descriptionPanel);
        
        sampleTest = new JLabel("Sample Testcase");     sampleTest.setFont(new Font(null, Font.PLAIN, 27));
        sampleTestPanel.add(sampleTest);        showProb.add(sampleTestPanel);
        
        testCase.setRowHeight(100);
        
        for (int i=0; i < cases.size(); i++){
            tModel.addRow(new Object[]{strManage((cases.get(i)).getInput()), strManage((cases.get(i).getOutput()))});
            testCase.getColumnModel().getColumn(i).setPreferredWidth(425);
            testCase.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//            int frt = (strManageForRowCal(current.getTestCase()[i].getInput()).split("SponkyDonky", -1).length-1);
//            int sec = (strManageForRowCal(current.getTestCase()[i].getOutput()).split("SponkyDonky", -1).length-1);
//            if (frt != 0 || sec != 0){
//                if (frt >= sec){
//                    testCase.setRowHeight(frt*20+20);
//                }else{
//                    testCase.setRowHeight(sec*20+20);
//                }
//            }else{
//                testCase.setRowHeight(40);
//            }
//            testCase.setRowHeight();
        }   
        testCasePanel.add(testCase);        showProb.add(testCasePanel);  
// ---------------------------------------------------------------------------------------------------------------------------
        

//        Scrollbar
        JScrollPane scrollPanel = new JScrollPane(showProb);
//        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        set sensitive
        JScrollBar vScrollBar = scrollPanel.getVerticalScrollBar();
        vScrollBar.setUnitIncrement(40);
        vScrollBar.setBlockIncrement(10);
        
        frame.add(scrollPanel, BorderLayout.CENTER);

//        add from setShowPanel (For avoid thw bug)
        
        // add to Frame        
//        frame.add(showProb, BorderLayout.CENTER);


        frame.setSize(1024/2, 600);
        frame.setVisible(true);
        scaleComponent(frame, 0.5);
        
        
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(frame, BorderLayout.WEST);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 600);
//        this.setResizable(false);
        this.setVisible(true);
 
    }
    
    public String getTiltleName(){
        return titleName;
    }
    public String getimgUrl(){
        return imgUrl;
    }
    public String getDiscription(){
        return discription;
    }
    
    public ArrayList<cases> getCases(){
        return cases;
    }
    
    public void setShowPanel(problem current){

//        System.out.println(current.getTitleName());
        
    }
    
    public String strManage(String str){
        return "<html>" + str.replaceAll("\n", "<br>") + "</html>";
    }
    
    public void scaleComponent(Container panel, double scale){
        int num = 0;
        Component[] compo = panel.getComponents();
        
        for (Component i : compo) {
//            System.out.println("Set");
            Dimension preferSize = i.getPreferredSize();
            int preW = (int)preferSize.getWidth();
            int preH = (int)preferSize.getHeight();
            int weidth = (int)(preW*scale);
            int height = (int) (preH*scale);
            i.setPreferredSize(new Dimension(weidth, height));
            if (i instanceof Container){
                scaleComponent((Container)i, scale);
//                System.out.println("Yes");
            }
            if (i instanceof JLabel){
                if (((JLabel) i).getIcon() instanceof ImageIcon){
                    ImageIcon icon =(ImageIcon)((JLabel) i).getIcon();
                    Image image = icon.getImage();
//                    System.out.println("Image");
                    int weidthImg = (int)((image.getWidth(null))*scale);
                    int heightImg = (int)((image.getHeight(null))*scale);
                    Image resize = image.getScaledInstance(weidthImg, heightImg, Image.SCALE_SMOOTH);
                    ((JLabel)i).setIcon(new ImageIcon(resize));
                }else{
                    Font prefont = i.getFont();
                    int presize = (int)(((prefont).getSize())*scale);
                    i.setFont(new Font(prefont.getName(), prefont.getStyle(), presize));
                    i.setPreferredSize(new Dimension(preW, height));
                }
            }
            if (i instanceof JTable){
                i.setPreferredSize(new Dimension(weidth, height));
                for (int count=0; count< ((JTable) i).getModel().getColumnCount(); count++){
//                    ((JTable) i).getColumn(i).setPreferredWidth(weidth);
                    ((JTable) i).getColumnModel().getColumn(count).setPreferredWidth(weidth);
                    Font preFont = i.getFont();
                    i.setFont(new Font(preFont.getName(), preFont.getStyle(), (int)(preFont.getSize())));
                }
//                for (int count=0; count< ((JTable) i).getModel().getRowCount(); count++){
//                    ((JTable) i).setRo
//                }
//                System.out.println(((JTable) i).getRowCount());
                ((JTable) i).setRowHeight((int)(((JTable) i).getRowHeight()*scale));
            }if (i instanceof JScrollPane){
                i.setPreferredSize(new Dimension(weidth, height));
            }
        }
    }
    
   
}
