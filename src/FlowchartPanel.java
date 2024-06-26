import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class FlowchartPanel extends JPanel{
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
            setSize(new Dimension(newWidth, newHeight));
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
            boolean isDrawFlowchartable = shape instanceof DrawFlowchartable;
            if (!isDrawFlowchartable) {
                int shapeWidth = (int)shape.getPreferredSize().getWidth();
                int shapeHeight = (int)shape.getPreferredSize().getHeight();
                shape.setBounds(runningX-(shapeWidth/2), runningY, shapeWidth, shapeHeight);
                add(shape);
                runningY += shapeHeight;
                bounds = shape.getBounds();
            }
            else if (shape.getClass().equals(DecisionShape.class)){
                DecisionShape castShape = (DecisionShape)shape;
                JPanel Panel = castShape.drawFlowchart();
                int shapeWidth = Panel.getWidth();
                int shapeHeight = Panel.getHeight();
                Panel.setLocation(runningX-(shapeWidth/2), runningY);
                add(Panel);
                runningY += shapeHeight;
                bounds = Panel.getBounds();
            } else {
                LoopShape castShape = (LoopShape) shape;
                JPanel Panel = castShape.drawFlowchart();
                int shapeWidth = Panel.getWidth();
                int shapeHeight = Panel.getHeight();
                Panel.setLocation(runningX-(shapeWidth/2), runningY);
                add(Panel);
                runningY += shapeHeight;
                bounds = Panel.getBounds();
            }
            repaint();
            checkBoundsAndAdjustPanel(bounds);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getSize());
    }

    public int getThisY(JPanel panel) {
        return panel.getY();
    }
}
