import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
public class LoopGUI extends ShapeGUI{
    private JLabel loop, whileText;
    private JPanel bag, varGrid, panel1;
    private CustomTextField whileInp;

    public LoopGUI(ActionShape host){
        this.host = host;
        frame = new JFrame();
        loop = new JLabel("  Loop:");
        whileText = new JLabel("While:         ");
        doneBtn = new DoneCustomButton();
        whileInp = new CustomTextField();
        bag = new JPanel(new GridBagLayout());
        varGrid = new JPanel(new GridLayout(2, 1));
        panel1 = new JPanel(new GridLayout(1, 2));

        frame.setLayout(new BorderLayout());
        doneBtn.setText("Done");
        doneBtn.setForeground(Color.white);

        whileInp.setColumns(32);

        GridBagConstraints gbc = new GridBagConstraints();

        loop.setFont(new Font("Montserrat", Font.BOLD, 24));
        loop.setForeground(new Color(181, 93, 223));

        whileText.setFont(new Font("Montserrat", Font.PLAIN, 18));
        whileText.setForeground(new Color(0, 64, 128));

        whileText.setHorizontalAlignment(JTextField.LEFT);
        panel1.add(whileText);
        panel1.add(new JLabel(" "));
        varGrid.add(panel1);
        varGrid.add(whileInp);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 120, 0);
        bag.add(varGrid, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        bag.add(doneBtn, gbc);

        if (host.isConfigured()) {
            String condition = ((LoopShape)host).getCondition();
            whileInp.setText(condition);
        }

        frame.add(loop, BorderLayout.NORTH);
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
        String condition = whileInp.getText();
        ((LoopShape)host).setCondition(condition);
        host.setConfigured(true);
    }

}
