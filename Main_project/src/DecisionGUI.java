import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
public class DecisionGUI {
    private  JFrame frame;
    private JLabel decision, condition;
    private JPanel bag, varGrid, panel1;
    private DoneCustomButton doneBtn;
    private CustomTextField conditionInp;

    public DecisionGUI(){
        try{
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

            conditionInp.setCol(32);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Thin.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Regular.ttf")));

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

            frame.add(decision, BorderLayout.NORTH);
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
        new DecisionGUI();
    }
}
