import java.awt.*;
import java.io.*;
import javax.swing.*;
public class Expression extends Shape{
    private JFrame frame;
    private JLabel equalLabel;
    private JTextField varName, varValue;
    private JPanel panel1;
    private JButton okBtn;
    public Expression(){
        frame = new JFrame();
        equalLabel = new JLabel("=");
        varName = new JTextField(8);
        varValue = new JTextField(16);
        panel1 = new JPanel(new FlowLayout());
        okBtn = new JButton("Ok");

        varName.setHorizontalAlignment(JTextField.RIGHT);

        panel1.add(varName);
        panel1.add(equalLabel);
        panel1.add(varValue);
        panel1.add(okBtn);

        frame.add(panel1);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(600, 300);
        frame.pack();
    }

    @Override
    public void convertToCode(File f) {
        convertToCode(f, true);
    }

    public void convertToCode(File f, boolean varCheck){
        try(FileWriter fw = new FileWriter(f)){
            if(varCheck == false){
                fw.write("Object" + varName.getText() + ";\n");
            }
            fw.write(varName.getText() + " = " + varValue.getText() + ";\n");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Expression();
    }
}
