import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test implements ActionListener{
    private JFrame jf;
    private JPanel jp;
    private JButton runBtn;
    private String fileName = "test";
    private File file = new File("C:\\Users\\kitti\\Downloads\\" + fileName + ".java");
    Start start;
    End end;

    public test() {
        jf = new JFrame();
        jp = new JPanel(new GridLayout(3, 1));
        runBtn = new JButton("Run");
        start = new Start();
        end = new End();
        runBtn.addActionListener(this);
        jp.add(start.getJp());
        jp.add(end.getJp());
        jp.add(runBtn);
        jf.add(jp);
        jf.setSize(1920, 1080);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == runBtn) {
            start.convertToCode(file);

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "java C:\\Users\\User\\Downloads\\" + fileName + ".java");
            builder.redirectErrorStream(true);
            try {
                Process p = builder.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while (true) {
                    line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println(line);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new test();
    }
}
