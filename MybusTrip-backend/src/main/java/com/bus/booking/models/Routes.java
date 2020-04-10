package com.bus.booking.models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "routes")
public class Routes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeId;

    private float distance;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "destinationId", referencedColumnName = "destinationId")
    private Destinations destination;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sourceId", referencedColumnName = "destinationId")
    private Destinations source;

    public Routes(int routeId, float distance, Destinations source, Destinations destination) {
        this.routeId = routeId;
        this.distance = distance;
        this.source = source;
        this.destination = destination;
    }
    public Routes() {
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Destinations getSource() {
        return source;
    }

    public void setSource(Destinations source) {
        this.source = source;
    }

    public Destinations getDestination() {
        return destination;
    }

    public void setDestination(Destinations destination) {
        this.destination = destination;
    }
}
