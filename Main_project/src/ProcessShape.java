import java.awt.*;
import javax.swing.*;

public class ProcessShape extends ActionShape{
    private int xPosition;
    private int yPosition;

    public ProcessShape(Dimension panelSize) {
        super();
        xPosition = 0;  yPosition = 0;
        clicked = false;
        parentSize = panelSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Montserrat", Font.PLAIN, 18);

        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(new Color(255, 193, 7));
        }

        g2.drawRoundRect(xPosition, yPosition, getWidth()-1, getHeight()-1, 10, 10);

        g2.setColor(Color.WHITE);
        g2.fillRoundRect(xPosition+1, yPosition+1, getWidth()-3, getHeight()-3, 10, 10);

        if(!clicked) {
            g2.setColor(Color.BLACK);
        }
        else {
            g2.setColor(new Color(255, 193, 7));
        }

        g2.setFont(f);
        drawCenteredString(g2, "Process", new Rectangle(getWidth(), getHeight()), f);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int)parentSize.getWidth()/2, (int)parentSize.getHeight()/9);
    }

    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setLayout(new FlowLayout());
        ProcessShape pro = new ProcessShape(new Dimension(288, 450));
        pro.setPreferredSize(new Dimension(288, 450));
        fr.add(pro);
        fr.setSize(500,500);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
