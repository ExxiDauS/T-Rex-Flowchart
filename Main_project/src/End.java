import java.io.*;
import javax.swing.*;
import java.awt.*;

public class End extends Shape{
    private JPanel jp;
    private JButton endBtn;

    public End() {
        jp = new JPanel(new GridLayout(2,  1));
        endBtn = new JButton("End");
        jp.add(endBtn);
    }

    public JPanel getJp() {
        return jp;
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
        else{
            System.out.println("Please contact developer of this project.");
        }
    }
}
