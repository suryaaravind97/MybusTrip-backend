package com.bus.booking.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "busDetails")
public class BusDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busId;

    @Enumerated(EnumType.STRING)
    private BusType busType;
    @NotNull
    private int totalSeats;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "companyId", nullable = false)
    private Buscompany buscompany;
}
