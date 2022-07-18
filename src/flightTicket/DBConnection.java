package flightTicket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Acer
 */
public class DBConnection {
    
    private static java.sql.Connection conn;
    Connection con;
    
    //Setter and Getter

    public static java.sql.Connection getCon() {
       if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost/airlinee";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connection Succesfully");
            } catch (SQLException e) {
                System.out.println("Error");
            }   
        }
        return conn;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    //Variables
    private static final String _CONURL_ = "jdbc:mysql://localhost/airlinee";
    private static final String _DRIVER_ = "com.mysql.cj.jdbc.Driver";
    
    //Create connection
    public void _connection(){
        
        synchronized (_CONURL_) {
            //sync connection
            try {
                Class.forName(_DRIVER_);
                setCon(DriverManager.getConnection(_CONURL_, "root", ""));
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
    }
}