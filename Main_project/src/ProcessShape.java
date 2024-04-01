import java.awt.*;
import javax.swing.*;
import java.io.*;

public class ProcessShape extends ActionShape{
    private int xPosition;
    private int yPosition;
    private String varName;
    private String varValue;
    private boolean isNewVar;

    public ProcessShape(Dimension panelSize) {
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
        parentSize = panelSize;
    }

    public ProcessShape(String variableName, String value) {
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
        this.varName = variableName;
        this.varValue = value;
        isNewVar = false;
        associatedGUI = null;
    }

    public ProcessShape() {
        this("","");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Montserrat", Font.PLAIN, 18);
        Color highlighted = new Color(0, 150, 136);
        Color identical = new Color(255,193,7);
        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(identical);
        }

        g2.drawRoundRect(xPosition, yPosition, getWidth()-1, getHeight()-1, 10, 10);

        g2.setColor(Color.WHITE);
        g2.fillRoundRect(xPosition+1, yPosition+1, getWidth()-3, getHeight()-3, 10, 10);

        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(identical);
        }

        g2.setFont(f);
        drawCenteredString(g2, "Process", new Rectangle(getWidth(), getHeight()), f);
    }

    @Override
    public Dimension getPreferredSize() {
        if (!isInFlowchart()){
            return new Dimension((int)parentSize.getWidth()/2, (int)(parentSize.getHeight()/6));
        }
        else {
            return new Dimension(150, 60);
        }
    }

    @Override
    public void convertToCode(File f) {
        try(FileWriter fw = new FileWriter(f, true)){
            if(isNewVar){
                fw.write("Object" + varName + ";\n");
            }
            fw.write(varName + " = " + varValue + ";\n");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
