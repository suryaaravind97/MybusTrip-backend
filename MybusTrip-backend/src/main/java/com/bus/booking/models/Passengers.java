package com.bus.booking.models;
import javax.persistence.*;

@Entity
@Table(name = "passengers")
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int passengerId;
    private String passengerName;
    private int phoneNumber;
    private int seatNo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticketId", referencedColumnName = "ticketId")
    private Tickets ticket;

    public Passengers(int passengerId, String passengerName, int phoneNumber, int seatNo, Tickets ticket) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.phoneNumber = phoneNumber;
        this.seatNo = seatNo;
        this.ticket = ticket;
    }
    public Passengers() {
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }
}
