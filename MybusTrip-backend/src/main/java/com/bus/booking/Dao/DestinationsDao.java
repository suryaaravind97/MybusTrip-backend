package com.bus.booking.Dao;

import com.bus.booking.models.Destinations;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DestinationsDao extends CrudRepository<Destinations, Integer> {
    String query = "select d.destinationId from destinations d where d.destinationCity=?1";

    @Query(value = query, nativeQuery = true)
    int getCityId(String destinationCity);

    String countQuery = "select count(d.destinationId) from destinations d where d.destinationCity=?1";

    @Query(value = countQuery, nativeQuery = true)
    int checkId(String destinationCity);

    String getCityQuery = "select d.destinationCity from destinations d";

    @Query(value = getCityQuery, nativeQuery = true)
    List<String> getAllCities();
}
