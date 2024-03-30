import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
public class ConsoleView {
    private JFrame frame;
    private JTextArea log;
    private JScrollPane scPane;
    public ConsoleView(){
        frame = new JFrame();
        log = new JTextArea();
        scPane = new JScrollPane(log);

        frame.add(scPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(273, 444);
        frame.setVisible(true);
    }
    public void refresh(ArrayList data){
        log.setText("");
        for(int i=0;i< data.size();i++){
            log.setText(log.getText() + data.get(i) + "------- Finish --------\n");
        }
    }
}
