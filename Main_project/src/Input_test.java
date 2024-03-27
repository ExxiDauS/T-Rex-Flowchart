//this is file for test the input process
import java.io.*;
public class Input_test {
    public static void main(String[] args) {
        File f = new File("test.txt");
        Input input = new Input();
        input.convertToCode(f);
    }
}
