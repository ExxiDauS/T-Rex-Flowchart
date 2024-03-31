import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FlowchartController implements ActionListener, WindowListener, MouseListener{
    private FlowchartModel model;
    private Toolkit toolkit;
    private PlaygroundView mainView;
    private LoginViewController loginViewController;
    private ActionShape currentTool;
    private ActionShape current;
    private ActionShape currentShapeSelected;
    private boolean deleteToggle;
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

    public void runFlowchart() {
        //run flowchart
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
            ArrowComponent yesArrow = new ArrowComponent(80);
            ArrowComponent noArrow = new ArrowComponent(80);
            newShape = new DecisionShape(yesArrow, noArrow);
            yesArrow.addMouseListener(this);
            noArrow.addMouseListener(this);
        } else if (currentTool.getClass().equals(new LoopShape().getClass())) {
            ArrowComponent firstArrow = new ArrowComponent(80);
            newShape = new LoopShape(firstArrow);
            firstArrow.addMouseListener(this);
        } else {
            newShape = null;
        }
        newShape.addMouseListener(this);
        ArrowComponent newArrow = new ArrowComponent();
        newArrow.addMouseListener(this);

        if (current.getParent().getClass().equals(DecisionFlow.class)) {
            DecisionFlow pointer = (DecisionFlow) current.getParent();
            if (newShape instanceof DrawFlowchartable){
                pointer.getMainShape().nested();
            }
            ArrayList<Shape> yesOrder = pointer.getMainShape().getYesOrder();
            ArrayList<Shape> noOrder = pointer.getMainShape().getNoOrder();
            if ((yesOrder.indexOf(current) != -1)) {
                int index = yesOrder.indexOf(current);
                yesOrder.add(index+1, newShape);
                yesOrder.add(index+2, newArrow);
            } else if ((noOrder.indexOf(current) != -1)) {
                int index = noOrder.indexOf(current);
                noOrder.add(index+1, newShape);
                noOrder.add(index+2, newArrow);
            } else {
                System.out.println("you fuck up not found to add");
            }
        }
        else if (current.getParent().getClass().equals(LoopFlow.class)) {
            LoopFlow pointer = (LoopFlow) current.getParent();
            if (newShape instanceof DrawFlowchartable){
                pointer.getMainShape().nested();
            }
            ArrayList<Shape> repeatOrder = pointer.getMainShape().getRepeatOrder();
            if ((repeatOrder.indexOf(current) != -1)) {
                int index = repeatOrder.indexOf(current);
                repeatOrder.add(index+1, newShape);
                repeatOrder.add(index+2, newArrow);
            } else {
                System.out.println("you fuck up not found to add");
            }
        }
        else {
            int index = model.getOrder().indexOf(current);
            model.getOrder().add(index+1, newShape);
            model.getOrder().add(index+2, newArrow);
        }
        mainView.getFlowchartPanel().drawFlowchart(model.getOrder());
    }

    public void deleteShape() {
        int index = model.getOrder().indexOf(current);
        model.getOrder().remove(index+1);
        model.getOrder().remove(index);
        mainView.getFlowchartPanel().drawFlowchart(model.getOrder());
    }

    public void deleteSubShape() {
        SubFlow pointer = (SubFlow) current.getParent();
        if (current.equals(pointer.getMainShape())) {
            ((DrawFlowchartable) current).unnested();
            pointer = (SubFlow) pointer.getParent();
        }
        if (pointer instanceof DecisionFlow){
            DecisionFlow DecisionPointer = (DecisionFlow) pointer;
            ArrayList<Shape> yesOrder = DecisionPointer.getMainShape().getYesOrder();
            ArrayList<Shape> noOrder = DecisionPointer.getMainShape().getNoOrder();
            if (yesOrder.indexOf(current) != -1) {
                int index = yesOrder.indexOf(current);
                yesOrder.remove(index + 1);
                yesOrder.remove(index);
            } else {
                int index = noOrder.indexOf(current);
                noOrder.remove(index + 1);
                noOrder.remove(index);
            }
        } else {
            LoopFlow DecisionPointer = (LoopFlow) pointer;
            ArrayList<Shape> repeatOrder = DecisionPointer.getMainShape().getRepeatOrder();
            int index = repeatOrder.indexOf(current);
            repeatOrder.remove(index + 1);
            repeatOrder.remove(index);
        }
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
                boolean isDrawFlowchartable = current instanceof DrawFlowchartable;
                if (!isArrowComponent && !isDrawFlowchartable) {
                    if (current.getParent().equals(mainView.getFlowchartPanel())) {
                        deleteShape();
                    }
                    else {
                        if(current.isInFlowchart()) {deleteSubShape();}
                    }
                }
                else {
                    if (current.getParent().getParent().equals(mainView.getFlowchartPanel())) {
                        deleteShape();
                    }
                    else {
                        if(current.isInFlowchart()) {deleteSubShape();}
                    }
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
