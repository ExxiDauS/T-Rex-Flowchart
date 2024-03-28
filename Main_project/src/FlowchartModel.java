import java.util.*;

public class FlowchartModel {
    private ArrayList<Shape> order;
    private String username;
    private String password;
    private String status;

    public FlowchartModel() {
        order = new ArrayList<Shape>();
        username = "";
        password = "";
        status = "play";
    }

    public boolean logIn(String username, String password) {
        if (find()) {
            this.username = username;
            this.password = password;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean find() {
        return false;
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
}


