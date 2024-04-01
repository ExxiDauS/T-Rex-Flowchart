import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DecisionShape extends ActionShape implements DrawFlowchartable {
    private int xPosition;
    private int yPosition;
    private String condition;
    private int nestedLevel;
    private ArrayList<Shape> yesOrder;
    private ArrayList<Shape> noOrder;

    public DecisionShape(Dimension panelSize) {
        this();
        parentSize = panelSize;
    }

    public DecisionShape(ArrowComponent yesArrow, ArrowComponent noArrow) {
        this();
        yesOrder.add(yesArrow);
        noOrder.add(noArrow);
    }

    public DecisionShape(){
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
        condition = "true";
        yesOrder = new ArrayList<Shape>();
        noOrder = new ArrayList<Shape>();
        nestedLevel = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Montserrat", Font.PLAIN, 18);
        Color highlighted = new Color(0, 64, 128);
        Color identical = new Color(255,87,34);
        int[] xPoints = {xPosition + getWidth()/2, xPosition + getWidth(), xPosition + getWidth()/2, xPosition};
        int[] yPoints = {yPosition, yPosition + getHeight()/2, yPosition+getHeight(), yPosition+getHeight()/2};

        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(identical);
        }

        g2.drawPolygon(xPoints, yPoints, 4);
        int[] xPoints2 = {xPosition + getWidth()/2, xPosition + getWidth()-1, xPosition + getWidth()/2, xPosition + 1};
        int[] yPoints2 = {yPosition + 1, yPosition + getHeight()/2, yPosition + getHeight()-1, yPosition + getHeight()/2};
        g2.setColor(Color.WHITE);
        g2.fillPolygon(xPoints2, yPoints2, 4);
        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(identical);
        }

        g2.setFont(f);
        if (configured) {
            String textPreview = condition;
            if (textPreview.length() > 7) {
                textPreview = textPreview.substring(0, Math.min(textPreview.length(), 7));
                textPreview += " ...";
            }
            drawCenteredString(g2, textPreview, new Rectangle(getWidth(), getHeight()), f);
        }
        else {
            drawCenteredString(g2, "if / else", new Rectangle(getWidth(), getHeight()), f);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (!isInFlowchart()){
            return new Dimension((int)parentSize.getHeight()/3, (int)parentSize.getHeight()/6);
        }
        else {
            return new Dimension(150, 70);
        }
    }

    @Override
    public int addNonDrawable(Shape shape, int runningX, int runningY, JPanel panel) {
        int shapeWidth = (int)shape.getPreferredSize().getWidth();
        int shapeHeight = (int)shape.getPreferredSize().getHeight();
        shape.setBounds(runningX-(shapeWidth/2), runningY, shapeWidth, shapeHeight);
        panel.add(shape);
        runningY += shapeHeight;
        return runningY;
    }

    @Override
    public JPanel drawFlowchart() {
        DecisionFlow panel = new DecisionFlow(this);
        int yesRunningX = ((panel.getWidth()/2)-75)-(150+(nestedLevel*20));
        int yesRunningY = 35+1;
        ArrowComponent yesLastArrow = null;
        for (Shape shape : yesOrder) {
            boolean isDrawFlowchartable = shape instanceof DrawFlowchartable;
            if (!isDrawFlowchartable) {
                if (shape.getClass().equals(new ArrowComponent().getClass())) {
                    yesLastArrow = (ArrowComponent) shape;
                    yesLastArrow.setArrowHeight(80);
                }
                yesRunningY = addNonDrawable(shape, yesRunningX, yesRunningY, panel);
            }
            else if (shape.getClass().equals(DecisionShape.class)){
                DecisionShape castShape = (DecisionShape)shape;
                DecisionFlow Panel = (DecisionFlow) castShape.drawFlowchart();
                int shapeWidth = Panel.getWidth();
                int shapeHeight = Panel.getHeight();
                Panel.setLocation(yesRunningX-(shapeWidth/2), yesRunningY);
                panel.add(Panel);
                yesRunningY += shapeHeight;
            } else {
                LoopShape castShape = (LoopShape) shape;
                LoopFlow Panel = (LoopFlow)castShape.drawFlowchart();
                int shapeWidth = Panel.getWidth();
                int shapeHeight = Panel.getHeight();
                Panel.setLocation(yesRunningX-(shapeWidth/2), yesRunningY);
                panel.add(Panel);
                yesRunningY += shapeHeight;
            }
        }


        int noRunningX = ((panel.getWidth()/2)+75)+(150+(nestedLevel*20));
        int noRunningY = 35+1;
        ArrowComponent noLastArrow = null;
        for (Shape shape : noOrder) {
            boolean isDrawFlowchartable = shape instanceof DrawFlowchartable;
            if (!isDrawFlowchartable) {
                if (shape.getClass().equals(new ArrowComponent().getClass())) {
                    noLastArrow = (ArrowComponent) shape;
                    noLastArrow.setArrowHeight(80);
                }
                noRunningY = addNonDrawable(shape, noRunningX, noRunningY, panel);
            }else if (shape.getClass().equals(DecisionShape.class)) {
                DecisionShape castShape = (DecisionShape)shape;
                DecisionFlow Panel = (DecisionFlow) castShape.drawFlowchart();
                int shapeWidth = Panel.getWidth();
                int shapeHeight = Panel.getHeight();
                Panel.setLocation(noRunningX-(shapeWidth/2), noRunningY);
                panel.add(Panel);
                noRunningY += shapeHeight;
            } else {
                LoopShape castShape = (LoopShape) shape;
                LoopFlow Panel = (LoopFlow)castShape.drawFlowchart();
                int shapeWidth = Panel.getWidth();
                int shapeHeight = Panel.getHeight();
                Panel.setLocation(noRunningX-(shapeWidth/2), noRunningY);
                panel.add(Panel);
                noRunningY += shapeHeight;
            }
        }
        int flowchartMaxY = Math.max(yesRunningY, noRunningY);
        panel.setFlowchartMaxY(flowchartMaxY);
        if (flowchartMaxY == yesRunningY) {
            noLastArrow.setArrowHeight(noLastArrow.getArrowHeight()+(yesRunningY-noRunningY));
        }else if (flowchartMaxY == noRunningY) {
            yesLastArrow.setArrowHeight(yesLastArrow.getArrowHeight()+(noRunningY-yesRunningY));
        }
        panel.setSize(panel.getWidth(), flowchartMaxY);
        panel.repaint();
        return panel;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public ArrayList<Shape> getYesOrder() {
        return yesOrder;
    }

    public ArrayList<Shape> getNoOrder() {
        return noOrder;
    }
    @Override
    public int getNestedLevel() {
        return nestedLevel;
    }
    @Override
    public void nested() {
        nestedLevel += 1;
        JPanel pointer = (JPanel)getParent().getParent();
        if (pointer instanceof SubFlow) {
            ((SubFlow) pointer).getMainShape().nested();
        }
    }
    @Override
    public void unnested() {
        nestedLevel -= 1;
        JPanel pointer = (JPanel)getParent().getParent();
        if (pointer instanceof SubFlow) {
            ((SubFlow) pointer).getMainShape().unnested();
        }
    }

    @Override
    public void convertToCode(File f) {
        if (f.exists()) {
            try (FileWriter fw = new FileWriter(f,true)) {
                String Header = "if (" + condition + ")" + " {\n";
                fw.write(Header);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            for (Shape shape : yesOrder) {
                if (!shape.getClass().equals(ArrowComponent.class)) {shape.convertToCode(f);}
            }
            try (FileWriter fw = new FileWriter(f,true)) {
                fw.write("} else {\n");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            for (Shape shape : noOrder) {
                if (!shape.getClass().equals(ArrowComponent.class)) {shape.convertToCode(f);}
            }
            try (FileWriter fw = new FileWriter(f,true)) {
                fw.write("}\n");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
