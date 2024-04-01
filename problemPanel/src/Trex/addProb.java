/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trex;
import Trex.CaseForAdd;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


/**
 *
 * @author User
 */
public class addProb implements ActionListener{
    private JFrame frame;
    private JPanel textInputContainer, nameInpPanel, imageInpPanel, descriptionInpPanel, previewPanel, casesPanel, casesField, submitPanel;
    private JLabel nameLB, imgLB, img, descriptLB, casesLB;
    private JTextField nameField, imageField;
    private JTextArea descriptionArea;
    private ArrayList<cases> allCase = new ArrayList<>();
    private JButton updateBtn, submitBtn;
    private ArrayList<String> casesStringLst = new ArrayList<>();
    
    public addProb(){
        frame = new JFrame();
        
        frame.setSize(1024, 600);
//        System.out.println(frame.getWidth());
        frame.setLayout(new BorderLayout());
        textInputContainer = new JPanel();
        textInputContainer.setLayout(new BoxLayout(textInputContainer, BoxLayout.Y_AXIS));

//        textInputContainer.setLayout(new GridLayout(4,2));

        nameInpPanel = new JPanel();        imageInpPanel = new JPanel();
        descriptionInpPanel = new JPanel();     previewPanel = new JPanel();

        updateBtn = new JButton("Update Sample Case");
        updateBtn.addActionListener(this);
        
        nameInpPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));        imageInpPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        descriptionInpPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        
        nameLB = new JLabel("Problem name : ");
        nameLB.setName("nameLabel");
        nameInpPanel.add(nameLB);
        nameLB.setPreferredSize(new Dimension(100, nameLB.getPreferredSize().height));
                
        nameField = new JTextField(35);      nameField.setPreferredSize(new Dimension((frame.getWidth() / 2 ) - 100, nameField.getPreferredSize().height));
        nameField.getDocument().addDocumentListener(myOwnDocListener());
//        nameField.addPropertyChangeListener("text", propertyChangeListener);
        
        nameInpPanel.add(nameField);
//        nameInpPanel.setBackground(Color.red);
        textInputContainer.add(nameInpPanel);
        
        imageField = new JTextField(35);
        imgLB = new JLabel("Image url : ");
        imgLB.setPreferredSize(new Dimension(100, imgLB.getPreferredSize().height));
        
        imageField.setPreferredSize(new Dimension((frame.getWidth() / 2 ) - 100, imageField.getPreferredSize().height));
        imageInpPanel.add(imgLB);      imageInpPanel.add(imageField);
        
        textInputContainer.add(imageInpPanel);
//        imageField.addActionListener(this);
        imageField.getDocument().addDocumentListener(myOwnDocListener());
        
        descriptLB = new JLabel("Description : ");
        descriptionArea = new JTextArea(10, 20);
        
        descriptionArea.getDocument().addDocumentListener(myOwnDocListener());
        descriptionArea.setPreferredSize(new Dimension(frame.getWidth() / 2 , 200));
        descriptionInpPanel.add(descriptLB);      descriptionInpPanel.add(descriptionArea);
        textInputContainer.add(descriptionInpPanel);
       
        casesLB = new JLabel("Cases : ");
        casesField = new CaseForAdd(null);
 
        caseUpdate(casesField, null);
//        checkField(casesField);
        
        casesPanel = new JPanel();
        casesPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        
//        casesField.getDocument().addDocumentListener(myOwnDocListener());
        casesField.setPreferredSize(new Dimension(frame.getWidth() / 2 , 200));
        casesPanel.add(casesLB );   casesPanel.add(updateBtn);     casesPanel.add(casesField);
        textInputContainer.add(casesPanel);
       
        
        previewPanel = setPre("\"Problem name here\"", "../problemPanel/src/Trex//images/1-10.jpg",
                "\"Dscription here\"", allCase);
        
        submitPanel = new JPanel();
        
        
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        submitPanel.add(submitBtn);
        textInputContainer.add(submitPanel);
        
        frame.add(textInputContainer, BorderLayout.CENTER);
        frame.add(previewPanel, BorderLayout.EAST);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    } 
    public JPanel setPre(String titleName, String imgUrl, String discription, ArrayList<cases> cases){
        JPanel panel = new Preview(titleName, imgUrl, discription, cases);
        return panel;
    }
    
    public DocumentListener myOwnDocListener(){
        DocumentListener myDocLis = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePreview();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePreview();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePreview();
            }
        };
        return myDocLis;
    }
    
    public void updatePreview() {
        String name = nameField.getText();
        String imgUrl = imageField.getText();
        String description = descriptionArea.getText();
        JPanel panel = setPre(name, imgUrl, description, allCase);
        
        previewPanel.removeAll();
        previewPanel.add(panel);
        previewPanel.revalidate();
        previewPanel.repaint();
    }
//    public void updateLabel(){
//        String name = nameField.getText();
//        previewPanel.getName();
//    }
    
//    public void checkField(Component component) {
//        String[] getText = new String[2];
//        ArrayList<String[]> getField = new ArrayList<>();
//        int count = 1;
//        if (component instanceof CaseForAdd) {
//        CaseForAdd current = (CaseForAdd) component;
//        while (current != null) {
//            Component[] compo = current.getComponents();
//            for (Component i : compo) {
//                if (i instanceof Container) {
//                    getInside((JPanel) i);
//                    
//                }
//            }
//            current = (CaseForAdd) current.getBelow();
//            }
//        }
//    }
//    
//    public String getInside(JPanel panels){
//        Component[] compo = panels.getComponents();
//        for (Component i : compo) {
//            if (i instanceof JTextArea){
//                return ((JTextArea) i).getText();
//                
//            }else
//            if (i instanceof Container) {
//                getInside((JPanel)i);
//            }
//           
//        }
//        return null;
//    }
    
    public void caseUpdate(JPanel casesField,JTextArea tF){
        Component[] component = casesField.getComponents();
//        casesStringLst = new ArrayList<>();
        int count = 0;
        for (Component i : component) {
            if(i instanceof JTextArea){
//                casesStringLst.add(((JTextArea) i).getText());
//                System.out.println("Yes");
//                System.out.println(((JTextArea) i).getText());
                tF = (JTextArea)i;
            }else
            if (i instanceof Container){
                if (i instanceof JPanel){
                    caseUpdate((JPanel) i, tF);
                }
            }
            
        }
        if (tF != null){
            String text = (String)((JTextArea) tF).getText() ;
            casesStringLst.add(text);
        }

    };
    
    @Override
    public void actionPerformed(ActionEvent ae){
        casesStringLst = new ArrayList<>();
        if (ae.getSource().equals(updateBtn)){
            casesStringLst = new ArrayList<>();
            allCase = new ArrayList<>();
            caseUpdate(casesField,null);
            for (int i=0; i < casesStringLst.size(); i += 2){
                if (!(casesStringLst.get(i).isEmpty() && casesStringLst.get(i+1).isEmpty())){
                    cases cases = new cases(casesStringLst.get(i), casesStringLst.get(i+1));
                    allCase.add(cases);
//                    System.out.println(casesStringLst.get(i) +"   and   "+ casesStringLst.get(i+1));
                    
                }
            }
            
        }if(ae.getSource().equals(submitBtn)){
            String name = nameField.getText();
            String imgUrl = imageField.getText();
            String description = descriptionArea.getText();
            System.out.println(name);
            System.out.println(imgUrl);
            System.out.println(description);
            System.out.println(allCase);
        }
        updatePreview();
        
    }
}
