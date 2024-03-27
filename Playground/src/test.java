import java.util.ArrayList;
public class test {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(a);
        a.add(2, 4);
        System.out.println(a);
    }
}
