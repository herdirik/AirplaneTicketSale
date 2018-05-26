/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplaneticketsale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hatice
 */
public class Seat {

    private int seatID;
    private Airplane airplaneID;
    private boolean status;
    private int seatLocation;
    private int seatClass;//Düzenleme yapılacak.
    
    public Seat(int seatID, Airplane airplaneID, boolean status, int seatLocation) {
        this.seatID = seatID;
        this.airplaneID = airplaneID;
        this.status = status;
        this.seatLocation = seatLocation;
    }
    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public Airplane getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(Airplane airplaneID) {
        this.airplaneID = airplaneID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(int seatLocation) {
        this.seatLocation = seatLocation;
    }

    public static List<Seat> select(int flightID){
        List<Seat> seats = new ArrayList<Seat>();
        
        try{
            Flight f = Flight.select(flightID);
            int ucNum= f.getAirplane().getAirplaneID();
            int id,seatLocation;
            Airplane airplaneid;
            boolean status;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql="SELECT * FROM SEATTBL WHERE SEAT_AIRPLANEID="+ucNum+";";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                if(rs.getBoolean("SEAT_STATUS")){
                    id= rs.getInt("SEAT_ID");
                    airplaneid = Airplane.select(rs.getInt("SEAT_AIRPLANEID"));
                    status= rs.getBoolean("SEAT_STATUS");
                    seatLocation=rs.getInt("SEAT_LOCATION");
                    seats.add(new Seat(id,airplaneid,status,seatLocation));
                }
            }
        
        }
        catch (SQLException ex){
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seats;
    }
    
    public static Seat selectOne(int seatID){
        Seat s=null;
        try{
            int id,seatLocation;
            Airplane airplaneid;
            boolean status;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql="SELECT * FROM SEATTBL WHERE SEAT_ID="+seatID+";";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                id= rs.getInt("SEAT_ID");
                airplaneid = Airplane.select(rs.getInt("SEAT_AIRPLANEID"));
                status= rs.getBoolean("SEAT_STATUS");
                seatLocation=rs.getInt("SEAT_LOCATION");
                s=new Seat(id,airplaneid,status,seatLocation);             
            }
        }
        catch (SQLException ex){
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    
}
