import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class ShapeGUI {
    protected DoneCustomButton doneBtn;
    protected JFrame frame;
    protected ImageIcon img;
    protected ActionShape host;

    public ShapeGUI(){
        img = new ImageIcon("Main_project//src//picture//logo96.png");
        try{
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Thin.ttf")));
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Bold.ttf")));
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Main_project\\src\\font\\Montserrat-Regular.ttf")));
        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
    public DoneCustomButton getDoneBtn() {
        return doneBtn;
    }

    public JFrame getFrame() {
        return frame;
    }

    public ActionShape getHost() {
        return host;
    }

    public abstract void configShape();
}
