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
    private String identityNumber;
    private String passengerName;
    private String passengerSurname;
    private String passengerBirthdate;
    private String passengerHomeaddress;
    private String passengerBusinessaddress;
    private String passengerEmail;
    private String passengerPassword;

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

}
