package com.bus.booking.models;
import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketId;
    private float ticketPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tripId", referencedColumnName = "tripId")
    private Trips trip;
    private String emailId;

    public Tickets(int ticketId, float ticketPrice, Trips trip, String emailId) {
        this.ticketId = ticketId;
        this.ticketPrice = ticketPrice;
        this.trip = trip;
        this.emailId = emailId;
    }
    public Tickets() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Trips getTrip() {
        return trip;
    }

    public void setTrip(Trips trip) {
        this.trip = trip;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
