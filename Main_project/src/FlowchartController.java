import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class FlowchartController implements ActionListener, WindowListener, MouseListener{
    private FlowchartModel model;
    private PlaygroundView mainView;
    private TopBarPanel topBarPanel;
    private LoginViewController loginViewController;
    private ActionShape currentTool;
    private ActionShape current;

    public FlowchartController() {
        model = new FlowchartModel();
        mainView = new PlaygroundView();
        init();
    }

    public void init() {
        current = null;
        currentTool = null;
        topBarPanel = mainView.getToolPanel();
        topBarPanel.getRunButton().addActionListener(this);
        topBarPanel.getLoginButton().addActionListener(this);
        mainView.getShapePanel().getProcessShape().addMouseListener(this);
        mainView.getShapePanel().getInputShape().addMouseListener(this);
        mainView.getShapePanel().getOutputShape().addMouseListener(this);
        mainView.getShapePanel().getDecisionShape().addMouseListener(this);
        mainView.getShapePanel().getLoopShape().addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        boolean isActionShape = ActionShape.class.isAssignableFrom(source.getClass());
        if (isActionShape) {
            current = (ActionShape) source;
            current.paintWhenClicked();
            if (!current.isInFlowchart()) {
                boolean isSame = current.equals(currentTool);
                currentTool = current;
                mainView.getShapePanel().paintCurrentTool(currentTool);
                if (isSame) {currentTool = null;}
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new FlowchartController();
    }
}
