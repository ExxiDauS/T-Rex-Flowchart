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
            String line;
            int i = 0;
            while ((line = r.readLine()) != null) {
                sb.append(line);
                sb.append(System.getProperty("line.separator"));
                i += 1;
            }
            String result = sb.toString();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList checkResult(File f) {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "java " + f.getAbsolutePath());
        ArrayList codeResult = new ArrayList();
//        TODO : connect testcase with DB
        ArrayList testcase = new ArrayList();
        try {
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            int i = 0;
            while ((line = r.readLine()) != null) {
//                for test
//                    System.out.println(line);
//                    System.out.println(testcase.get(i).equals(line));
                    if (i < testcase.size()) {
                        codeResult.add(testcase.get(i).equals(line));
                    }
                    i += 1;
                }
            return codeResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
