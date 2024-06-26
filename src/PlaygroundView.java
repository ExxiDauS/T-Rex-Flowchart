import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.File;
import java.io.IOException;

public class PlaygroundView extends JFrame{
    private Toolkit toolkit;
    private JDesktopPane dp;
    private TopBarPanel topBarPanel;
    private ShapePanel shapePanel;
    private ConsolePanel consolePanel;
    private JScrollPane flowchartScroll;
    private FlowchartPanel flowchartPanel;
    private problemFrame prbfr;
    public PlaygroundView() {
        setTitle("T-Rex Flowchart");
        ImageIcon img = new ImageIcon("src//picture//logo96.png");
        setIconImage(img.getImage());
        //load font
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Montserrat-Thin.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Montserrat-Bold.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\font\\Montserrat-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        Dimension fixedScreenSize = new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()-48);
        this.setSize(fixedScreenSize);
//        this.setSize(1920, 1080-48);

        topBarPanel = new TopBarPanel();
        dp = new JDesktopPane();
        shapePanel = new ShapePanel(getSize());
        consolePanel = new ConsolePanel();

        topBarPanel.setBounds(0,0, getWidth(), 60);
        shapePanel.setBounds(0,60,getWidth()/5,(getHeight()/2)-60);
        consolePanel.setBounds(0,60+shapePanel.getHeight(),getWidth()/5,getHeight()-(shapePanel.getHeight()+60)-35);
        int flowchartPanelWidth = getWidth()-shapePanel.getWidth();
        int flowchartPanelHeight = getHeight()-95;
        flowchartPanel = new FlowchartPanel(new Dimension(flowchartPanelWidth, flowchartPanelHeight));
        flowchartPanel.setBounds(shapePanel.getWidth(),60,25000,1000);
        flowchartScroll = new JScrollPane(flowchartPanel);
        flowchartScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        flowchartScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        flowchartScroll.setBounds(shapePanel.getWidth(), 60, flowchartPanelWidth-10,flowchartPanelHeight);
        flowchartScroll.setBorder(new LineBorder(new Color(204, 204, 204)));
        flowchartScroll.getVerticalScrollBar().setUnitIncrement(16);
        flowchartScroll.getHorizontalScrollBar().setUnitIncrement(16);
        JViewport viewport = (JViewport) flowchartPanel.getParent();
        Rectangle rect = new Rectangle(new Point(12500, 0), flowchartPanel.getSize());
        viewport.scrollRectToVisible(rect);

        dp.setBackground(Color.WHITE);
        dp.add(topBarPanel);
        dp.add(shapePanel);
        dp.add(consolePanel);
        dp.add(flowchartScroll);
        dp.setVisible(true);


        this.add(dp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
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
    public FlowchartPanel getFlowchartPanel() {
        return flowchartPanel;
    }
    public JDesktopPane getDesktopPane() {
        return dp;
    }
    public void initProblemFrame() {
        prbfr = new problemFrame();
        prbfr.setSize(1024,576);
        prbfr.setVisible(true);
        dp.add(prbfr);
        prbfr.toFront();
    }

    public problemFrame getPrbfr() {
        return prbfr;
    }
}
