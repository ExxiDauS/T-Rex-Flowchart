import java.awt.*;
import javax.swing.*;
import java.io.*;

public class InputShape extends ActionShape{
    private int xPosition;
    private int yPosition;
    private String varType;
    private String varName;
    private String message;
    private String varValue;
    private boolean isNewVar;

    public InputShape(Dimension panelSize) {
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
        parentSize = panelSize;
    }

    public InputShape() {
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
        configured = false;
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
        int[] yPoints = {yPosition - 1 + getHeight(), yPosition, yPosition, yPosition + getHeight() - 1};

        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(identical);
        }

        g2.setStroke(new BasicStroke(2));
        g2.drawLine(xPosition + getWidth()/6 - 3, yPosition + 5, xPosition, yPosition+5);
        g2.drawLine(xPosition + getWidth()/6 - 3, yPosition + 5, xPosition + getWidth()/6 - 3 - 5, yPosition);
        g2.drawLine(xPosition + getWidth()/6 - 3, yPosition + 5, xPosition + getWidth()/6 - 3 - 5, yPosition+10);
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
        if (configured) {
            String textPreview = varType + " " + varName;
            if (textPreview.length() > 7) {
                textPreview = textPreview.substring(0, Math.min(textPreview.length(), 7));
                textPreview += " ...";
            }
            drawCenteredString(g2, textPreview, new Rectangle(getWidth(), getHeight()), f);
        }else {
                drawCenteredString(g2, "Input", new Rectangle(getWidth(), getHeight()), f);
            }
    }

    public void setVarType(String varType) {
        this.varType = varType;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVarType() {
        return varType;
    }

    public String getVarName() {
        return varName;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void convertToCode(File f) {
        try(FileWriter fw = new FileWriter(f, true)){
            varValue = JOptionPane.showInputDialog(null, message);
            if (varType.equals("String")) {
                if(isNewVar){
                    fw.write("Object " + varName + ";\n");
                }
                fw.write(varName + " = \"" + varValue + "\";\n");
            }
            else {
                if(isNewVar){
                    fw.write("Object " + varName + ";\n");
                }
                fw.write(varName + " = " + varValue + ";\n");
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void previewToCode() {
        String result = "";
        isNewVar = true;
        varValue = JOptionPane.showInputDialog(null, message);
        if (varType.equals("String")) {
            if(isNewVar){
                result += ("Object " + varName + ";\n");
            }
            result += (varName + " = \"" + varValue + "\";\n");
        }
        else {
            if(isNewVar){
                result += ("Object " + varName + ";\n");
            }
            result += (varName + " = " + varValue + ";\n");
        }
        System.out.println(result);
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
}
