import java.util.ArrayList;

public abstract class ContainerShape extends ActionShape{
    protected ArrayList<Shape> subOrder;
    public ArrayList<Shape> getSubOrder() {
        return subOrder;
    }
}
