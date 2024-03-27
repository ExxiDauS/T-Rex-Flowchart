import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Start extends Shape{
    private JPanel jp;
    private JButton startBtn;
    private ArrowComponent arrow;

    public Start() {
        jp = new JPanel(new GridLayout(2,  1));
        startBtn = new JButton("Start");
        arrow = new ArrowComponent(startBtn);
        jp.add(startBtn);
        jp.add(arrow);
    }

    public JPanel getJp() {
        return jp;
    }

    @Override
    public void convertToCode(File f) {
        if (f.exists()){
            f.delete();
            try (FileWriter fw = new FileWriter(f)){
                String fileNameWithOutExt = f.getName().replaceFirst("[.][^.]+$", "");
                fw.write("public class " + fileNameWithOutExt + " {\n");
                fw.write("public static void main(String[] args) {\n");
                fw.write("try { \n");
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try (FileWriter fw = new FileWriter(f)){
                String fileNameWithOutExt = f.getName().replaceFirst("[.][^.]+$", "");
                fw.write("public class " + fileNameWithOutExt + " {\n");
                fw.write("public static void main(String[] args) {\n");
                fw.write("try { \n");
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
