import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ConsolePanel extends JPanel{
    private JTextArea log;
    private JScrollPane scPane;
    public ConsolePanel() {
        setBackground(new Color(234,234,234));
        setBorder(new LineBorder(new Color(204,204,204)));
        setLayout(new BorderLayout());
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Montserrat-Thin.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Montserrat-Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Montserrat-Regular.ttf")));
        }
        catch(IOException | FontFormatException e) {
            e.printStackTrace();
        }
        log = new JTextArea();
        scPane = new JScrollPane(log);
        log.setFont(new Font("Montserrat", Font.PLAIN, 18));
        log.setEditable(false);
        log.setText("Welcome to T-Rex Flowchart\nThis is the Console!");
        scPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scPane, BorderLayout.CENTER);
        setSize(273,444);
    }

    public void refresh(ArrayList<String> data) {
        log.setText("");
        String consoleString = "Console Output:\n";
        for (String logData : data) {
            consoleString += (log.getText() + logData + "------- Finish --------\n");
        }
        log.setText(consoleString);
    }
}
