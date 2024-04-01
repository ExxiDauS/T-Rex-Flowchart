import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TopBarPanel extends JPanel{
    private BarCustomButton loginBtn;
    private BarCustomButton runBtn;
    private BarCustomButton deleteToggleBtn;
    private BarCustomButton saveBtn;
    private BarCustomButton loadBtn;
    private BarCustomButton quizBtn;
    private JPanel leftAlign, rightAlign;
    private boolean quizVisibilty;
    public TopBarPanel(){
        quizVisibilty = false;
        setBorder(new LineBorder(new Color(204,204,204)));
        setLayout(new GridLayout(1,2));
        leftAlign = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        rightAlign = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
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
        quizBtn = new BarCustomButton();
        quizBtn.setText("No More Problems");
        quizBtn.setForeground(Color.WHITE);
        quizBtn.setColor(new Color(21, 101, 192));
        quizBtn.setVisible(false);
        leftAlign.add(runBtn);
        leftAlign.add(deleteToggleBtn);
        leftAlign.add(saveBtn);
        leftAlign.add(loadBtn);
        rightAlign.add(quizBtn);
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

    public BarCustomButton getQuizBtn() {
        return quizBtn;
    }
}
