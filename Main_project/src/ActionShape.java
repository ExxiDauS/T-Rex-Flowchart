import java.awt.*;
import javax.swing.*;
import java.io.*;

public abstract class ActionShape extends Shape{
    protected Boolean clicked;

    public ActionShape() {
        super();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("Main_project\\src\\picture\\IconOri.png");
        Cursor c = toolkit.createCustomCursor(image, new Point(0,0), "img");
        setCursor(c);
    }
    public void paintWhenClicked() {
        clicked = !clicked;
        repaint();
    }
    public boolean isClicked() {
        return clicked;
    }
}
