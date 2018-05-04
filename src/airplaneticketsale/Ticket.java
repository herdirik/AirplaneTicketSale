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
    
    
    
}
