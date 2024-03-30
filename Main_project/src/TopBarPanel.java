import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TopBarPanel extends JPanel{
    private BarCustomButton loginBtn;
    private BarCustomButton runBtn;
    private BarCustomButton deleteToggleBtn;
    private JPanel leftAlign, rightAlign;
    public TopBarPanel(){
        setBackground(new Color(234,234,234));
        setBorder(new LineBorder(new Color(204,204,204)));
        setLayout(new GridLayout(1,2));
        leftAlign = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 10));
        rightAlign = new JPanel(new FlowLayout(FlowLayout.RIGHT, 40, 10));
        loginBtn = new BarCustomButton();
        loginBtn.setText("Login");
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setColor(new Color(76, 175, 80));
        runBtn = new BarCustomButton();
        runBtn.setText("Run");
        runBtn.setForeground(Color.WHITE);
        deleteToggleBtn = new BarCustomButton();
        deleteToggleBtn.setText("Delete: OFF");
        deleteToggleBtn.setForeground(Color.WHITE);
        deleteToggleBtn.setColor(new Color(0,102,204));
        runBtn.setColor(new Color(33, 150, 243));
        leftAlign.add(runBtn);
        leftAlign.add(deleteToggleBtn);
        rightAlign.add(loginBtn);
        add(leftAlign);     add(rightAlign);
    }

    public JButton getLoginButton() {
        return loginBtn;
    }

    public JButton getRunButton() {
        return runBtn;
    }

    public JButton getDeleteToggleBtn() {
        return deleteToggleBtn;
    }
}
