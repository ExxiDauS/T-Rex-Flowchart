import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TopBarPanel extends JPanel{
    private BarCustomButton loginBtn;
    private BarCustomButton runBtn;
    private BarCustomButton deleteToggleBtn;
    private BarCustomButton saveBtn;
    private BarCustomButton loadBtn;
    private JPanel leftAlign, rightAlign;
    public TopBarPanel(){
        setBorder(new LineBorder(new Color(204,204,204)));
        setLayout(new GridLayout(1,2));
        leftAlign = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        rightAlign = new JPanel(new FlowLayout(FlowLayout.RIGHT, 40, 10));
        loginBtn = new BarCustomButton();
        loginBtn.setText("Login");
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setColor(new Color(76, 175, 80));
        runBtn = new BarCustomButton();
        runBtn.setText("Run");
        runBtn.setForeground(Color.WHITE);
        runBtn.setColor(new Color(0,150,136));
        deleteToggleBtn = new BarCustomButton();
        deleteToggleBtn.setText("Delete: OFF");
        deleteToggleBtn.setForeground(Color.WHITE);
        deleteToggleBtn.setColor(new Color(0,150,136));
        saveBtn = new BarCustomButton();
        saveBtn.setText("Save");
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setColor(new Color(0, 150, 136));
        loadBtn = new BarCustomButton();
        loadBtn.setText("Load");
        loadBtn.setForeground(Color.WHITE);
        loadBtn.setColor(new Color(0, 150, 136));
        leftAlign.add(runBtn);
        leftAlign.add(deleteToggleBtn);
        leftAlign.add(saveBtn);
        leftAlign.add(loadBtn);
        rightAlign.add(loginBtn);
        leftAlign.setOpaque(false);
        rightAlign.setOpaque(false);
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

    public JButton getSaveBtn() {
        return saveBtn;
    }
    public JButton getLoadBtn() {return loadBtn;};
}
