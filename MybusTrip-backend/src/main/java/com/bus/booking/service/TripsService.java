package com.bus.booking.service;

import com.bus.booking.Dao.TripsDao;
import com.bus.booking.models.Trips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripsService {
    @Autowired
    private TripsDao tripdao;

    public void addTrip(List<Trips> trips){
        tripdao.saveAll(trips);
    }
    public List<Trips> getTripsByrouteId(int routeId,String date){
        return tripdao.findByrouteId(routeId,date);
    }
}
