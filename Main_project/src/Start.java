import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Start extends Shape{
//    JFrame for test
//    private JFrame jf;
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
        try(FileWriter fw = new FileWriter(f)) {
            fw.write("class " + f.getName() + " {\n");
            fw.write("public static void main(String[] args) {\n");
            fw.write("try { \n");
            fw.write("System.out.println(\"Hello,World! \");\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}