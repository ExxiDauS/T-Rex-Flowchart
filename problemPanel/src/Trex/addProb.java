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
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.net.*;
import java.beans.*;

/**
 *
 * @author User
 */
public class addProb{
    private JFrame frame, previewFrame;
    private JPanel textInputContainer, nameInpPanel, imageInpPanel, descriptionInpPanel, previewPanel, casesPanel, casesField;
    private JLabel nameLB, imgLB, img, discriptLB, casesLB;
    private JTextField nameField, discriptionField, imageField, Field;
    private JTextArea descriptionArea;
    private ArrayList<cases> allCase = new ArrayList<>();
    private String titleName, imgUrl, discription;
    
    public addProb(){
        frame = new JFrame();
        
        frame.setSize(1024, 600);
        System.out.println(frame.getWidth());
        frame.setLayout(new BorderLayout());
        textInputContainer = new JPanel();
        textInputContainer.setLayout(new BoxLayout(textInputContainer, BoxLayout.Y_AXIS));
//        textInputContainer.setLayout(new GridLayout(4,2));

        nameInpPanel = new JPanel();        imageInpPanel = new JPanel();
        descriptionInpPanel = new JPanel();     previewPanel = new JPanel();

        nameInpPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));        imageInpPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        descriptionInpPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        
        nameLB = new JLabel("Problem name : ");
        nameLB.setName("nameLabel");
        nameInpPanel.add(nameLB);
        nameLB.setPreferredSize(new Dimension(100, nameLB.getPreferredSize().height));
                
        nameField = new JTextField();       nameField.setPreferredSize(new Dimension((frame.getWidth() / 2 ) - 100, nameField.getPreferredSize().height));
        nameField.getDocument().addDocumentListener(myOwnDocListener());
//        nameField.addPropertyChangeListener("text", propertyChangeListener);
        
        nameInpPanel.add(nameField);
//        nameInpPanel.setBackground(Color.red);
        textInputContainer.add(nameInpPanel);
        
        imageField = new JTextField();
        imgLB = new JLabel("Image url : ");
        imgLB.setPreferredSize(new Dimension(100, imgLB.getPreferredSize().height));
        
        imageField.setPreferredSize(new Dimension((frame.getWidth() / 2 ) - 100, imageField.getPreferredSize().height));
        imageInpPanel.add(imgLB);      imageInpPanel.add(imageField);
        
        textInputContainer.add(imageInpPanel);
//        imageField.addActionListener(this);
        imageField.getDocument().addDocumentListener(myOwnDocListener());
        
        discriptLB = new JLabel("Discription : ");
        descriptionArea = new JTextArea();
        
        descriptionArea.getDocument().addDocumentListener(myOwnDocListener());
        descriptionArea.setPreferredSize(new Dimension(frame.getWidth() / 2 , 200));
        descriptionInpPanel.add(discriptLB);      descriptionInpPanel.add(descriptionArea);
        textInputContainer.add(descriptionInpPanel);
       
        casesLB = new JLabel("Cases : ");
        
        casesField = new CaseForAdd(null);
 
        caseUpdate(casesField);
        
        casesPanel = new JPanel();
        casesPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        
//        casesField.getDocument().addDocumentListener(myOwnDocListener());
        casesField.setPreferredSize(new Dimension(frame.getWidth() / 2 , 200));
        casesPanel.add(casesLB );      casesPanel.add(casesField);
        textInputContainer.add(casesPanel);
        
        previewPanel = setPre("\"Problem name here\"", "../problemPanel/src/Trex//images/1-10.jpg",
                "\"Discription here\"", allCase);
        
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
        
        previewPanel.removeAll();
        previewPanel.add(setPre(name, imgUrl, description, allCase));
        previewPanel.revalidate();
        previewPanel.repaint();
    }
//    public void updateLabel(){
//        String name = nameField.getText();
//        previewPanel.getName();
//    }
//    
    
    public void caseUpdate(JPanel casesField){
        Component[] component = casesField.getComponents();
        int walk = 0;
        for (Component i : component) {
            System.out.println(i.getClass());
            if (i instanceof Container){
                if (i instanceof JPanel){
                    caseUpdate((JPanel)i);
                }
            }else if(i instanceof JTextArea){
                System.out.println("TF");
            }
            
        }
    };
    
//    private PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {
//        @Override
//        public void propertyChange(PropertyChangeEvent evt) {
//            if ("text".equals(evt.getPropertyName())) {
//                updatePreview();
//            }
//        }
//    };
//    
    
}
