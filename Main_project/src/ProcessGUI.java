import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
public class ProcessGUI extends ShapeGUI{
    private JLabel process, variable, statement;
    private JPanel bag, varGrid, statementGrid, panel1, panel2;
    private CustomTextField varInp, statementInp;

    public ProcessGUI(ActionShape host){
        this.host = host;
        frame = new JFrame();
        process = new JLabel("  Process:");
        variable = new JLabel("Variable:");
        statement = new JLabel("Statement:");
        doneBtn = new DoneCustomButton();
        varInp = new CustomTextField();
        statementInp = new CustomTextField();
        bag = new JPanel(new GridBagLayout());
        varGrid = new JPanel(new GridLayout(2, 1));
        statementGrid = new JPanel(new GridLayout(2, 1));
        panel1 = new JPanel(new GridLayout(1, 2));
        panel2 = new JPanel(new GridLayout(1, 2));

        frame.setLayout(new BorderLayout());
        doneBtn.setText("Done");
        doneBtn.setForeground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();

        process.setFont(new Font("Montserrat", Font.BOLD, 24));
        process.setForeground(new Color(255, 193, 7));

        variable.setFont(new Font("Montserrat", Font.PLAIN, 18));
        variable.setForeground(new Color(0, 64, 128));
        statement.setFont(new Font("Montserrat", Font.PLAIN, 18));
        statement.setForeground(new Color(0, 64, 128));

        variable.setHorizontalAlignment(JTextField.LEFT);
        panel1.add(variable);
        panel1.add(new JLabel("  "));
        varGrid.add(panel1);
        varGrid.add(varInp);

        statement.setHorizontalAlignment(JTextField.LEFT);
        panel2.add(statement);
        panel2.add(new JLabel("  "));
        statementGrid.add(panel2);
        statementGrid.add(statementInp);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        bag.add(varGrid, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 60, 0);
        bag.add(statementGrid, gbc);
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        bag.add(doneBtn, gbc);

        frame.add(process, BorderLayout.NORTH);
        frame.add(bag, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setIconImage(img.getImage());
        frame.setSize(300, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    public CustomTextField getVarInp() {
        return varInp;
    }

    public CustomTextField getStatementInp() {
        return statementInp;
    }

    @Override
    public void configShape() {
        System.out.println("Process Config");
    }
}
