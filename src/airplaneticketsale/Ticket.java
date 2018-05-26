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
public class Ticket {
    private int ticketID;
    private Flight flight;
    private Passenger passenger;
    private Seat seat;
    private double price;

    public Ticket(int ticketID, Flight flight, Passenger passenger, Seat seat, double price) {
        this.ticketID = ticketID;
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.price = price;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //Bilet oluşturma fonksiyonu.
    public static void insert(int flightID ,int passengerID, int seatID, double price){
        try{
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql="INSERT INTO TICKETTBL (TICKET_FLIGHTID,TICKET_PASSENGERID,TICKET_SEATID,TICKET_PRICE) VALUES ('"+flightID+"','"+passengerID+"','"+seatID+"',"
                    + "'"+price+"')";
            ResultSet rs = db.executeQuery(sql);
        
        }
        catch(SQLException ex){
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
    
    public static List<Ticket> select(int passengerID){
        List<Ticket> t= new ArrayList<Ticket>();
        try{
            int id;
            Flight fl;
            Passenger ps;
            Seat s;
            double price;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql="SELECT * FROM TICKETTBL WHERE TICKET_PASSENGERID="+passengerID+";";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                id= rs.getInt("TICKET_ID");
                fl = Flight.select(rs.getInt("TICKET_FLIGHTID"));
                ps= Passenger.select(rs.getInt("TICKET_PASSENGERID"));
                s=Seat.selectOne(rs.getInt("TICKET_SEATID"));
                price = rs.getDouble("TICKET_PRICE");
                t.add(new Ticket(id,fl,ps,s,price));
            }
        
        }
        catch (SQLException ex){
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
        
    }
    public void delete(){
    
        try{
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql="DELETE FROM TICKETTBL WHERE TICKET_ID ="+this.getTicketID();
            ResultSet rs = db.executeQuery(sql);
            
        }
        catch(SQLException ex){
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Ticket selectbyTicketid(int ticketID){
        Ticket t = null;
        try{
            int ticketid, flightid, passengerid ,seatid ,price ;
            
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql="SELECT * FROM TICKETTBL WHERE TICKET_ID="+ticketID;
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                ticketid=rs.getInt("TICKET_ID");
                flightid= rs.getInt("TICKET_FLIGHTID");
                passengerid = rs.getInt("TICKET_PASSENGERID");
                seatid= rs.getInt("TICKET_SEATID");
                price =rs.getInt("TICKET_PRICE");
                t = new Ticket(ticketid,Flight.select(flightid),Passenger.select(passengerid),Seat.selectOne(seatid),price);
            }
            
        }
        catch(SQLException ex){
             Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return t;
    
    
    }
    
}
