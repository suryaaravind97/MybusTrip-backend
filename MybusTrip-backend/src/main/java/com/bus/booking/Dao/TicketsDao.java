package com.bus.booking.Dao;

import com.bus.booking.models.Tickets;
import org.springframework.data.repository.CrudRepository;

public interface TicketsDao extends CrudRepository<Tickets, Integer> {
}
