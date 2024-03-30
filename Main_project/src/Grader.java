import java.io.*;
import java.util.ArrayList;

public class Grader {
    private DatabaseConnect databaseConnect;
    public ArrayList checkResult(File f, int questionID) {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "java " + f.getAbsolutePath());
        ArrayList codeResult = new ArrayList();
//        TODO : connect testcase with DB
        ArrayList testcase = databaseConnect.getOutput(questionID);
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
