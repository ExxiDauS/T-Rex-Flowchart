import java.io.*;

public class Input implements Shape{
    private String type;
    private String name;
    private Object value;

    // Default constructor
    public Input() {
        this.type = "";
        this.name = "";
        this.value = null;
    }

    // Parameterized constructor
    public Input(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    // Getter methods
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
    
    @Override
    public void convertToCode(File f) {
        if (f.exists()) {
            try (FileWriter fOut = new FileWriter(f, true);)
            {
                Input_Enter_GUI enter = new Input_Enter_GUI(this);
                Input_Run_GUI run = new Input_Run_GUI(this);
                while(!run.get_setted()) {System.out.println("");};
                if(this.getType().equals("String")) {
                    fOut.write(this.getType() + " " + this.getName() + " = " +  "\"" + this.getValue() + "\"" + ";" + "\n");
                }
                else {
                    fOut.write(this.getType() + " " + this.getName() + " = " + this.getValue() + ";" + "\n");
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}