import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.HashSet;

public class OutputShape extends ActionShape{
    private int xPosition;
    private int yPosition;
    private String message;

    public OutputShape(Dimension panelSize) {
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
        parentSize = panelSize;
    }

    public OutputShape() {
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Montserrat", Font.PLAIN, 18);
        Color highlighted = new Color(0, 150, 136);
        Color identical = new Color(33,150,243);
        int[] xPoints = {xPosition, xPosition + getWidth()/6, xPosition + getWidth(), xPosition + (getWidth()*5)/6};
        int[] yPoints = {yPosition + getHeight() - 1, yPosition, yPosition, yPosition + getHeight() - 1};
        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(identical);
        }

        g2.setStroke(new BasicStroke(2));
        g2.drawLine(3+xPosition + (getWidth()*5)/6, yPosition + getHeight()-1-5, xPosition+getWidth()-1, yPosition + getHeight()-1-5);
        g2.drawLine(xPosition+getWidth()-1, yPosition + getHeight()-1-5, xPosition+getWidth()-1-5, yPosition + getHeight()-1-5-5);
        g2.drawLine(xPosition+getWidth()-1, yPosition + getHeight()-1-5, xPosition+getWidth()-1-5, yPosition + getHeight()-1-5+5);
        g2.setStroke(new BasicStroke(1));

        g2.drawPolygon(xPoints, yPoints, 4);
        int[] xPoints2 = {xPosition + 1, xPosition + (getWidth()/6) + 1, xPosition + (getWidth())-1, xPosition + ((getWidth()*5)/6)-1};
        int[] yPoints2 = {yPosition + getHeight() - 1, yPosition+1, yPosition+1, yPosition + getHeight() - 1};
        g2.setColor(Color.WHITE);
        g2.fillPolygon(xPoints2, yPoints2, 4);
        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(identical);
        }

        g2.setFont(f);
        drawCenteredString(g2, "Output", new Rectangle(getWidth(), getHeight()), f);
    }

    @Override
    public Dimension getPreferredSize() {
        if (!isInFlowchart()){
            return new Dimension((int)parentSize.getWidth()/2, (int)parentSize.getHeight()/9);
        }
        else {
            return new Dimension(150, 50);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void convertToCode(File f, HashSet<String> variablePool) {
        try(FileWriter fw = new FileWriter(f, true)){
            fw.write("System.out.println("+message+");");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

}
