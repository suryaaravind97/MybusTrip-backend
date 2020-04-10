package com.bus.booking.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "destinations")
public class Destinations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int destinationId;
    @NotNull
    private String destinationCity;
    @NotNull
    private String address;

    public Destinations(int destinationId, @NotNull String destinationCity, @NotNull String address) {
        this.destinationId = destinationId;
        this.destinationCity = destinationCity;
        this.address = address;
    }

    public Destinations(int destinationId) {
        this.destinationId = destinationId;
    }

    public Destinations() {
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
