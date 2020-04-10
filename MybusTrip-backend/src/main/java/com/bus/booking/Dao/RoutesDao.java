package com.bus.booking.Dao;

import com.bus.booking.models.Routes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoutesDao extends CrudRepository<Routes, Integer> {
    String query = "select route.routeId from routes route inner join destinations source on route.sourceId=?1 inner join destinations destination on route.destinationId=?2";

    @Query(value = query, nativeQuery = true)
    int getRouteId(int sourceId, int destinationId);
}
