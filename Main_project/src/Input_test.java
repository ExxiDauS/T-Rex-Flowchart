
public class Input_test{
    public static void main(String[] args) {
         Input input = new Input(); // Create shared input object
        Input_Enter_GUI enter = new Input_Enter_GUI(input); // Pass input object to Enter GUI
        Input_Run_GUI run = new Input_Run_GUI(input); // Pass input object to Run GUI
    }
}
