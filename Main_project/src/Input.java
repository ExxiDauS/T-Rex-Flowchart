import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Input implements Shape, ActionListener{
    
    private String type, name, value;
    
    
    private final JFrame fr;
    private final JLabel value_name, value_amount, value_type;
    private final JTextField name_in, value_in, type_in;
    private final JPanel p, p_name, p_val, p_btn, p_type;
    private final JButton submit;
    public Input() {
        fr = new JFrame("Input");
        fr.setLayout(new GridLayout(2, 1));
        
        value_type = new JLabel(" Type     ");
        value_name = new JLabel("  Name      ");
        value_amount = new JLabel("  Value      ");
        p = new JPanel(new GridLayout(3, 1));
        
        type_in = new JTextField(12);
        name_in = new JTextField(12);
        value_in = new JTextField(12);
        p_name = new JPanel(new BorderLayout());
        p_name.add(value_name);
        p_name.add(name_in, BorderLayout.EAST);
        
        p_val = new JPanel(new BorderLayout());
        p_val.add(value_amount);
        p_val.add(value_in, BorderLayout.EAST);
        
        p_type = new JPanel(new BorderLayout());
        p_type.add(value_type);
        p_type.add(type_in, BorderLayout.EAST);
        
        p_btn = new JPanel();
        submit = new JButton("Submit");
        p_btn.add(submit);
        
        p.add(p_type);
        p.add(p_name);
        p.add(p_val);
        
        
        fr.add(p);
        fr.add(p_btn);
        fr.setSize(250, 200);
        fr.setLocation(700, 300);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(true);
        fr.setVisible(true);
        
        submit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (isDouble(name_in.getText()) == true) {
                JOptionPane.showMessageDialog(fr, "Variable name can't be a number!!");
            }
            else if ((type_in.getText().equals("Int") && isInt(value_in.getText()) == false) || (type_in.getText().equals("Double") && isDouble(value_in.getText()) == false)) {
                           JOptionPane.showMessageDialog(fr, "The value is not related to data type!!");
            }
        }
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public boolean isInt(String num) {
        try {
            Integer.valueOf(num); 
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public boolean isDouble(String num) {
        try {
            Double.valueOf(num); 
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    @Override
    public void convertToCode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}