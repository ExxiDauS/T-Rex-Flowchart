import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DecisionFlow extends SubFlow{
    private DecisionShape mainShape;
    private int flowchartMaxY;

    public DecisionFlow(DecisionShape mainShape) {
        this.mainShape = mainShape;
        setLayout(null);
        setOpaque(false);
        add(mainShape);
        setSize(25000,10000);
        mainShape.setBounds(getWidth()/2-75,0,150,70);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        mainShape.setBounds(getWidth()/2-75,0,150,70);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Montserrat", Font.PLAIN, 18);
        g2.setColor(Color.BLACK);
        g2.setFont(f);
        int expand = 150 + (mainShape.getNestedLevel() * 20);
        g2.drawString("Yes", (getWidth()/2-(expand/2)-48), 30);
        g2.drawString("No", (getWidth()/2+(expand/2))+32, 30);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(102,102,102));
        g2.drawLine((getWidth()/2)-(mainShape.getWidth()/2), mainShape.getHeight()/2,(getWidth()/2-(mainShape.getWidth()/2))-expand,mainShape.getHeight()/2);
        g2.drawLine((getWidth()/2)+(mainShape.getWidth()/2), mainShape.getHeight()/2,(getWidth()/2+(mainShape.getWidth()/2))+expand,mainShape.getHeight()/2);
        g2.drawLine((getWidth()/2), flowchartMaxY-1,(getWidth()/2-(mainShape.getWidth()/2))-expand,flowchartMaxY-1);
        g2.drawLine((getWidth()/2), flowchartMaxY-1,(getWidth()/2+(mainShape.getWidth()/2))+expand,flowchartMaxY-1);
        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.BLACK);
    }



    public DecisionShape getMainShape() {
        return mainShape;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50000,10000);
    }
    public void setFlowchartMaxY(int maxY) {
        this.flowchartMaxY = maxY;
    }

}
