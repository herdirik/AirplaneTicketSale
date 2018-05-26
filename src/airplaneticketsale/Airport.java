/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplaneticketsale;

import java.sql.Date;
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
public class Airport {

    private int airportID;
    private String airportName;
    private String airportCity;
    
    public Airport(int airportID, String airportName, String airportCity) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.airportCity = airportCity;
    }
    public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }
    
    public static List<Airport> select(){
        List<Airport> a = new ArrayList<Airport>();
        try {
            int id;
            String city, name;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "SELECT * FROM AIRPORTTBL;";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("AIRPORT_ID");
                name = rs.getString("AIRPORT_NAME");
                city = rs.getString("AIRPORT_CITY");
                a.add(new Airport(id, name, city));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return a;
    }
    
    public static Airport select(int ID){
        Airport a = null;
        try {
            int id;
            String city, name;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "SELECT * FROM AIRPORTTBL WHERE AIRPORT_ID="+ID+";";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("AIRPORT_ID");
                name = rs.getString("AIRPORT_NAME");
                city = rs.getString("AIRPORT_CITY");
                a = new Airport(id, name, city);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    public static void insert(String name,String city){
        try {
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "INSERT INTO AIRPORTTBL (AIRPORT_NAME,AIRPORT_CITY) VALUES('" + name + "','" + city + "');";
            ResultSet rs = db.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(String name,String city){
        try {
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "UPDATE AIRPORTTBL SET AIRPORT_NAME='"+name+"',AIRPORT_CITY='"+city+"' WHERE AIRPORT_ID="+getAirportID()+";";
            ResultSet rs = db.executeQuery(sql);
            
        }catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
