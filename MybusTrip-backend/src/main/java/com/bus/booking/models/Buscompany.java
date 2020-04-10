package com.bus.booking.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "busCompany")
public class Buscompany implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;
    @Valid
    @NotNull
    private String companyName;

    @Valid
    private float rating;

    @Valid
    private String size;
}
