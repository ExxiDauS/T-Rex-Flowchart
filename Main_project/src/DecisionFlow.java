import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DecisionFlow extends JPanel{
    private DecisionShape mainShape;
    private int flowchartMaxY;

    public DecisionFlow(DecisionShape mainShape) {
        this.mainShape = mainShape;
        setLayout(null);
        setOpaque(false);
        add(mainShape);
        setSize(750,210);
        mainShape.setBounds(getWidth()/2-75,0,150,70);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Montserrat", Font.PLAIN, 18);
        g2.setColor(Color.BLACK);
        g2.setFont(f);
        g2.drawString("Yes", (getWidth()/2-150)-16, 30);
        g2.drawLine((getWidth()/2)-(mainShape.getWidth()/2), mainShape.getHeight()/2,(getWidth()/2-(mainShape.getWidth()/2))-150,mainShape.getHeight()/2);
        g2.drawString("No", (getWidth()/2+150)-16, 30);
        g2.drawLine((getWidth()/2)+(mainShape.getWidth()/2), mainShape.getHeight()/2,(getWidth()/2+(mainShape.getWidth()/2))+150,mainShape.getHeight()/2);
        g2.drawLine((getWidth()/2), flowchartMaxY,(getWidth()/2-(mainShape.getWidth()/2))-150,flowchartMaxY);
        g2.drawLine((getWidth()/2), flowchartMaxY,(getWidth()/2+(mainShape.getWidth()/2))+150,flowchartMaxY);
    }

//    public JPanel drawFlowchart() {
//        int yesRunningX = ((getWidth()/2)-75)-mainShape.getWidth();
//        int yesRunningY = 35+1;
//        ArrowComponent yesLastArrow = null;
//        for (Shape shape : mainShape.getYesOrder()) {
//            boolean isConditionShape = ConditionShape.class.isAssignableFrom(shape.getClass());
//            boolean isDecisionShape = shape.getClass().equals(new DecisionShape().getClass());
//            if (!isConditionShape) {
//                if (shape.getClass().equals(new ArrowComponent().getClass())) {
//                    yesLastArrow = (ArrowComponent) shape;
//                    yesLastArrow.setArrowHeight(80);
//                }
//                int shapeWidth = (int)shape.getPreferredSize().getWidth();
//                int shapeHeight = (int)shape.getPreferredSize().getHeight();
//                shape.setBounds(yesRunningX-(shapeWidth/2), yesRunningY, shapeWidth, shapeHeight);
//                add(shape);
//                yesRunningY += shapeHeight;
//            }
//            else if (isDecisionShape) {
//                DecisionFlow decisionFlow = new DecisionFlow((DecisionShape) shape);
//                decisionFlow.drawFlowchart();
//                int shapeWidth = decisionFlow.getWidth();
//                int shapeHeight = decisionFlow.getHeight();
//                decisionFlow.setLocation(yesRunningX-(shapeWidth/2), yesRunningY);
//                add(decisionFlow);
//                yesRunningY += shapeHeight;
//            }
//        }
//        int noRunningX = ((getWidth()/2)+75)+mainShape.getWidth();
//        int noRunningY = 35+1;
//        ArrowComponent noLastArrow = null;
//        for (Shape shape : mainShape.getNoOrder()) {
//            boolean isConditionShape = ConditionShape.class.isAssignableFrom(shape.getClass());
//            boolean isDecisionShape = shape.getClass().equals(new DecisionShape().getClass());
//            if (!isConditionShape) {
//                if (shape.getClass().equals(new ArrowComponent().getClass())) {
//                    noLastArrow = (ArrowComponent) shape;
//                    noLastArrow.setArrowHeight(80);
//                }
//                int shapeWidth = (int)shape.getPreferredSize().getWidth();
//                int shapeHeight = (int)shape.getPreferredSize().getHeight();
//                shape.setBounds(noRunningX-(shapeWidth/2), noRunningY, shapeWidth, shapeHeight);
//                add(shape);
//                noRunningY += shapeHeight;
//            }
//            else if (isDecisionShape) {
//                DecisionFlow decisionFlow = new DecisionFlow((DecisionShape) shape);
//                decisionFlow.drawFlowchart();
//                int shapeWidth = decisionFlow.getWidth();
//                int shapeHeight = decisionFlow.getHeight();
//                decisionFlow.setLocation(noRunningX-(shapeWidth/2), noRunningY);
//                add(decisionFlow);
//                noRunningY += shapeHeight;
//            }
//        }
//        flowchartMaxY = Math.max(yesRunningY, noRunningY);
//        if (flowchartMaxY == yesRunningY) {
//            noLastArrow.setArrowHeight(noLastArrow.getArrowHeight()+(yesRunningY-noRunningY));
//        }else if (flowchartMaxY == noRunningY) {
//            yesLastArrow.setArrowHeight(yesLastArrow.getArrowHeight()+(noRunningY-yesRunningY));
//        }
//        setSize(getWidth(), flowchartMaxY);
//        return this;
//    }

    public DecisionShape getMainShape() {
        return mainShape;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(750, 140);
    }
    public void setFlowchartMaxY(int maxY) {
        this.flowchartMaxY = maxY;
    }


    public static void main(String[] args) {
        JFrame fr = new JFrame();
        DecisionShape decisionShape = new DecisionShape();
        DecisionFlow df = new DecisionFlow(decisionShape);

        decisionShape.getYesOrder().add(new ArrowComponent(80));
//        decisionShape.getYesOrder().add(new DecisionShape(new ArrowComponent(80),new ArrowComponent(80)));

        decisionShape.getYesOrder().add(new ArrowComponent(80));
        decisionShape.getNoOrder().add(new ArrowComponent(80));

//        df.drawFlowchart();
        fr.add(df);
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
