import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class FlowchartController implements ActionListener, WindowListener{
    private FlowchartModel model;
    private PlaygroundView mainView;
    private TopBarPanel topBarPanel;
    private LoginViewController loginViewController;

    public FlowchartController() {
        model = new FlowchartModel();
        mainView = new PlaygroundView();
        init();
    }

    public void init() {
        topBarPanel = mainView.getToolPanel();
        topBarPanel.getRunButton().addActionListener(this);
        topBarPanel.getLoginButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(topBarPanel.getRunButton())) {
            runFlowchart();
        }
        else if (ae.getSource().equals(topBarPanel.getLoginButton())) {
            loginViewController = new LoginViewController(model);
            loginViewController.getLoginView().getFrame().addWindowListener(this);
        }
    }

    public FlowchartModel getModel(){
        return this.model;
    }
    public void runFlowchart() {
        //run flowchart
        ArrayList<Shape> flowchart =  model.getOrder();
        File f = new File("trex.java");
        for(int i=0;i<flowchart.size();i++){
            flowchart.get(i).convertToCode(f);
        }
    }


    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent we) {
        if (we.getSource().equals(loginViewController.getLoginView().getFrame())) {
            if (!model.getStatus().equals("play")) {
                topBarPanel.getLoginButton().setText(model.getUsername());
                topBarPanel.getLoginButton().setEnabled(false);
            }
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        new FlowchartController();
    }
}
