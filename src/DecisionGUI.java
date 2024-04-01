import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
public class DecisionGUI extends ShapeGUI{
    private JLabel decision, condition;
    private JPanel bag, varGrid, panel1;
    private CustomTextField conditionInp;

    public DecisionGUI(ActionShape host){
        this.host = host;
        frame = new JFrame();
        decision = new JLabel("  Decision:");
        condition = new JLabel("Condition:   ");
        doneBtn = new DoneCustomButton();
        conditionInp = new CustomTextField();
        bag = new JPanel(new GridBagLayout());
        varGrid = new JPanel(new GridLayout(2, 1));
        panel1 = new JPanel(new GridLayout(1, 2));

        frame.setLayout(new BorderLayout());
        doneBtn.setText("Done");
        doneBtn.setForeground(Color.white);

        conditionInp.setColumns(32);

        GridBagConstraints gbc = new GridBagConstraints();

        decision.setFont(new Font("Montserrat", Font.BOLD, 24));
        decision.setForeground(new Color(255, 87, 34));

        condition.setFont(new Font("Montserrat", Font.PLAIN, 18));
        condition.setForeground(new Color(0, 64, 128));

        condition.setHorizontalAlignment(JTextField.LEFT);
        panel1.add(condition);
        panel1.add(new JLabel(" "));
        varGrid.add(panel1);
        varGrid.add(conditionInp);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 120, 0);
        bag.add(varGrid, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        bag.add(doneBtn, gbc);

        if (host.isConfigured()) {
            String condition = ((DecisionShape)host).getCondition();
            conditionInp.setText(condition);
        }

        frame.add(decision, BorderLayout.NORTH);
        frame.add(bag, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setIconImage(img.getImage());
        frame.setSize(300, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    @Override
    public void configShape() {
        String condition = conditionInp.getText();
        ((DecisionShape)host).setCondition(condition);
        host.setConfigured(true);
    }
}
