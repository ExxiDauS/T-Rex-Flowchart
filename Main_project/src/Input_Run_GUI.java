import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Input_Run_GUI {
    private JFrame frame;
    private JTextField valueField;
    private Input input;

    public Input_Run_GUI(Input input) {
        this.input = input;

        frame = new JFrame("Run");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel valueLabel = new JLabel("Enter value:");
        panel.add(valueLabel);

        valueField = new JTextField();
        panel.add(valueField);

        JButton runButton = new JButton("Run");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valueString = valueField.getText();
                Object value;
                if (input.getType() == null) {
                    JOptionPane.showMessageDialog(null, "Type is not set.");
                    return;
                }
                if (input.getType().equals("int")) {
                    try {
                        value = Integer.parseInt(valueString);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Entered value is not of type int");
                        return;
                    }
                } else if (input.getType().equals("double")) {
                    try {
                        value = Double.parseDouble(valueString);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Entered value is not of type double");
                        return;
                    }
                } else {
                    value = valueString;
                }
                input.setValue(value); // Set value in shared input object
                if (input.checkValueType()) {
                    System.out.println("Value: " + input.getValue() + " is of type " + input.getType());
                } else {
                    System.out.println("Value: " + input.getValue() + " is not of type " + input.getType());
                }
                frame.dispose();
            }
        });
        panel.add(runButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
