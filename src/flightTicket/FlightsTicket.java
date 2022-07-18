package flightTicket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class FlightsTicket extends DBConnection implements FlightsImp{

    private int id;
    private String flightCode;
    private String passportNumber;
    private String gender;
    private String nationality;
    private Vector data;
    
    //Setter and Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }
    
    
    //Insert function form FlightsImp - Interface
    @Override
    public void _insert() {
        //call connection
        super._connection();
        String sql = "insert into flight_ticket(flightCode, passportNumber, gender, nationality)" 
                + " values (?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, flightCode);
            pst.setString(2, passportNumber);
            pst.setString(3, gender);
            pst.setString(4, nationality);    
            pst.executeUpdate();
            pst.close();
            message("Successfully Added!");
            
        } catch (SQLException e) {
            message(e.getMessage());
        }
    }         
             

//
//    @Override
//    public void _loadID() {
//        //set new vector values
//        this.setData(new Vector());
//        super._connection();
//        int rowCounter = 0;
//        String sql = "select * from flights";
//        try { 
//            PreparedStatement pst = con.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                rowCounter++;
//                int _id = rs.getInt("id");  
//                Vector row = new Vector();
//                row.add("  " + rowCounter + ".");
//                row.add(_id);
//                this.getData().add(row);
//            }
//            rs.close();
//            pst.close();
//        } catch (SQLException e) {
//            message(e.getMessage());
//        }
//    }
//    
//    @Override
//    public void _loadList() {
//        //set new vector values
//        this.setData(new Vector());
//        super._connection();
//        int rowCounter = 0;
//        String sql = "select * from flights";
//        try { 
//            PreparedStatement pst = con.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                rowCounter++;
//                int _id = rs.getInt("id");
//                String _flightCode = rs.getString("flightCode");
//                String _passportNumber = rs.getString("passportNumber");
//                String _flightFrom = rs.getString("flightFrom");
//                String _flightDest = rs.getString("flightDest");
//                String _flightDate = rs.getString("flightDate");
//                int _price = rs.getInt("price");
//                int _flightSeats = rs.getInt("flightSeats");
//                int _totalPrice = rs.getInt("totalPrice");
//                Vector row = new Vector();
//                row.add("  " + rowCounter + ".");
//                row.add(_id);
//                row.add(_flightCode);
//                row.add(_passportNumber);
//                row.add(_flightFrom);
//                row.add(_flightDest);
//                row.add(_flightDate);
//                row.add(_price);
//                row.add(_flightSeats);
//                row.add(_totalPrice);
//                this.getData().add(row);
//            }
//            rs.close();
//            pst.close();
//        } catch (SQLException e) {
//            message(e.getMessage());
//        }
//    }
//
//    @Override
//    public void _getFlights(int id) {
//        super._connection();
//        String sql = "select * from flights where id = " + id;
//        try { 
//            PreparedStatement pst = con.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                int _id = rs.getInt("id");
//                String _flightCode = rs.getString("flightCode");
//                String _passportNumber = rs.getString("passportNumber");
//                String _gender = rs.getString("gender");
//                String _nationality = rs.getString("nationality");
//                //set values
//                this.setId(_id);
//                this.setFlightCode(_flightCode);
//                this.setPassportNumber(_passportNumber);
//                this.setGender(_gender);
//                this.setNationality(_nationality);
//            }
//            rs.close();
//            pst.close();
//        } catch (SQLException e) {
//            message(e.getMessage());
//        }
//    }
//
//    @Override
//    public void _search(String key) {
//        this.setData(new Vector());
//        super._connection();
//        int rowCounter = 0;
//        String sql = "select * from flights where flightCode like '%"+key+"%'";
//        try { 
//            PreparedStatement pst = con.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                rowCounter++;
//                int _id = rs.getInt("id");
//                String _flightCode = rs.getString("flightCode");
//                String _passportNumber = rs.getString("passportNumber");
//                String _flightFrom = rs.getString("flightFrom");
//                String _flightDest = rs.getString("flightDest");
//                String _flightDate = rs.getString("flightDate");
//                int _price = rs.getInt("price");
//                int _flightSeats = rs.getInt("flightSeats");
//                int _totalPrice = rs.getInt("totalPrice");
//                Vector row = new Vector();
//                row.add("  " + rowCounter + ".");
//                row.add(_id);
//                row.add(_flightCode);
//                row.add(_passportNumber);
//                row.add(_flightFrom);
//                row.add(_flightDest);
//                row.add(_flightDate);
//                row.add(_price);
//                row.add(_flightSeats);
//                row.add(_totalPrice);
//                this.getData().add(row);
//            }
//            rs.close();
//            pst.close();
//        } catch (SQLException e) {
//            message(e.getMessage());
//        }
//    }
    
    public static void message(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void _update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void _delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void _loadList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void _loadID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void _getFlights(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void _search(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}