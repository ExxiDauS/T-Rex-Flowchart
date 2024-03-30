import java.util.*;
public class Main {
    public static void main(String[] args) {
        DatabaseConnect test = new DatabaseConnect();
        ArrayList tmp = test.getInput(1);
        for (int i = 0; i < tmp.size(); i++) {
            System.out.println(tmp.get(i));
        }
    }
}
