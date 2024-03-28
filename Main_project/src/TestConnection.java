import java.sql.*;

public class TestConnection {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://161.246.127.24:9004/clua7yac5000cbsmnfvj64hef";

    public static void main(String[] args) {
        String sql = "select * from User";
        try (   Connection connect = DriverManager.getConnection(
                    "jdbc:mariadb://161.246.127.24:9004/clua7yac5000cbsmnfvj64hef", 
                    "clua7yac3000absmnajq5d7jl", "kVGzhZ64mXAGplcwmtUL3Ub4");
                Statement s = connect.createStatement();
                ResultSet rec = s.executeQuery(sql);){
            Class.forName("org.mariadb.jdbc.Driver");
//            System.out.println("Connecting to a selected database...");
            System.out.println("Connected database successfully...");
            while (rec.next()) {
                System.out.print("User ID : " + rec.getInt(1) + " ");
                System.out.print("Name : " + rec.getString(2) + " ");
                System.out.print("Role : " + rec.getString(3) + " ");
                System.out.println("Score : " + rec.getDouble(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
