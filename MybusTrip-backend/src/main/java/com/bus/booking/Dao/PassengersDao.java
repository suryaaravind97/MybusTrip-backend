package com.bus.booking.Dao;

import com.bus.booking.models.Passengers;
import org.springframework.data.repository.CrudRepository;

public interface PassengersDao extends CrudRepository<Passengers,  Integer> {
}
