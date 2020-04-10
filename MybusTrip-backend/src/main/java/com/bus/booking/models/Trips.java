package com.bus.booking.models;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "trips")
public class Trips implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tripId;
    private int availableSeats;
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @ManyToOne
    @JoinColumn(name = "routeId", referencedColumnName = "routeId")
    private Routes route;
    @OneToOne
    @JoinColumn(name = "busId", referencedColumnName = "busId")
    private BusDetails busdetails;
    private Time departureTime;
    private Time arrivalTime;

    public Trips(int tripId, int availableSeats, Date departureDate, Date arrivalDate, Routes route, BusDetails busdetails, Time departureTime, Time arrivalTime) {
        this.tripId = tripId;
        this.availableSeats = availableSeats;
        this.departureDate = departureDate;
        this.arrivalDate=arrivalDate;
        this.route = route;
        this.busdetails = busdetails;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
    }
    public Trips() {
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Routes getRoute() {
        return route;
    }

    public void setRoute(Routes route) {
        this.route = route;
    }

    public BusDetails getBusdetails() {
        return busdetails;
    }

    public void setBusdetails(BusDetails busdetails) {
        this.busdetails = busdetails;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
