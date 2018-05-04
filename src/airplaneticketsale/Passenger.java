/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplaneticketsale;

/**
 *
 * @author hatice
 */
public class Passenger {

    private int passengerID;
    private String passangerName;
    private String passengerSurname;
    private String passengerBirthdate;
    private String passengerHomeaddress;
    private String passengerBusinessaddress;
    private String passengerEmail;
    private String passengerPassword;

    public Passenger(int passengerID, String passangerName, String passengerSurname, String passengerBirthdate, String passengerHomeaddress, String passengerBusinessaddress, String passengerEmail, String passengerPassword) {
        this.passengerID = passengerID;
        this.passangerName = passangerName;
        this.passengerSurname = passengerSurname;
        this.passengerBirthdate = passengerBirthdate;
        this.passengerHomeaddress = passengerHomeaddress;
        this.passengerBusinessaddress = passengerBusinessaddress;
        this.passengerEmail = passengerEmail;
        this.passengerPassword = passengerPassword;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getPassangerName() {
        return passangerName;
    }

    public void setPassangerName(String passangerName) {
        this.passangerName = passangerName;
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

}
