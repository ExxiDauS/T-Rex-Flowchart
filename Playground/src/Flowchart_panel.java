import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Flowchart_panel extends JPanel{
    private ArrayList order = new ArrayList();
    private Start_Shape start;
    private End_Shape end;
    private ArrowComponent firstarrow;
    public Flowchart_panel(){
        start = new Start_Shape();
        end = new End_Shape();
        firstarrow = new ArrowComponent(this);
        start.setBounds(100, 5, 103, 53);
        end.setBounds(100, 94, 103, 53);
        firstarrow.setBounds(145, 53, 10, 43);
        this.add(start);
        this.add(end);
        this.add(firstarrow);
        order.add(start);
        order.add(firstarrow);
        order.add(end);
    }
    public void addShape(JPanel shape, int index) {
        this.add(shape);
        order.add(index, shape);
        checkBoundsAndAdjustPanel(shape);
        this.repaint();
    }

    public void deleteProcessShape(JPanel shape){
        int index = order.indexOf(shape);
        for(int i = index+2; i < order.size(); i++){
            JPanel pa = (JPanel)(order.get(i));
            pa.setLocation(pa.getX(), pa.getY() - 92);
            checkBoundsAndAdjustPanel(pa);
        }
        this.remove((Component) order.get(index));
        this.remove((Component) order.get(index+1));
        order.remove(index);
        order.remove(index);
        repaint();
    }
    public void deleteInputShape(JPanel shape){
        int index = order.indexOf(shape);
        for(int i = index+2; i < order.size(); i++){
            JPanel pa = (JPanel)(order.get(i));
            pa.setLocation(pa.getX(), pa.getY() - 84);
            checkBoundsAndAdjustPanel(pa);
        }
        this.remove((Component) order.get(index));
        this.remove((Component) order.get(index+1));
        order.remove(index);
        order.remove(index);
        repaint();
    }
    public void deleteOutputShape(JPanel shape){
        int index = order.indexOf(shape);
        for(int i = index+2; i < order.size(); i++){
            JPanel pa = (JPanel)(order.get(i));
            pa.setLocation(pa.getX(), pa.getY() - 84);
            checkBoundsAndAdjustPanel(pa);
        }
        this.remove((Component) order.get(index));
        this.remove((Component) order.get(index+1));
        order.remove(index);
        order.remove(index);
        repaint();
    }
    public void checkBoundsAndAdjustPanel(JPanel shape) {
        Rectangle bounds = shape.getBounds();
        Dimension panelSize = getPreferredSize();

        if (bounds.x + bounds.width > panelSize.width || bounds.y + bounds.height > panelSize.height) {
            int newWidth = Math.max(panelSize.width, bounds.x + bounds.width);
            int newHeight = Math.max(panelSize.height, bounds.y + bounds.height);
            setPreferredSize(new Dimension(newWidth, newHeight));
            revalidate();

            // Scroll to the added shape
            JViewport viewport = (JViewport) getParent();
            Rectangle rect = bounds;
            viewport.scrollRectToVisible(rect);
        }
        else if(bounds.x < 0 || bounds.y < 0){
            System.out.println("OKIE");
            System.out.println(bounds.x + " " + panelSize.width);
            System.out.println(panelSize);
            for (Component comp : getComponents()){
                comp.setLocation(comp.getX() + 15, comp.getY());
                
            }
        }
    }    
//    private void checkBoundsAndAdjustPanel(JPanel shape) {
//        Rectangle bounds = shape.getBounds();
//        Dimension panelSize = getPreferredSize();
//
//        int newX = Math.min(bounds.x, 0);
//        int newY = Math.min(bounds.y, 0);
//        int newWidth = Math.max(panelSize.width, bounds.x + bounds.width - newX);
//        int newHeight = Math.max(panelSize.height, bounds.y + bounds.height - newY);
//
//        if (newWidth != panelSize.width || newHeight != panelSize.height || newX < 0 || newY < 0) {
//            setPreferredSize(new Dimension(newWidth, newHeight));
//            revalidate();
//
//            // Scroll to the added shape
//            JViewport viewport = (JViewport) getParent();
//            Rectangle rect = new Rectangle(-newX, -newY, bounds.width, bounds.height);
//            viewport.scrollRectToVisible(rect);
//        }
//    }
    public ArrayList getOrder(){
        return order;
    }
    public End_Shape getEnd(){
        return end;
    }
    public Start_Shape getStart(){
        return start;
    }
    public void run(){
        System.out.println(order);
    }
}
