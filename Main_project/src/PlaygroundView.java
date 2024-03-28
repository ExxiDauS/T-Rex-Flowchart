import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class PlaygroundView extends JFrame{
    private Toolkit toolkit;
    private JDesktopPane dp;
    private TopBarPanel topBarPanel;
    public PlaygroundView() {
        //load font
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Thin.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        toolkit = Toolkit.getDefaultToolkit();
        this.setSize(toolkit.getScreenSize());
        topBarPanel = new TopBarPanel();
        dp = new JDesktopPane();

        topBarPanel.setBounds(0,0, this.getWidth(), 50);

        dp.add(topBarPanel);
        dp.setVisible(true);

        this.add(dp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setVisible(true);
    }

    public TopBarPanel getToolPanel() {
        return topBarPanel;
    }
}
