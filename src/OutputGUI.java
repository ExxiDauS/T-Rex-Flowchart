import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
public class OutputGUI extends ShapeGUI{
    private JLabel outputText, promptText;
    private JTextArea promptInp;
    private JScrollPane scPane;
    private JPanel bag, panel1, promptPanel;
    public OutputGUI(ActionShape host){
        this.host = host;
        frame = new JFrame();
        outputText = new JLabel("  Output:");
        promptText = new JLabel("Prompt:   ");
        promptInp = new JTextArea(10, 10);
        doneBtn = new DoneCustomButton();
        promptPanel = new JPanel(new GridLayout(2, 1));
        panel1 = new JPanel(new GridLayout(1, 2));
        bag = new JPanel(new GridBagLayout());
        frame.setLayout(new BorderLayout());
        doneBtn.setText("Done");
        doneBtn.setForeground(Color.white);
        scPane = new JScrollPane(promptInp);

        GridBagConstraints gbc = new GridBagConstraints();


        bag = new JPanel(new GridBagLayout());

        promptInp.setFont(new Font("Montserrat", Font.PLAIN, 18));

        outputText.setFont(new Font("Montserrat", Font.BOLD, 24));
        outputText.setForeground(new Color(33, 150, 243));

        promptText.setFont(new Font("Montserrat", Font.PLAIN, 18));
        promptText.setForeground(new Color(0, 64, 128));


        scPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        promptInp.setWrapStyleWord(true);
        promptInp.setLineWrap(true);

        promptText.setHorizontalAlignment(JTextField.LEFT);
        panel1.add(promptText);
        panel1.add(new JLabel(" "));
        promptPanel.add(panel1);
        promptPanel.add(new JLabel("  "));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        bag.add(promptPanel, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        bag.add(scPane, gbc);
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        bag.add(doneBtn, gbc);

        if (host.isConfigured()) {
            String userMessage = ((OutputShape)host).getMessage();
            promptInp.setText(userMessage);
        }

        frame.add(outputText, BorderLayout.NORTH);
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
        String prompt = promptInp.getText();
        ((OutputShape)host).setMessage(prompt);
        host.setConfigured(true);
    }
}
