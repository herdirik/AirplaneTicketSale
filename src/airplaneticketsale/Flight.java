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
public class Flight {
    
    private int flightID;
    private Airport airborne;
    private Airport destination;
    private Airplane airplane;
    private String flightDate;
    private String flightTime;
    
    public Flight(int id,Airport airborne, Airport destination, Airplane airplane, String flightDate, String flightTime) {
        this.flightID =id;
        this.airborne = airborne;
        this.destination = destination;
        this.airplane = airplane;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
    }
      public int getFlightID() {
        return flightID;
    }

    public Airport getAirborne() {
        return airborne;
    }

    public void setAirborne(Airport airborne) {
        this.airborne = airborne;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }
    //Bütün flightları liste şeklinde döndüren method.
    public static List<Flight> select(){
        List<Flight> p = new ArrayList<Flight>();
        try {
            int id;
            String flightdate, flighttime;
            Airport dest,origin;
            Airplane plane;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "SELECT * FROM FLIGHTTBL;";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("FLIGHT_ID");
                origin = Airport.select(rs.getInt("FLIGHT_AIRBORNEID"));
                dest = Airport.select(rs.getInt("FLIGHT_DESTINATIONID"));
                plane = Airplane.select(rs.getInt("FLIGHT_AIRPLANEID"));
                flightdate = rs.getString("FLIGHT_DATE");
                flighttime = rs.getString("FLIGHT_TIME");
                p.add(new Flight(id, origin, dest, plane,flightdate, flighttime));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return p;
    }
    //İçine aldığı paremetrelere göre flightları listeleyen method.
    public static List<Flight> select(Airport origin, Airport dest, String date){
        List<Flight> p = new ArrayList<Flight>();
        try {
            int id;
            String flighttime;
            Airplane plane;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "SELECT * FROM FLIGHTTBL WHERE FLIGHT_AIRBORNEID="+origin.getAirportID() +" AND FLIGHT_DESTINATIONID="+dest.getAirportID()+" AND FLIGHT_DATE='"+date+"';";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("FLIGHT_ID");
                plane = Airplane.select(rs.getInt("FLIGHT_AIRPLANEID"));
                flighttime = rs.getString("FLIGHT_TIME");
                p.add(new Flight(id, dest, origin, plane,date, flighttime));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return p;
    }
    //uçus idsine göre seferi çeken method.
     public static Flight select(int ID){
        Flight f = null;
        try {
            int id;
            Airport airborne,destination;
            Airplane airplane;
            String flightDate;
            String flightTime;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "SELECT * FROM FLIGHTTBL WHERE FLIGHT_ID="+ID+";";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("FLIGHT_ID");
                airborne = Airport.select(rs.getInt("FLIGHT_AIRBORNEID"));
                destination=Airport.select(rs.getInt("FLIGHT_DESTINATIONID"));
                airplane = Airplane.select(rs.getInt("FLIGHT_AIRPLANEID"));
                flightDate=rs.getString("FLIGHT_DATE");
                flightTime=rs.getString("FLIGHT_TIME");
                f = new Flight(id, airborne,destination,airplane,flightDate,flightTime);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
    // uçuş ekleyen method.
    public static void insert(int airbornid, int destinationid, int airplaneid , String date ,String time){
        try {
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "INSERT INTO FLIGHTTBL (FLIGHT_AIRBORNEID,FLIGHT_DESTINATIONID,FLIGHT_AIRPLANEID,FLIGHT_DATE,FLIGHT_TIME) VALUES(" + airbornid + "," + destinationid + ","
                    + ""+airplaneid+",'"+date+"','"+time+"');";
            ResultSet rs = db.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    //Uçuş güncelleme methodu.
    public void update(int airborneID, int destinationID ,int airplaneID  , String date ,String time){
    try {
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "UPDATE FLIGHTTBL SET FLIGHT_AIRBORNEID='"+airborneID+"',FLIGHT_DESTINATIONID='"+destinationID+"',FLIGHT_AIRPLANEID='"+airplaneID+"'"
                    + ",FLIGHT_DATE='"+date+"',FLIGHT_TIME='"+time+"' WHERE FLIGHT_ID="+getFlightID()+";";
            ResultSet rs = db.executeQuery(sql);
            
        }catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
