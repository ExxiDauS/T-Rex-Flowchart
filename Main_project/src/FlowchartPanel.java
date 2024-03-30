import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class FlowchartPanel extends JPanel{
    private ArrayList<Shape> order;
    public FlowchartPanel(Dimension frameSize) {
        setLayout(null);
        setBackground(Color.WHITE);
        setBorder(new LineBorder(new Color(204, 204, 204)));
    }

    public void checkBoundsAndAdjustPanel(Rectangle shapeBounds) {
        Rectangle bounds = shapeBounds;
        Dimension panelSize = getPreferredSize();

        int newX = Math.min(bounds.x, 0);
        int newY = Math.min(bounds.y, 0);
        int newWidth = Math.max(panelSize.width, bounds.x + bounds.width - newX);
        int newHeight = Math.max(panelSize.height, bounds.y + bounds.height - newY);

        if (newWidth != panelSize.width || newHeight != panelSize.height || newX < 0 || newY < 0) {
            setPreferredSize(new Dimension(newWidth, newHeight+50));
            JViewport viewport = (JViewport) getParent();
            Rectangle rect = new Rectangle(-newX, -newY, bounds.width, bounds.height);
            viewport.scrollRectToVisible(rect);
        }
    }

    public void drawFlowchart(ArrayList<Shape> order) {
        repaint();
        removeAll();
        int runningX = getWidth()/2;
        int runningY = 10;
        Rectangle bounds = new Rectangle();
        for (Shape shape : order) {
            boolean isConditionShape = ConditionShape.class.isAssignableFrom(shape.getClass());
            boolean isDecisionShape = shape.getClass().equals(new DecisionShape().getClass());
            if (!isConditionShape) {
                int shapeWidth = (int)shape.getPreferredSize().getWidth();
                int shapeHeight = (int)shape.getPreferredSize().getHeight();
                shape.setBounds(runningX-(shapeWidth/2), runningY, shapeWidth, shapeHeight);
                add(shape);
                runningY += shapeHeight;
                bounds = shape.getBounds();
            }
            else if (isDecisionShape) {
                DecisionFlow decisionFlow = new DecisionFlow((DecisionShape) shape);
                decisionFlow.drawFlowchart();
                int shapeWidth = decisionFlow.getWidth();
                int shapeHeight = decisionFlow.getHeight();
                decisionFlow.setLocation(runningX-(shapeWidth/2), runningY);
                add(decisionFlow);
                runningY += shapeHeight;
                bounds = decisionFlow.getBounds();
            }
            repaint();
            checkBoundsAndAdjustPanel(bounds);
        }
    }

    public void shapeDelete(ActionShape shape, ArrowComponent arrow) {
        remove(shape);
        remove(arrow);
    }

    public void paintCurrentShape(ArrayList<Shape> order) {}

}
