import java.sql.*;
import java.util.*;

public class DatabaseConnect {
//    DB credentials.
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://161.246.127.24:9004/clua7yac5000cbsmnfvj64hef";
    
    static final String USER = "clua7yac3000absmnajq5d7jl";
    static final String PASS = "kVGzhZ64mXAGplcwmtUL3Ub4";
    
    public boolean login(String username, String password){
        String sql = "select * from User";
        try (Connection connect = DriverManager.getConnection(
                    "jdbc:mariadb://161.246.127.24:9004/clua7yac5000cbsmnfvj64hef", 
                    "clua7yac3000absmnajq5d7jl", "kVGzhZ64mXAGplcwmtUL3Ub4");
                Statement s = connect.createStatement();
                ResultSet rec = s.executeQuery(sql);){
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Connected database successfully...");
            while (rec.next()) {                
                if ((username.equals(rec.getString("Username"))) && (password.equals(rec.getString("Password")))) {
                    System.out.println("Login...");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Error! Incorrect username or password.");
        return false;
    }
    
    public void insertProblem(String description, String imgUrl, ArrayList cases[], String titleName, int casesCount){
        String sql = "INSERT INTO Question VALUES(ID, '{\"description\": " + description + ", \"imgUrl\": " + imgUrl
                + ", \"cases\": " + Arrays.toString(cases) + ", \"titleName\": " + titleName + "}', " + casesCount + ");";
        try (Connection connect = DriverManager.getConnection(
                    "jdbc:mariadb://161.246.127.24:9004/clua7yac5000cbsmnfvj64hef", 
                    "clua7yac3000absmnajq5d7jl", "kVGzhZ64mXAGplcwmtUL3Ub4");
                Statement s = connect.createStatement();
                ){
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Connected database successfully...");
            int i = s.executeUpdate(sql);
            if (i > 0) {
                System.out.println("ROW INSERTED");
            } else {
                System.out.println("ROW NOT INSERTED");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getProblem(int id){
        String sql = "SELECT * FROM Question";
        try (Connection connect = DriverManager.getConnection(
                    "jdbc:mariadb://161.246.127.24:9004/clua7yac5000cbsmnfvj64hef", 
                    "clua7yac3000absmnajq5d7jl", "kVGzhZ64mXAGplcwmtUL3Ub4");
                Statement s = connect.createStatement();
                ResultSet rec = s.executeQuery(sql);){
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Connected database successfully...");
            while (rec.next()) {                
                if (rec.getInt("ID") == id) {
                    System.out.println("Get problem successfully.");
                    return rec.getString("Problem");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Please check problem ID and try again.");
        return null;
    }
    
    public void insertTestcases(ArrayList input[], ArrayList output[]){
        String sql = "INSERT INTO Testcases VALUES(ID, " 
                + Arrays.toString(input) + ", " + Arrays.toString(output) + ");";
        try (Connection connect = DriverManager.getConnection(
                    "jdbc:mariadb://161.246.127.24:9004/clua7yac5000cbsmnfvj64hef", 
                    "clua7yac3000absmnajq5d7jl", "kVGzhZ64mXAGplcwmtUL3Ub4");
                Statement s = connect.createStatement();
                ){
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Connected database successfully...");
            int i = s.executeUpdate(sql);
            if (i > 0) {
                System.out.println("ROW INSERTED");
            } else {
                System.out.println("ROW NOT INSERTED");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList getInput(int questionID){
        String sql = "SELECT * FROM Testcases";
        String tmp = "";
        ArrayList input = new ArrayList();
        try (Connection connect = DriverManager.getConnection(
                    "jdbc:mariadb://161.246.127.24:9004/clua7yac5000cbsmnfvj64hef", 
                    "clua7yac3000absmnajq5d7jl", "kVGzhZ64mXAGplcwmtUL3Ub4");
                Statement s = connect.createStatement();
                ResultSet rec = s.executeQuery(sql);){
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Connected database successfully...");
            while (rec.next()) {                
                if (rec.getInt("ID") == questionID) {
                    System.out.println("Get Input successfully.");
                    tmp = rec.getString("Input");
                }
            }
            int start = tmp.indexOf('[');
            int end = tmp.indexOf(']');
            tmp = tmp.substring(start + 1, end);
            String arrOfStr[] = tmp.split(", ");
            input.addAll(Arrays.asList(arrOfStr));
            return input;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList getOutput(int questionID){
        String sql = "SELECT * FROM Testcases";
        String tmp = "";
        ArrayList input = new ArrayList();
        try (Connection connect = DriverManager.getConnection(
                    "jdbc:mariadb://161.246.127.24:9004/clua7yac5000cbsmnfvj64hef", 
                    "clua7yac3000absmnajq5d7jl", "kVGzhZ64mXAGplcwmtUL3Ub4");
                Statement s = connect.createStatement();
                ResultSet rec = s.executeQuery(sql);){
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Connected database successfully...");
            while (rec.next()) {                
                if (rec.getInt("ID") == questionID) {
                    System.out.println("Get Output successfully.");
                    tmp = rec.getString("Output");
                }
            }
            int start = tmp.indexOf('[');
            int end = tmp.indexOf(']');
            tmp = tmp.substring(start + 1, end);
            String arrOfStr[] = tmp.split(", ");
            input.addAll(Arrays.asList(arrOfStr));
            return input;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
