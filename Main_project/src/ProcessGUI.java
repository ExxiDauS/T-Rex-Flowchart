import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
public class ProcessGUI {
    private  JFrame frame;
    private JLabel process, variable, statement;
    private JPanel bag, varGrid, statementGrid, panel1, panel2;
    private DoneCustomButton doneBtn;
    private CustomTextField varInp, statementInp;

    public ProcessGUI(){
        try{
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

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Thin.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Regular.ttf")));

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
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLocation(500, 250);
            frame.setSize(300, 450);
            frame.setResizable(false);
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ProcessGUI();
    }
}
