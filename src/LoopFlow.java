import javax.swing.*;
import java.awt.*;

public class LoopFlow extends SubFlow{
    private LoopShape mainShape;
    private int flowchartMaxY;

    public LoopFlow(LoopShape mainShape) {
        this.mainShape = mainShape;
        setLayout(null);
        setOpaque(false);
        add(mainShape);
        setSize(25000, 10000);
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
        int expand = 150 + (mainShape.getNestedLevel() * 175);
        g2.drawString("End Loop", (getWidth()/2-(expand/2)-86), 30);
        g2.drawString("Loop", (getWidth()/2+(expand/2))+46, 30);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(102,102,102));
        g2.drawLine((getWidth()/2)-(mainShape.getWidth()/2), mainShape.getHeight()/2,(getWidth()/2-(mainShape.getWidth()/2))-expand,mainShape.getHeight()/2);
        g2.drawLine((getWidth()/2)+(mainShape.getWidth()/2), mainShape.getHeight()/2,(getWidth()/2+(mainShape.getWidth()/2))+expand,mainShape.getHeight()/2);
        g2.drawLine((getWidth()/2)+(mainShape.getWidth()/2), mainShape.getHeight()/2,(getWidth()/2)+(mainShape.getWidth()/2)+5,(mainShape.getHeight()/2)-5);
        g2.drawLine((getWidth()/2)+(mainShape.getWidth()/2), mainShape.getHeight()/2,(getWidth()/2)+(mainShape.getWidth()/2)+5,(mainShape.getHeight()/2)+5);
        g2.drawLine((getWidth()/2), flowchartMaxY-1,(getWidth()/2+(mainShape.getWidth()/2))+expand,flowchartMaxY-1);
        g2.drawLine((getWidth()/2), flowchartMaxY+74,(getWidth()/2-(mainShape.getWidth()/2))-expand,flowchartMaxY+74);
        g2.drawLine((getWidth()/2+(mainShape.getWidth()/2))+expand, flowchartMaxY-1,(getWidth()/2+(mainShape.getWidth()/2))+expand,mainShape.getHeight()/2);
        g2.drawLine((getWidth()/2-(mainShape.getWidth()/2))-expand, flowchartMaxY+74,(getWidth()/2-(mainShape.getWidth()/2))-expand,(mainShape.getHeight()/2));
        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.BLACK);
    }


    public LoopShape getMainShape() {
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
