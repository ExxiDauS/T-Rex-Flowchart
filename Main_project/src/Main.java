import java.util.*;
public class Main {
    public static void main(String[] args) {
        DatabaseConnect test = new DatabaseConnect();
        ArrayList x = test.getAllProblem();
//        System.out.println(x);
        problem tmp = (problem) x.get(0);
        System.out.println(tmp.getTestCase());
    }
}
