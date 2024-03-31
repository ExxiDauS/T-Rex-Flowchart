import java.io.*;
public class Output implements Shape{
    private boolean isChecked = false;
    private String prompt = "";
    
    public boolean getIsChecked() {
        return isChecked;
    }
    
    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
    
    public String getPrompt() {
        return prompt;
    }
    
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    
    
    
    // when you merge it to playground please delele while loop and GUI, and set GUI to DoubleClickedEvent on shape
    @Override
    public void convertToCode(File f) {
        if (f.exists()) {
            try (FileWriter fOut = new FileWriter(f, true);)
            {
                Output_GUI output = new Output_GUI(this);
                while(!output.get_setted()) {System.out.println("");}
                if (getIsChecked()) {
                    fOut.write("System.out.println(" + prompt + ");");
                }
                else {
                    fOut.write("System.out.print(" + prompt + ");");
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}