import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    // Method to check if the entered value matches the specified data type
    public boolean checkValueType() {
        if (type.equals("int")) {
            return value instanceof Integer;
        } else if (type.equals("double")) {
            return value instanceof Double;
        } else if (type.equals("String")) {
            return value instanceof String;
        }
        return false;
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
            try (FileReader fIn = new FileReader(f);
                    FileWriter fOut = new FileWriter(f, true);)
            {
                Input_Enter_GUI enter = new Input_Enter_GUI(this);
                Input_Run_GUI run = new Input_Run_GUI(this);
                fOut.write(this.getType() + " " + this.getName() + " = " + this.getValue() + ";");
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            }
            try (FileReader fIn = new FileReader(f);
                    FileWriter fOut = new FileWriter(f, true);)
            {
                Input_Enter_GUI enter = new Input_Enter_GUI(this);
                Input_Run_GUI run = new Input_Run_GUI(this);
                fOut.write(this.getType() + " " + this.getName() + " = " + this.getValue() + ";");
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}