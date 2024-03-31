import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Output_GUI extends JFrame {
    private JLabel prompt_L;
    private JTextArea ta;
    private JCheckBox check;
    private JButton done;
    private JPanel prompt_p, btn_p, ta_p, checkbox_p, center_p, south_p;
    private Output output;
    private boolean setted = false;
    
    public Output_GUI(Output output) {
        this.output = output;
        this.setLayout(new BorderLayout());
        prompt_L = new JLabel("Prompt");
        ta = new JTextArea(10, 20);
        check = new JCheckBox("Enter New Line");
        done = new JButton("Done");
        prompt_p = new JPanel(new FlowLayout()); btn_p = new JPanel(new FlowLayout()); ta_p = new JPanel(); checkbox_p = new JPanel(new FlowLayout());
        center_p = new JPanel(new BorderLayout()); south_p = new JPanel(new GridLayout(2, 1));
        
        ta_p.add(ta);
        prompt_p.add(prompt_L);
        checkbox_p.add(check);
        btn_p.add(done);
        
        center_p.add(prompt_p, BorderLayout.NORTH);
        center_p.add(ta_p);
        
        south_p.add(checkbox_p);
        south_p.add(btn_p);
        
        this.add(center_p);
        this.add(south_p, BorderLayout.SOUTH);
        
        //Frame setup
        this.setTitle("Output");
        this.setVisible(true);
        this.setSize(350, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        
        
        
        //addListener
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check.isSelected()) {
                    output.setIsChecked(true);
                }
                output.setPrompt(ta.getText());
                setted = true;
                System.exit(0);
            }
        });
    }
    
    public boolean get_setted() {
        return setted;
    }
}