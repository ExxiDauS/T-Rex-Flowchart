import java.awt.*;
import javax.swing.*;
import java.io.*;

public class EndShape extends Shape{

    public EndShape() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font f = new Font("Montserrat", Font.PLAIN, 18);
        g2.setColor(Color.WHITE);
        g2.fillOval(1,1, getWidth()-3, getHeight()-3);

        g2.setColor(new Color(76, 175, 80));
        g2.drawOval(0, 0, getWidth()-1, getHeight()-1);

        g2.setColor(new Color(76, 175, 80));
        g2.setFont(f);
        drawCenteredString(g2, "End", new Rectangle(getWidth(), getHeight()), f);
    }

    @Override
    public void convertToCode(File f) {
        if (f.exists()){
            try (FileWriter fw = new FileWriter(f, true)){
                fw.write("} catch (Exception e) {\n");
                fw.write("e.printStackTrace(); }\n");
                fw.write("}\n");
                fw.write("}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        else{
//            System.out.println("Please contact developer of this project.");
//        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 60);
    }

}
