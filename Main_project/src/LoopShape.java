import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LoopShape extends ActionShape {
    private int xPosition;
    private int yPosition;
    private ArrayList<Shape> trueOrder;
    private String condition;

    public LoopShape(Dimension panelSize) {
        this();
        parentSize = panelSize;
    }

    public LoopShape() {
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
        trueOrder = new ArrayList<Shape>();
        condition = "true";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Montserrat", Font.PLAIN, 18);
        Color highlighted = new Color(0, 150, 136);
        Color identical = new Color(181, 93, 223);
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
        drawCenteredString(g2, "While", new Rectangle(getWidth(), getHeight()), f);
    }

    public void drawSubFlowchart(ArrayList<Shape> order) {
        int runningX = getWidth()/2;
        int runningY = 10;
        for (Shape shape : order) {
            int shapeWidth = (int)shape.getPreferredSize().getWidth();
            int shapeHeight = (int)shape.getPreferredSize().getHeight();
            shape.setBounds(runningX-(shapeWidth/2), runningY, shapeWidth, shapeHeight);
            add(shape);
            runningY += shapeHeight;
            repaint();
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
    public void convertToCode(File f) {
        if (f.exists()){
            try(FileWriter fw = new FileWriter(f,true)) {
                String header = "while (" + condition + ") {\n";
                fw.write(header);
            }
            catch(IOException iex) {
                iex.printStackTrace();
            }
            try(FileWriter fw = new FileWriter(f,true)) {
                fw.write("}");
            }
            catch(IOException iex) {
                iex.printStackTrace();
            }


        }

    }

    public ArrayList<Shape> getTrueOrder() {
        return trueOrder;
    }

}
