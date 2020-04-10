package com.bus.booking.Dao;

import com.bus.booking.models.BusDetails;
import org.springframework.data.repository.CrudRepository;

public interface BusDetailsDao extends CrudRepository<BusDetails,Integer> {
}
