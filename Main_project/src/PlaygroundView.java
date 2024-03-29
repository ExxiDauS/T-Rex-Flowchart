import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class PlaygroundView extends JFrame{
    private Toolkit toolkit;
    private JDesktopPane dp;
    private TopBarPanel topBarPanel;
    private ShapePanel shapePanel;
    private ConsolePanel consolePanel;
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
//        this.setSize(toolkit.getScreenSize());
        this.setSize(1366, 768);
        topBarPanel = new TopBarPanel();
        dp = new JDesktopPane();
        shapePanel = new ShapePanel(getSize());
        consolePanel = new ConsolePanel();

        topBarPanel.setBounds(0,0, getWidth(), 60);
        shapePanel.setBounds(0,60,getWidth()/5,(getHeight()/2)-60);
        consolePanel.setBounds(0,60+shapePanel.getHeight(),getWidth()/5,(getHeight()-((getHeight()/2)-60)));

        dp.add(topBarPanel);
        dp.add(shapePanel);
        dp.add(consolePanel);
        dp.setVisible(true);

        this.add(dp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setVisible(true);
    }

    public TopBarPanel getToolPanel() {
        return topBarPanel;
    }
    public ShapePanel getShapePanel() {
        return shapePanel;
    }
    public ConsolePanel getConsolePanel() {
        return consolePanel;
    }
}
