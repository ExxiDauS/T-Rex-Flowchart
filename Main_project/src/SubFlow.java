import javax.swing.*;

public abstract class SubFlow extends JPanel {
    protected DrawFlowchartable mainShape;
    protected int flowchartMaxY;
    public DrawFlowchartable getMainShape() {return mainShape;}
    public void setFlowchartMaxY(int maxY) {
        this.flowchartMaxY = maxY;
    }
}
