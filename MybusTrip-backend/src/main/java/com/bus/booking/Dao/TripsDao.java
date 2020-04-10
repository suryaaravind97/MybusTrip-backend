package com.bus.booking.Dao;

import com.bus.booking.models.Trips;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TripsDao extends CrudRepository<Trips, Integer> {
    String query = "select * from trips t where t.routeId=?1 and t.departureDate=?2";

    @Query(value = query, nativeQuery = true)
    List<Trips> findByrouteId(int routeId, String date);
}
