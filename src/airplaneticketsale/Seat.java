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
public class Seat {

    private int seatID;
    private Airplane airplaneID;
    private boolean status;
    private int seatLocation;
    private String seatClass;
    
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

    
}
