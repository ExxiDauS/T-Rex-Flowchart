import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ShapePanel extends JPanel{
    private ProcessShape processShape;
    private InputShape inputShape;
    private OutputShape outputShape;
    private DecisionShape decisionShape;
    private LoopShape loopShape;


    public ShapePanel(Dimension frameSize) {
        //init shape
        processShape = new ProcessShape(new Dimension((int)frameSize.getWidth()/5,(int)(frameSize.getHeight()/2)-60));
        inputShape = new InputShape(new Dimension((int)frameSize.getWidth()/5,(int)(frameSize.getHeight()/2)-60));
        outputShape = new OutputShape(new Dimension((int)frameSize.getWidth()/5,(int)(frameSize.getHeight()/2)-60));
        decisionShape = new DecisionShape(new Dimension((int)frameSize.getWidth()/5,(int)(frameSize.getHeight()/2)-60));
        loopShape = new LoopShape(new Dimension((int)frameSize.getWidth()/5,(int)(frameSize.getHeight()/2)-60));


        //action shape setting
        processShape.isNotInFlowchart();
        inputShape.isNotInFlowchart();
        outputShape.isNotInFlowchart();
        decisionShape.isNotInFlowchart();
        loopShape.isNotInFlowchart();

        //panel setting
        setBackground(new Color(234,234,234));
        setBorder(new LineBorder(new Color(204, 204, 204)));


        //layout setting
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets((int)((frameSize.getHeight()/2)-60)/50, 0, (int)((frameSize.getHeight()/2)-60)/50, 0);
        add(processShape, gbc);
        gbc.gridy = 1;
        add(inputShape, gbc);
        gbc.gridy = 2;
        add(outputShape, gbc);
        gbc.gridy = 3;
        add(decisionShape, gbc);
        gbc.gridy = 4;
        add(loopShape, gbc);
    }

    public void paintCurrentTool(ActionShape current) {
        if (processShape.isClicked() && !processShape.equals(current)) {
            processShape.paintWhenClicked();
        } else if (inputShape.isClicked() && !inputShape.equals(current)) {
            inputShape.paintWhenClicked();
        } else if (outputShape.isClicked() && !outputShape.equals(current)) {
            outputShape.paintWhenClicked();
        } else if (decisionShape.isClicked() && !decisionShape.equals(current)) {
            decisionShape.paintWhenClicked();
        } else if (loopShape.isClicked() && !loopShape.equals(current)) {
            loopShape.paintWhenClicked();
        }
    }

    public ProcessShape getProcessShape() {
        return processShape;
    }

    public InputShape getInputShape() {
        return inputShape;
    }

    public OutputShape getOutputShape() {
        return outputShape;
    }

    public DecisionShape getDecisionShape() {
        return decisionShape;
    }

    public LoopShape getLoopShape() {
        return loopShape;
    }
}
