import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DecisionShape extends ActionShape implements drawFlowchartable{
    private int xPosition;
    private int yPosition;
    private String condition;
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
        drawCenteredString(g2, "if/else", new Rectangle(getWidth(), getHeight()), f);
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
        int yesRunningX = ((panel.getWidth()/2)-75)-getWidth();
        int yesRunningY = 35+1;
        ArrowComponent yesLastArrow = null;
        for (Shape shape : yesOrder) {
            boolean isDrawFlowchartable = shape instanceof drawFlowchartable;
            if (!isDrawFlowchartable) {
                if (shape.getClass().equals(new ArrowComponent().getClass())) {
                    yesLastArrow = (ArrowComponent) shape;
                    yesLastArrow.setArrowHeight(80);
                }
                yesRunningY = addNonDrawable(shape, yesRunningX, yesRunningY, panel);
            }
            else {
                DecisionShape castShape = (DecisionShape)shape;
                JPanel Panel = castShape.drawFlowchart();
                int shapeWidth = Panel.getWidth();
                int shapeHeight = Panel.getHeight();
                Panel.setLocation(yesRunningX-(shapeWidth/2), yesRunningY);
                panel.add(Panel);
                yesRunningY += shapeHeight;
            }
        }


        int noRunningX = ((panel.getWidth()/2)+75)+getWidth();
        int noRunningY = 35+1;
        ArrowComponent noLastArrow = null;
        for (Shape shape : noOrder) {
            if (shape.getClass().equals(new ArrowComponent().getClass())) {
                noLastArrow = (ArrowComponent) shape;
                noLastArrow.setArrowHeight(80);
            }
            noRunningY = addNonDrawable(shape, noRunningX, noRunningY, panel);
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

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    @Override
    public void convertToCode(File f) {
        if (f.exists()) {
            f.delete();
            try (FileWriter fw = new FileWriter(f)) {
                String Header = "if (" + condition + ")" + " {\n";
                fw.write(Header);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public ArrayList<Shape> getYesOrder() {
        return yesOrder;
    }

    public ArrayList<Shape> getNoOrder() {
        return noOrder;
    }

    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setLayout(new FlowLayout());
        fr.setSize(600,600);
        DecisionShape decisionShape = new DecisionShape(new ArrowComponent(80), new ArrowComponent(80));
        JPanel panel = decisionShape.drawFlowchart();
        fr.add(panel);
        System.out.println(panel.getWidth());
//        fr.add(new ArrowComponent(80));
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
