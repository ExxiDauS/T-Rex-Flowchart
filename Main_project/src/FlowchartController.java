import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class FlowchartController implements ActionListener, WindowListener, MouseListener{
    private FlowchartModel model;
    private Toolkit toolkit;
    private PlaygroundView mainView;
    private LoginViewController loginViewController;
    private ActionShape currentTool;
    private ActionShape current;
    private boolean deleteToggle;
    private StartShape start;
    private ArrowComponent firstArrow;
    private EndShape end;
    private ArrayList<ShapeGUI> activeGUI;
    public FlowchartController() {
        model = new FlowchartModel();
        mainView = new PlaygroundView();
        init();
    }

    public void init() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        current = null;
        currentTool = null;
        deleteToggle = false;
        activeGUI = new ArrayList<ShapeGUI>();
        mainView.getToolPanel().getRunButton().addActionListener(this);
        mainView.getToolPanel().getLoginButton().addActionListener(this);
        mainView.getToolPanel().getDeleteToggleBtn().addActionListener(this);
        mainView.getToolPanel().getSaveBtn().addActionListener(this);
        mainView.getToolPanel().getLoadBtn().addActionListener(this);
        mainView.getShapePanel().getProcessShape().addMouseListener(this);
        mainView.getShapePanel().getInputShape().addMouseListener(this);
        mainView.getShapePanel().getOutputShape().addMouseListener(this);
        mainView.getShapePanel().getDecisionShape().addMouseListener(this);
        mainView.getShapePanel().getLoopShape().addMouseListener(this);

        start = new StartShape();
        firstArrow = new ArrowComponent();
        firstArrow.addMouseListener(this);
        end = new EndShape();
        model.getOrder().add(start);
        model.getOrder().add(firstArrow);
        model.getOrder().add(end);
        mainView.getFlowchartPanel().drawFlowchart(model.getOrder());
    }

    public void paintClicked(Object source) {
        if (!current.isInFlowchart()) {
            current.paintWhenClicked();
            boolean isSame = current.equals(currentTool);
            currentTool = current;
            mainView.getShapePanel().paintCurrentTool(currentTool);
            if (isSame) {currentTool = null;}
        }
    }

    public void openGUI(ActionShape actionShape) {
        ShapeGUI GUI = actionShape.getAssociatedGUI();
        if (GUI == null) {
            if (actionShape instanceof ProcessShape) {
                GUI = new ProcessGUI(actionShape);
            } else if (actionShape instanceof InputShape) {
                GUI = new InputGUI(actionShape);
            } else if (actionShape instanceof OutputShape) {
                GUI = new OutputGUI(actionShape);
            } else if (actionShape instanceof DecisionShape) {
                GUI = new DecisionGUI(actionShape);
            } else if (actionShape instanceof LoopShape) {
                GUI = new LoopGUI(actionShape);
            }
            actionShape.setAssociatedGUI(GUI);
            activeGUI.add(GUI);
            GUI.getDoneBtn().addActionListener(this);
            GUI.getFrame().addWindowListener(this);
        }
        else {
            GUI.getFrame().toFront();
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
                System.out.println("Error");
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

    public void listenToNewModel(Shape shape) {
        shape.addMouseListener(this);
        if (shape instanceof DecisionShape) {
            for (Shape innerShape : ((DecisionShape) shape).getYesOrder()) {
                listenToNewModel(innerShape);
            }
            for (Shape innerShape : ((DecisionShape) shape).getNoOrder()) {
                listenToNewModel(innerShape);
            }
        }
        else if (shape instanceof LoopShape) {
            for (Shape innerShape : ((LoopShape) shape).getRepeatOrder()) {
                listenToNewModel(innerShape);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!(ae.getSource() instanceof DoneCustomButton)) {
            if (ae.getSource().equals(mainView.getToolPanel().getRunButton())) {
//            runFlowchart();
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
                    pointer.setColor(new Color(0,150,136));
                }
            }
            else if (ae.getSource().equals(mainView.getToolPanel().getSaveBtn())) {
                JFileChooser fc = new JFileChooser("Documents\\");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TVSC", "tvsc");
                fc.setFileFilter(filter);
                File f;
                int result = fc.showSaveDialog(mainView);
                if (String.valueOf(fc.getSelectedFile()).contains(".tvsc")) {
                    f = new File(String.valueOf(fc.getSelectedFile()));
                } else {
                    f = new File(String.valueOf(fc.getSelectedFile()) + ".tvsc");
                }
                if (result == JFileChooser.APPROVE_OPTION) {
                    model.saveModel(f);
                }
            }
            else if (ae.getSource().equals(mainView.getToolPanel().getLoadBtn())) {
                JFileChooser fc = new JFileChooser("Documents\\");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TVSC", "tvsc");
                fc.setFileFilter(filter);
                int result = fc.showOpenDialog(mainView);
                File f = fc.getSelectedFile();
                if (result == JFileChooser.APPROVE_OPTION) {
                    model.loadModel(f);
                }
                for (Shape shape : model.getOrder()) {
                    boolean isStarter = (shape.equals(start) || shape.equals(firstArrow) || shape.equals(end));
                    if (!isStarter) {listenToNewModel(shape);}
                }
                mainView.getFlowchartPanel().drawFlowchart(model.getOrder());
            }
        }
        else {
            for (ShapeGUI GUI: activeGUI) {
                if (GUI.getDoneBtn().equals(ae.getSource())) {
                    GUI.configShape();
                    mainView.getFlowchartPanel().drawFlowchart(model.getOrder());
                    GUI.getFrame().dispose();
                }
            }
        }

    }

    @Override
    public void windowClosing(WindowEvent e) {
    }
    @Override
    public void windowOpened(WindowEvent e) {

    }

    public boolean removingGUI(WindowEvent we) {
        boolean isRemovingGUI = false;
        for (ShapeGUI GUI: activeGUI) {
            if (GUI.getFrame().equals(we.getSource())) {
                GUI.getHost().setAssociatedGUI(null);
                activeGUI.remove(GUI);
                isRemovingGUI = true;
                break;
            }
        }
        return isRemovingGUI;
    }
    @Override
    public void windowClosed(WindowEvent we) {
        if (!removingGUI(we)) {
            if (we.getSource().equals(loginViewController.getLoginView().getFrame())) {
                if (!model.getStatus().equals("play")) {
                    mainView.getToolPanel().getLoginButton().setText(model.getUsername());
                    mainView.getToolPanel().getLoginButton().setEnabled(false);
                }
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
        if (e.getClickCount() < 2){
            if (isActionShape) {
                current = (ActionShape) source;
                if (!deleteToggle) {
                    if (!isArrowComponent) {
                        paintClicked(source);
                    } else {
                        if (!(currentTool == (null))) {
                            addShape();
                        }
                    }
                } else {
                    boolean isDrawFlowchartable = current instanceof DrawFlowchartable;
                    if (!isArrowComponent && !isDrawFlowchartable) {
                        if (current.getParent().equals(mainView.getFlowchartPanel())) {
                            deleteShape();
                        } else {
                            if (current.isInFlowchart()) {
                                deleteSubShape();
                            }
                        }
                    } else if (isDrawFlowchartable) {
                        if (current.getParent().getParent().equals(mainView.getFlowchartPanel())) {
                            deleteShape();
                        } else {
                            if (current.isInFlowchart()) {
                                deleteSubShape();
                            }
                        }
                    }
                }
            }
        }
        else {
            if (isActionShape && !isArrowComponent) {
                current = (ActionShape) source;
                if (current.isInFlowchart()) {
                    openGUI(current);
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
