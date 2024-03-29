import java.awt.*;
import javax.swing.*;
import java.io.*;

public class StartShape extends Shape{

    @Override
    public void convertToCode(File f) {
        if (f.exists()){
            f.delete();
            try (FileWriter fw = new FileWriter(f)){
                String fileNameWithOutExt = f.getName().replaceFirst("[.][^.]+$", "");
                fw.write("public class " + fileNameWithOutExt + " {\n");
                fw.write("public static void main(String[] args) {\n");
                fw.write("try { \n");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try (FileWriter fw = new FileWriter(f)){
                String fileNameWithOutExt = f.getName().replaceFirst("[.][^.]+$", "");
                fw.write("public class " + fileNameWithOutExt + " {\n");
                fw.write("public static void main(String[] args) {\n");
                fw.write("try { \n");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
