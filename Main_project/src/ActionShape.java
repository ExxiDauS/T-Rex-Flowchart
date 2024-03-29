import java.awt.*;
import javax.swing.*;
import java.io.*;

public abstract class ActionShape extends Shape{
    private Boolean clicked;
    public void paintWhenClicked() {
        clicked = !clicked;
        repaint();
    }
    public boolean isClicked() {
        return clicked;
    }
}
