import java.sql.*;

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
}
