import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Flowchart {
    private ArrayList order;
    private Stack stack;
    private JFrame frame;
    private JPanel panel, buttonPanel;
    private JButton expression, condition, input, output, loop, start, end;
    private ArrowComponent arrow;
    
    public Flowchart(){
        order = new ArrayList();
        stack = new Stack();
        order.add(start);
        frame = new JFrame("Flowchart");
        panel = new JPanel(new GridLayout(1, 3));
        buttonPanel = new JPanel(new GridLayout(3, 3));

        expression = new JButton("Expression");
        condition = new JButton("If Else");
        input = new JButton("Input");
        output = new JButton("Output");
        loop = new JButton("loop");
        start = new JButton("start");
        end = new JButton("end");

        panel.add(start);
        arrow = new ArrowComponent(end, start);
        panel.add(arrow);
//        panel.add(new JPanel());
        panel.add(end);
        

        buttonPanel.add(input);
        buttonPanel.add(output);
        buttonPanel.add(expression);
        buttonPanel.add(condition);
        buttonPanel.add(loop);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 250, 500, 450);
        frame.setVisible(true);
        
        
    }

    public void GenerateCode(){
        for(Object o: order){
            ((Input)o).convertToCode();
        }
    }
    public ArrayList getOrder() {
        return order;
    }

    public void setOrder(ArrayList order) {
        this.order = order;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }
    public static void main(String[] args) {
        new Flowchart();
    }
}
