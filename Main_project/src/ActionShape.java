import java.awt.*;
import javax.swing.*;
import java.io.*;

public abstract class ActionShape extends Shape{
    protected boolean clicked;
    protected boolean inFlowchart;
    protected boolean configured;
    public ActionShape() {
        super();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Image image = toolkit.getImage("Main_project\\src\\picture\\IconOri.png");
//        Cursor c = toolkit.createCustomCursor(image, new Point(0,0), "img");
//        setCursor(c);

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        inFlowchart = true;
    }

    public void paintWhenClicked() {
        clicked = !clicked;
        repaint();
    }

    public boolean isInFlowchart() {return inFlowchart;}

    public void isNotInFlowchart() {
        this.inFlowchart = false;
    }

    public boolean isClicked() {
        return clicked;
    }
}
