import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
public class InputGUI {
    private  JFrame frame;
    private JLabel inputText, messageText, varType, assignTo;
    private JPanel bag, messageGrid, messagePanel, varGrid, varPanel, assignGrid, assignPanel, radioPanel;
    private DoneCustomButton doneBtn;
    private CustomTextField inputTextfield, assignTextfield;
    private JRadioButton intRadio, doubleRadio, stringRadio;
    private ButtonGroup TheBtDeviceIsReadyToPair;

    public InputGUI(){
        try{
            frame = new JFrame();
            inputText = new JLabel("  Input:");
            messageText = new JLabel("Message:   ");
            varType = new JLabel("Variable Type:");
            assignTo = new JLabel("Assign to:");
            doneBtn = new DoneCustomButton();
            inputTextfield = new CustomTextField();
            assignTextfield = new CustomTextField();
            bag = new JPanel(new GridBagLayout());
            messageGrid = new JPanel(new GridLayout(2, 1));
            messagePanel = new JPanel(new GridLayout(1, 2));
            varGrid = new JPanel(new GridLayout(2, 1));
            varPanel = new JPanel(new GridLayout(1, 2));
            assignGrid = new JPanel(new GridLayout(2, 1));
            assignPanel = new JPanel(new GridLayout(1, 2));
            intRadio = new JRadioButton("int");
            doubleRadio = new JRadioButton("double");
            stringRadio = new JRadioButton("String");
            radioPanel = new JPanel(new GridLayout(3, 1));
            TheBtDeviceIsReadyToPair = new ButtonGroup();

            frame.setLayout(new BorderLayout());
            doneBtn.setText("Done");
            doneBtn.setForeground(Color.white);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Thin.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Regular.ttf")));

            GridBagConstraints gbc = new GridBagConstraints();

            inputText.setFont(new Font("Montserrat", Font.BOLD, 24));
            inputText.setForeground(new Color(33, 150, 243));

            messageText.setFont(new Font("Montserrat", Font.PLAIN, 18));
            messageText.setForeground(new Color(0, 64, 128));

            varType.setFont(new Font("Montserrat", Font.PLAIN, 18));
            varType.setForeground(new Color(0, 64, 128));

            assignTo.setFont(new Font("Montserrat", Font.PLAIN, 18));
            assignTo.setForeground(new Color(0, 64, 128));

            messageText.setHorizontalAlignment(JTextField.LEFT);
            messagePanel.add(messageText);
            messagePanel.add(new JLabel(" "));
            messageGrid.add(messagePanel);
            messageGrid.add(inputTextfield);

            varPanel.add(varType);
            varPanel.add(new JLabel(" "));
            varGrid.add(varPanel);
            TheBtDeviceIsReadyToPair.add(intRadio);
            TheBtDeviceIsReadyToPair.add(doubleRadio);
            TheBtDeviceIsReadyToPair.add(stringRadio);
            radioPanel.add(intRadio);
            radioPanel.add(doubleRadio);
            radioPanel.add(stringRadio);
            varGrid.add(radioPanel);

            assignPanel.add(assignTo);
            assignPanel.add(new JLabel(" "));
            assignGrid.add(assignPanel);
            assignGrid.add(assignTextfield);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 0;
            bag.add(messageGrid, gbc);
            gbc.gridy = 1;
            bag.add(varGrid, gbc);
            gbc.gridy = 2;
            bag.add(assignGrid, gbc);
            gbc.insets = new Insets(30, 0, 0, 0);
            gbc.gridy = 3;
            bag.add(doneBtn, gbc);

            frame.add(inputText, BorderLayout.NORTH);
            frame.add(bag, BorderLayout.CENTER);

            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLocation(500, 250);
            frame.setSize(300, 500);
            frame.setResizable(false);
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new InputGUI();
    }
}
