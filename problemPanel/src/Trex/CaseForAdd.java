/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trex;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author User
 */
public class CaseForAdd extends JPanel{
    private JPanel nextBelow, inputContainer, outputContainer, inOutPanel;
    private JPanel below;
    private JTextArea input, output;
    private int widthSize;
    private JPanel parent;
    public CaseForAdd(JPanel below){
      
        inputContainer = new JPanel();      inputContainer.setLayout(new FlowLayout(10,10,10));
        outputContainer = new JPanel();     outputContainer.setLayout(new FlowLayout(10,10,10));
        
        input = new JTextArea();    input.setName("Input");        inputContainer.add(input);
        input.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkField();
            }
        });
        
        output = new JTextArea();    output.setName("Output");   outputContainer.add(output);
        output.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkField();
            }
        });

        
        input.setPreferredSize(new Dimension(230,100));     output.setPreferredSize(new Dimension(230,100));
        inputContainer.add(input);      outputContainer.add(output);
        
        inOutPanel = new JPanel();
        inOutPanel.add(inputContainer);
        inOutPanel.add(outputContainer);
        this.add(inOutPanel);
//        this.setBackground(Color.red);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
    }
    
    public JPanel getBelow(){
        return below;
    }
    
    
    public void setBelow(JPanel next){
        this.below = next;
    }
    
    
    public void checkField() {
        if (!input.getText().isEmpty() || !output.getText().isEmpty() ) {
            makeField();
        }
    }

    public void makeField() {
        if (this.below == null){
            CaseForAdd newTextField = new CaseForAdd(null);
            setBelow(newTextField);
            add(newTextField);
            this.revalidate();
        }        
    }

    
//    public void detectTF(CaseForAdd panel){
//        Component[] compo = panel.getComponents(); 
//        for (Component i : compo) {
//            if (i instanceof Container){
//                detectTF((CaseForAdd) i);
//            }else if(i instanceof JTextField){
//                if (((JTextField) i).getText().equals("") && panel.below != null){
//                    this.removeAll();
//                }
//            }
//        }
//    }
    
//    public JPanel getNextBelow(){
//        return nextBelow;
//    }
//    
//    public boolean getHasBelow(){
//        return hasBelow;
//    }
//    public int getWidthSize(){
//        return widthSize;
//    }
    
}
