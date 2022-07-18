package flight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Flights extends DBConnection implements FlightsImp{

    private int id;
    private String flightDate;
    private String flightFrom;
    private String flightDest;
    private int price;
    private int flightSeats;
    private int totalPrice;
    private Vector data;
    
    //Setter and Getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightDest() {
        return flightDest;
    }

    public void setFlightDest(String flightDest) {
        this.flightDest = flightDest;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPriceStr() {
        return Integer.toString(price);
    }
    
    public void setPrice(String price) throws NumberFormatException {
        this.price = Integer.parseInt(price); // Null check to be added 
    }
    
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public String getTotalPriceStr() {
        return Integer.toString(totalPrice);
    }
    
    public void setTotalPrice(String totalPrice) throws NumberFormatException {
        this.totalPrice = Integer.parseInt(totalPrice); // Null check to be added 
    }
    
    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public int getFlightSeats() {
        return flightSeats;
    }

    public void setFlightSeats(int flightSeats) {
        this.flightSeats = flightSeats;
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
        String sql = "insert into flights(flightDate, flightFrom, flightDest, price, flightSeats, totalPrice)" 
                + " values (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, flightDate);
            pst.setString(2, flightFrom);
            pst.setString(3, flightDest);            
            pst.setInt(4, price);
            pst.setInt(5, flightSeats);
            pst.setInt(6, totalPrice);
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
        String sql = "update flights set flightDate=?, flightFrom=?, flightDest=?, price=?, flightSeats=?, totalPrice=? where id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, flightDate);
            pst.setString(2, flightFrom);
            pst.setString(3, flightDest);            
            pst.setInt(4, price);
            pst.setInt(5, flightSeats);
            pst.setInt(6, totalPrice);
            pst.setInt(7, id);
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
        String sql = "delete from flights where id = ?";
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
        String sql = "select * from flights";
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
        String sql = "select * from flights";
        try { 
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                int _id = rs.getInt("id");
                String _flightDate = rs.getString("flightDate");
                String _flightFrom = rs.getString("flightFrom");
                String _flightDest = rs.getString("flightDest");
                int _price = rs.getInt("price");
                int _flightSeats = rs.getInt("flightSeats");
                int _totalPrice = rs.getInt("totalPrice");
                Vector row = new Vector();
                row.add("  " + rowCounter + ".");
                row.add(_id);
                row.add(_flightDate);
                row.add(_flightFrom);
                row.add(_flightDest);
                row.add(_price);
                row.add(_flightSeats);
                row.add(_totalPrice);
                this.getData().add(row);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            message(e.getMessage());
        }
    }

    @Override
    public void _getFlights(int id) {
        super._connection();
        String sql = "select * from flights where id = " + id;
        try { 
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int _id = rs.getInt("id");
                String _flightDate = rs.getString("flightDate");
                String _flightFrom = rs.getString("flightFrom");
                String _flightDest = rs.getString("flightDest");
                int _price = rs.getInt("price");
                int _flightSeats = rs.getInt("flightSeats");
                int _totalPrice = rs.getInt("totalPrice");
                //set values
                this.setId(_id);
                this.setFlightDate(_flightDate);
                this.setFlightFrom(_flightFrom);
                this.setFlightDest(_flightDest);
                this.setPrice(_price);
                this.setFlightSeats(_flightSeats);
                this.setTotalPrice(_totalPrice);
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
        String sql = "select * from flights where flightFrom like '%"+key+"%'";
        try { 
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                int _id = rs.getInt("id");
                String _flightDate = rs.getString("flightDate");
                String _flightFrom = rs.getString("flightFrom");
                String _flightDest = rs.getString("flightDest");
                int _price = rs.getInt("price");
                int _flightSeats = rs.getInt("flightSeats");
                int _totalPrice = rs.getInt("totalPrice");
                Vector row = new Vector();
                row.add("  " + rowCounter + ".");
                row.add(_id);
                row.add(_flightDate);
                row.add(_flightFrom);
                row.add(_flightDest);
                row.add(_price);
                row.add(_flightSeats);
                row.add(_totalPrice);
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