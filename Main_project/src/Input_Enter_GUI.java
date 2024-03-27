
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Input_Enter_GUI {
    private JFrame frame;
    private JTextField nameField;
    private JComboBox<String> typeComboBox;
    private Input input;

    public Input_Enter_GUI(Input input) {
        this.input = input;

        frame = new JFrame("Enter Data");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        panel.add(nameLabel);

        nameField = new JTextField();
        panel.add(nameField);

        JLabel typeLabel = new JLabel("Type:");
        panel.add(typeLabel);

        String[] types = {"int", "double", "String"};
        typeComboBox = new JComboBox<>(types);
        panel.add(typeComboBox);

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String type = (String) typeComboBox.getSelectedItem();

                // Validate the name
                if (!isValidName(name)) {
                    JOptionPane.showMessageDialog(frame, "Invalid name! Name cannot be numeric or contain illegal characters.");
                    return;
                }

                // Set type and name in input object
                input.setType(type);
                input.setName(name);
                System.out.println("Name: " + input.getName() + ", Type: " + input.getType()); //Check if it's work we will delete it later
                frame.dispose();
            }
        });
        panel.add(enterButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Method to validate name
    private boolean isValidName(String name) {
        // Name cannot be empty
        if (name.isEmpty()) {
            return false;
        }

        // Name cannot be numeric
        if (name.matches("\\d+")) {
            return false;
        }

        // Name cannot contain illegal characters
        if (!name.matches("[a-zA-Z0-9_]+")) {
            return false;
        }

        return true;
    }
}