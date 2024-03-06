
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drag and Drop Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Drag me!");
        label.setBounds(50, 50, 100, 50);
        label.setTransferHandler(new TransferHandler("text"));

        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
    }
}
