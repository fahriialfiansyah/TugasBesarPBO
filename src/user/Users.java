package user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Users extends DBConnection implements UsersImp{

    private int id;
    private String full_name;
    private String username;
    private String email;
    private String password;
    private Vector data;
    
    //Setter and Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }
    
    
    //Insert function form UsersImp - Interface
    @Override
    public void _insert() {
        //call connection
        super._connection();
        String sql = "insert into users(full_name, username, email, password)" 
                + " values (?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, full_name);
            pst.setString(2, username);
            pst.setString(3, email);
            pst.setString(4, password);            
            pst.executeUpdate();
            pst.close();
            message("Successfully Added!");
            
        } catch (SQLException e) {
            message(e.getMessage());
        }
    }         
             
    @Override
    public void _update() {
        //call connection
        super._connection();
        String sql = "update users set full_name=?, username=?, email=?, password=? where id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, full_name);
            pst.setString(2, username);
            pst.setString(3, email);
            pst.setString(4, password);
            pst.setInt(5, id);
            pst.executeUpdate();
            pst.close();
            message("Successfully Updated!");
            
        } catch (SQLException e) {
            message(e.getMessage());
        }
    }

    @Override
    public void _delete() {
        //call connection
        super._connection();
        String sql = "delete from users where id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();
            message("Successfully Deleted!");
            
        } catch (SQLException e) {
            message(e.getMessage());
        }
    }

    @Override
    public void _loadID() {
        //set new vector values
        this.setData(new Vector());
        super._connection();
        int rowCounter = 0;
        String sql = "select * from users";
        try { 
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                int _id = rs.getInt("id");  
                Vector row = new Vector();
                row.add("  " + rowCounter + ".");
                row.add(_id);
                this.getData().add(row);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            message(e.getMessage());
        }
    }
    
    @Override
    public void _loadList() {
        //set new vector values
        this.setData(new Vector());
        super._connection();
        int rowCounter = 0;
        String sql = "select * from users";
        try { 
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                int _id = rs.getInt("id");
                String _full_name = rs.getString("full_name");
                String _username = rs.getString("username");
                String _email = rs.getString("email");
                String _password = rs.getString("password");
                Vector row = new Vector();
                row.add("  " + rowCounter + ".");
                row.add(_id);
                row.add(_full_name);
                row.add(_username);
                row.add(_email);
                row.add(_password);
                this.getData().add(row);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            message(e.getMessage());
        }
    }

    @Override
    public void _getUsers(int id) {
        super._connection();
        String sql = "select * from users where id = " + id;
        try { 
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int _id = rs.getInt("id");
                String _full_name = rs.getString("full_name");
                String _username = rs.getString("username");
                String _email = rs.getString("email");
                String _password = rs.getString("password");
                this.setId(_id);
                this.setFull_name(_full_name);
                this.setUsername(_username);
                this.setEmail(_email);
                this.setPassword(_password);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            message(e.getMessage());
        }
    }

    @Override
    public void _search(String key) {
        this.setData(new Vector());
        super._connection();
        int rowCounter = 0;
        String sql = "select * from users where full_name like '%"+key+"%'";
        try { 
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                int _id = rs.getInt("id");
                String _full_name = rs.getString("full_name");
                String _username = rs.getString("username");
                String _email = rs.getString("email");
                String _password = rs.getString("password");
                Vector row = new Vector();
                row.add("  " + rowCounter + ".");
                row.add(_id);
                row.add(_full_name);
                row.add(_username);
                row.add(_email);
                row.add(_password);
                this.getData().add(row);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            message(e.getMessage());
        }
    }
    
    public static void message(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
