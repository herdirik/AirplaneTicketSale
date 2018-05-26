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
public class Passenger {

    private int passengerID;
    private String identityNumber;
    private String passengerName;
    private String passengerSurname;
    private String passengerBirthdate;
    private String passengerHomeaddress;
    private String passengerBusinessaddress;
    private String passengerEmail;
    private String passengerPassword;
    private boolean admin;
  

    public Passenger(int passengerID, String identityNumber, String passengerName, String passengerSurname, String passengerBirthdate, String passengerHomeaddress, String passengerBusinessaddress, String passengerEmail, String passengerPassword, boolean admin) {
        // Burdakilerin hepsi setter ile yapılacak
        setPassengerID(passengerID);
        setIdentityNumber(identityNumber);
        setPassengerName(passengerName);
        setPassengerSurname(passengerSurname);
        setPassengerBirthdate(passengerBirthdate);
        setPassengerHomeaddress(passengerHomeaddress);
        setPassengerBusinessaddress(passengerBusinessaddress);
        setPassengerEmail(passengerEmail);
        setPassengerPassword(passengerPassword);
        setAdmin(admin);
    }
    public Passenger(int passengerID, String identityNumber, String passengerName, String passengerSurname, String passengerBirthdate, String passengerHomeaddress, String passengerBusinessaddress, String passengerEmail, String passengerPassword) {
        // Burdakilerin hepsi setter ile yapılacak
        setPassengerID(passengerID);
        setIdentityNumber(identityNumber);
        setPassengerName(passengerName);
        setPassengerSurname(passengerSurname);
        setPassengerBirthdate(passengerBirthdate);
        setPassengerHomeaddress(passengerHomeaddress);
        setPassengerBusinessaddress(passengerBusinessaddress);
        setPassengerEmail(passengerEmail);
        setPassengerPassword(passengerPassword);  
    }
    /**
     * @param passengerID the passengerID to set
     */
    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }
    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public String getPassangerName() {
        return passengerName;
    }

    public void setPassengerName(String passangerName) {
        this.passengerName = passangerName;
    }

    public String getPassengerSurname() {
        return passengerSurname;
    }

    public void setPassengerSurname(String passengerSurname) {
        this.passengerSurname = passengerSurname;
    }

    public String getPassengerBirthdate() {
        return passengerBirthdate;
    }

    public void setPassengerBirthdate(String passengerBirthdate) {
        this.passengerBirthdate = passengerBirthdate;
    }

    public String getPassengerHomeaddress() {
        return passengerHomeaddress;
    }

    public void setPassengerHomeaddress(String passengerHomeaddress) {
        this.passengerHomeaddress = passengerHomeaddress;
    }

    public String getPassengerBusinessaddress() {
        return passengerBusinessaddress;
    }

    public void setPassengerBusinessaddress(String passengerBusinessaddress) {
        this.passengerBusinessaddress = passengerBusinessaddress;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public String getPassengerPassword() {
        return passengerPassword;
    }

    public void setPassengerPassword(String passengerPassword) {
        this.passengerPassword = passengerPassword;
    }
    
    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    //Bütün passengerları liste şeklinde dönüdren method.
    public static List<Passenger> select(){
        List<Passenger> p = new ArrayList<Passenger>();
        try {
            int id;
            String number, name, surname, address, bussiness, email, pass;
            Date bdate;
            boolean admin;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "SELECT * FROM PASSENGERTBL;";
            String sql2;
            ResultSet rs = db.executeQuery(sql);
            ResultSet rsAdmin;
            while (rs.next()) {
                id = rs.getInt("PASSENGER_ID");
                number = rs.getString("PASSENGER_IDENTITYNUMBER");
                name = rs.getString("PASSENGER_NAME");
                surname = rs.getString("PASSENGER_SURNAME");
                bdate = rs.getDate("PASSENGER_BIRTHDATE");
                address = rs.getString("PASSENGER_HOMEADDRESS");
                bussiness = rs.getString("PASSENGER_BUSINESS");
                email = rs.getString("PASSENGER_EMAIL");
                pass = rs.getString("PASSENGER_PASSWORD");
                sql2 = "SELECT * FROM ADMINTBL WHERE ADMIN_PASSENGERID="+id+";";
                rsAdmin = db.executeQuery(sql2);
                admin = rsAdmin.next();
                p.add(new Passenger(id, number, name, surname, bdate.toString(), address, bussiness, email, pass,admin));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return p;
    }
    //Girilen id ye göre passenger döndüren method.
    public static Passenger select(int ID){
        Passenger p = null;
        try {
            int id;
            String number, name, surname, address, bussiness, email, pass;
            Date bdate;
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "SELECT * FROM PASSENGERTBL WHERE PASSENGER_ID="+ID+";";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("PASSENGER_ID");
                number = rs.getString("PASSENGER_IDENTITYNUMBER");
                name = rs.getString("PASSENGER_NAME");
                surname = rs.getString("PASSENGER_SURNAME");
                bdate = rs.getDate("PASSENGER_BIRTHDATE");
                address = rs.getString("PASSENGER_HOMEADDRESS");
                bussiness = rs.getString("PASSENGER_BUSINESS");
                email = rs.getString("PASSENGER_EMAIL");
                pass = rs.getString("PASSENGER_PASSWORD");
                p = new Passenger(id, number, name, surname, bdate.toString(), address, bussiness, email, pass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    //passenger ekleyen method.
    public static void insert(String number,String name,String surname,String bdate, String address,String bussiness,String email,String pass){
        try {
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "INSERT INTO PASSENGERTBL (PASSENGER_IDENTITYNUMBER,PASSENGER_NAME,PASSENGER_SURNAME,PASSENGER_BIRTHDATE,PASSENGER_HOMEADDRESS,"
                    + "PASSENGER_BUSINESS,PASSENGER_EMAIL,PASSENGER_PASSWORD) VALUES('" + number + "','" + name + "','" + surname + "',"+ "'" + bdate+ "','" 
                    + address + "','" + bussiness + "','" + email + "',"+ "'" + pass + "')";
            ResultSet rs = db.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    //Passenger güncelleyen method.
    public void update(String number,String name,String surname,String bdate, String address,String bussiness,String email,String pass){
        try {
            String connection = "jdbc:hsqldb:file:db/AirportDB";
            DBHandler db = new DBHandler(connection);
            String sql = "UPDATE PASSENGERTBL SET PASSENGER_IDENTITYNUMBER='"+number+"',PASSENGER_NAME='"+name+"',PASSENGER_SURNAME='"+surname+"'"
                    + ",PASSENGER_BIRTHDATE='"+bdate+"',PASSENGER_HOMEADDRESS='"+address+"',PASSENGER_BUSINESS='"+bussiness+"',PASSENGER_EMAIL='"+email+"',PASSENGER_PASSWORD='"
                    +pass+"' WHERE PASSENGER_ID="+getPassengerID()+";";
            ResultSet rs = db.executeQuery(sql);
            
        }catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
