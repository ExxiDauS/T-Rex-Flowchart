import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class FlowchartController implements ActionListener, WindowListener, MouseListener{
    private FlowchartModel model;
    private Toolkit toolkit;
    private PlaygroundView mainView;
    private LoginViewController loginViewController;
    private ActionShape currentTool;
    private ActionShape current;
    private ActionShape currentShapeSelected;
    private boolean deleteToggle;
//    private Grader grader;
    public FlowchartController() {
        model = new FlowchartModel();
        mainView = new PlaygroundView();
        init();
    }

    public void init() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        current = null;
        currentTool = null;
        currentShapeSelected = null;
        deleteToggle = false;
        mainView.getToolPanel().getRunButton().addActionListener(this);
        mainView.getToolPanel().getLoginButton().addActionListener(this);
        mainView.getToolPanel().getDeleteToggleBtn().addActionListener(this);
        mainView.getShapePanel().getProcessShape().addMouseListener(this);
        mainView.getShapePanel().getInputShape().addMouseListener(this);
        mainView.getShapePanel().getOutputShape().addMouseListener(this);
        mainView.getShapePanel().getDecisionShape().addMouseListener(this);
        mainView.getShapePanel().getLoopShape().addMouseListener(this);

        model.getOrder().add(new StartShape());
        ArrowComponent firstArrow = new ArrowComponent();
        firstArrow.addMouseListener(this);
        model.getOrder().add(firstArrow);
        model.getOrder().add(new EndShape());

        mainView.getFlowchartPanel().drawFlowchart(model.getOrder());
    }

    public void paintClicked(Object source) {
        current.paintWhenClicked();
        if (!current.isInFlowchart()) {
            boolean isSame = current.equals(currentTool);
            currentTool = current;
            mainView.getShapePanel().paintCurrentTool(currentTool);
            if (isSame) {currentTool = null;}
        }
        else {
            //after config
        }
    }

    public void addShape() {
        ActionShape newShape;
        if (currentTool.getClass().equals(new ProcessShape().getClass())) {
            newShape = new ProcessShape();
        } else if (currentTool.getClass().equals(new InputShape().getClass())) {
            newShape = new InputShape();
        } else if (currentTool.getClass().equals(new OutputShape().getClass())) {
            newShape = new OutputShape();
        } else if (currentTool.getClass().equals(new DecisionShape().getClass())) {
            newShape = new DecisionShape();
        } else if (currentTool.getClass().equals(new LoopShape().getClass())) {
            newShape = new LoopShape();
        } else {
            newShape = null;
        }
        newShape.addMouseListener(this);
        ArrowComponent newArrow = new ArrowComponent();
        newArrow.addMouseListener(this);
        int index = model.getOrder().indexOf(current);
        model.getOrder().add(index+1, newShape);
        model.getOrder().add(index+2, newArrow);
        mainView.getFlowchartPanel().drawFlowchart(model.getOrder());
    }

    public void deleteShape() {
        int index = model.getOrder().indexOf(current);
        mainView.getFlowchartPanel().shapeDelete((ActionShape) model.getOrder().get(index), (ArrowComponent) model.getOrder().get(index + 1));
        model.getOrder().remove(index + 1);
        model.getOrder().remove(index);
        mainView.getFlowchartPanel().drawFlowchart(model.getOrder());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(mainView.getToolPanel().getRunButton())) {
            runFlowchart();
        }
        else if (ae.getSource().equals(mainView.getToolPanel().getLoginButton())) {
            loginViewController = new LoginViewController(model);
            loginViewController.getLoginView().getFrame().addWindowListener(this);
        }
        else if (ae.getSource().equals(mainView.getToolPanel().getDeleteToggleBtn())) {
            deleteToggle = !deleteToggle;
            BarCustomButton pointer = (BarCustomButton) (mainView.getToolPanel().getDeleteToggleBtn());
            if (deleteToggle) {
                pointer.setText("Delete: ON");
                pointer.setColor(new Color(233, 17, 69));
            }
            else {
                pointer.setText("Delete: OFF");
                pointer.setColor(new Color(0,102,204));
            }
        }
    }

    public FlowchartModel getModel(){
        return this.model;
    }
    public void runFlowchart() {
        //run flowchart
        ArrayList<Shape> flowchart =  model.getOrder();
        File f = new File("trex.java");
        for(int i=0;i<flowchart.size();i++) {
            if(!flowchart.get(i).getClass().equals(ArrowComponent.class)){
                flowchart.get(i).convertToCode(f);
            }
        }
    }
    
//    private void runGrader(){
//        ArrayList<Shape> flowchart = model.getOrder();
//        File f = new File("trex.java");
////        !!Don't forget to change.
//        int problemID = probModel.getProblemID();
//        int iTmp = 0;
//        String varName = "x";
//        ArrayList result = new ArrayList();
//        for (int j = 0; j < probModel.getProblemTestCasesCount(problemID); j++) {
//            for(int i=0;i<flowchart.size();i++) {
//                if(!flowchart.get(i).getClass().equals(ArrowComponent.class)){
//                    if (flowchart.get(i).getClass().equals(InputShape.class)) {
//                        try (FileWriter fOut = new FileWriter(f)){
//                            for (int k = 0; k < model.getInput(problemID + j).size(); k++) {
//                                if (model.getInputType(problemID + j).get(iTmp).equals("String")) {
//                                    fOut.write(model.getInputType(problemID + j).get(iTmp) + " " + varName + " = " +  "\"" + model.getInput(problemID + j).get(iTmp) + "\"" + ";" + "\n");
//                                }
//                                else{
//                                    fOut.write(model.getInputType(problemID + j).get(iTmp) + " " + varName + " = " + model.getInput(problemID + j).get(iTmp) + ";" + "\n");
//                                }
//                                iTmp += 1;
//                                varName = "x" + iTmp;
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    else{
//                        flowchart.get(i).convertToCode(f);
//                    }
//                }
//            }
//            if (grader.checkResult(f, problemID + j).contains(false)) {
//                result.add(false);
//            }
//            else{
//                result.add(true);
//            }
//        }
//    }

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
                mainView.getToolPanel().getLoginButton().setText(model.getUsername());
                mainView.getToolPanel().getLoginButton().setEnabled(false);
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
        boolean isArrowComponent = source.getClass().equals(new ArrowComponent().getClass());
        if (isActionShape) {
            current = (ActionShape) source;
            if (!deleteToggle) {
                if (!isArrowComponent) {
                    paintClicked(source);
                }
                else {
                    if (!(currentTool==(null))) {
                        addShape();
                    }
                }
            }
            else {
                if (!isArrowComponent && current.isInFlowchart()) {
                    deleteShape();
                }
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
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        new FlowchartController();
    }
}
