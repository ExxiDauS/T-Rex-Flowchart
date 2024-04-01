import java.io.*;
import java.util.*;

public class FlowchartModel {
    private ArrayList<Shape> order;
    private String username;
    private String status;
    private DatabaseConnect databaseConnect;
    private ArrayList<String> logData;

    public FlowchartModel() {
        order = new ArrayList<Shape>();
        databaseConnect = new DatabaseConnect();
        username = "";
        status = "play";
        logData = new ArrayList<>();
    }

    public boolean logIn(String username, String password) {
        if (databaseConnect.login(username,password)) {
            this.username = username;
            return true;
        }
        else{
            return false;
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Shape> getOrder() {
        return order;
    }

    public ArrayList getLogData() {
        return logData;
    }

    public void loadModel(File f) {
        if (f.exists()) {
            try(FileInputStream fin = new FileInputStream(f);
                ObjectInputStream oin = new ObjectInputStream(fin);) {
                ArrayList<Shape> landing = (ArrayList<Shape>) oin.readObject();
                order = landing;
            } catch (IOException|ClassNotFoundException iex) {
                iex.printStackTrace();
            }
        }
    }

    public void saveModel(File f) {
        try(FileOutputStream fout = new FileOutputStream(f);
            ObjectOutputStream oout = new ObjectOutputStream(fout);) {
            oout.writeObject(order);
        } catch (IOException iex) {
            iex.printStackTrace();
        }
    }
}


