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
        g2.drawString("Yes", (getWidth()/2-(150)-16), 30);
        g2.drawLine((getWidth()/2)-(mainShape.getWidth()/2), mainShape.getHeight()/2,(getWidth()/2-(mainShape.getWidth()/2))-150,mainShape.getHeight()/2);
        g2.drawString("No", (getWidth()/2+(150))-16, 30);
        g2.drawLine((getWidth()/2)+(mainShape.getWidth()/2), mainShape.getHeight()/2,(getWidth()/2+(mainShape.getWidth()/2))+150,mainShape.getHeight()/2);
        g2.drawLine((getWidth()/2), flowchartMaxY,(getWidth()/2-(mainShape.getWidth()/2))-150,flowchartMaxY);
        g2.drawLine((getWidth()/2), flowchartMaxY,(getWidth()/2+(mainShape.getWidth()/2))+150,flowchartMaxY);
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
