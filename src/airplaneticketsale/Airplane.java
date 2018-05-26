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
public class Airplane {

   
    private int airplaneID;
    private String airplaneType;
    private int passengerCapacity;
    
    public Airplane(int airplaneID, String airplaneType, int passengerCapacity) {
        this.airplaneID = airplaneID;
        this.airplaneType = airplaneType;
        this.passengerCapacity = passengerCapacity;
    }
       public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    
    public static Airplane select(int ID){
        Airplane a = null;
        try {
            int id, capacity;
            String type;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "SELECT * FROM AIRPLANETBL WHERE AIRPLANE_ID="+ID+";";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("AIRPLANE_ID");
                type = rs.getString("AIRPLANE_TYPE");
                capacity = rs.getInt("AIRPLANE_PASSENGERCAPACITY");
                a = new Airplane(id, type, capacity);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    public static List<Airplane> select(){
        List<Airplane> a = new ArrayList<Airplane>();
        try {
            int id, capacity;
            String type;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "SELECT * FROM AIRPLANETBL;";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("AIRPLANE_ID");
                type = rs.getString("AIRPLANE_TYPE");
                capacity= rs.getInt("AIRPLANE_PASSENGERCAPACITY");
                a.add(new Airplane(id, type, capacity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return a;
    }
}
