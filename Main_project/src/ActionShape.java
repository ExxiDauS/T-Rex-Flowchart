import java.awt.*;
import javax.swing.*;

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
