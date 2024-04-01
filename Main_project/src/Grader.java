import java.io.*;
import java.util.ArrayList;

public class Grader {
    public String run(File f){
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "java " + f.getAbsolutePath());
        StringBuilder sb = new StringBuilder();
        ArrayList test = new ArrayList();
        try {
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader e = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String line;
            int i = 0;
            while ((line = r.readLine()) != null) {
                sb.append(line);
                sb.append(System.getProperty("line.separator"));
                i += 1;
            }
            while ((line = e.readLine()) != null) {
                if (i >= 1) {
                    sb.append(line);
                    sb.append(System.getProperty("line.separator"));
                }
                i += 1;
            }
            String result = sb.toString();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
