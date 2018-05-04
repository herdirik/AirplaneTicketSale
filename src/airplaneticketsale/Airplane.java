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
    
}
