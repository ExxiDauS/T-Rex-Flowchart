import java.awt.*;
import javax.swing.*;
import java.io.*;

public abstract class ActionShape extends Shape{
    protected boolean clicked;
    protected boolean inFlowchart;
    protected boolean configured;
    protected ShapeGUI associatedGUI;
    public ActionShape() {
        super();
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

    public ShapeGUI getAssociatedGUI() {
        return associatedGUI;
    }

    public void setAssociatedGUI(ShapeGUI associatedGUI) {
        this.associatedGUI = associatedGUI;
    }

    public void setConfigured(boolean configured) {
        this.configured = configured;
    }
    public boolean isConfigured() {
        return configured;
    }
}
