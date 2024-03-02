import java.util.*;
public class Flowchart {
    private ArrayList order;
    private Stack stack;
    private Start start;
    public Flowchart(){
        order = new ArrayList();
        stack = new Stack();
        order.add(start);
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
}
