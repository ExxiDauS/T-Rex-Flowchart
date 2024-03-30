import java.io.*;
public class ConsoleController {
    private ConsoleView cView;
    private ConsoleModel cModel;
    private Grader grader;
    public ConsoleController(){
        cModel = new ConsoleModel();
        cView = new ConsoleView();
        grader = new Grader();
    }
    public void whenRunClicked(){
        File f = new File("ThisIsATestFile.java");
        if(f.exists()){
            cModel.getLogData().add(grader.run(f));
            cView.refresh(cModel.getLogData());
        }
    }

    public static void main(String[] args) {
        new ConsoleController();
    }
}
