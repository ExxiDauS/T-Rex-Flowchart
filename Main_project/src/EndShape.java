import java.awt.*;
import javax.swing.*;
import java.io.*;

public class EndShape extends Shape{
    @Override
    public void convertToCode(File f) {
        if (f.exists()){
            try (FileWriter fw = new FileWriter(f, true)){
                fw.write("} catch (Exception e) {\n");
                fw.write("e.printStackTrace(); }\n");
                fw.write("}\n");
                fw.write("}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Please contact developer of this project.");
        }
    }
}
