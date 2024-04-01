import javax.swing.*;

public interface DrawFlowchartable {
    public JPanel drawFlowchart();
    public void unnested();
    public void nested();
    public int getNestedLevel();
    public int addNonDrawable(Shape shape, int runningX, int runningY, JPanel panel);
}
