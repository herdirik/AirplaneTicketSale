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
public class Flight {
    
    private int flightID;
    private Airport airborne;
    private Airport destination;
    private Airplane airplane;
    private String flightDate;
    private String flightTime;
    
    public Flight(Airport airborne, Airport destination, Airplane airplane, String flightDate, String flightTime) {
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

}
