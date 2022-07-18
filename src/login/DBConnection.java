package login;

import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Acer
 */
public class DBConnection {
    private static java.sql.Connection con;
   
    public static java.sql.Connection getCon() {
        if (con == null) {
            try {
                String url = "jdbc:mysql://localhost/airlinee";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                con = DriverManager.getConnection(url, user, password);
                System.out.println("Connection Succesfully");
            } catch (SQLException e) {
                System.out.println("Error");
            }   
        }
        return con;
    }
    
    public static void main(String args[]) {
        getCon();
    }
}