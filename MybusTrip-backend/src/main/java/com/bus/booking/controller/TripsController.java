package com.bus.booking.controller;

import com.bus.booking.Dao.RoutesDao;
import com.bus.booking.models.Trips;
import com.bus.booking.service.DestinationService;
import com.bus.booking.service.RoutesService;
import com.bus.booking.service.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TripsController {
    @Autowired
    private TripsService tripService;
    @Autowired
    private RoutesService routeService;
    @Autowired
    private DestinationService destinationService;
    @Autowired
    private RoutesDao routeDao;

    @RequestMapping(method = RequestMethod.POST, value = "/addtrip")
    public ResponseEntity<?> addTrips(@RequestBody List<Trips> trips) {
        int counter = 0;
        for (Trips trip : trips) {
            if (routeDao.existsById(trip.getRoute().getRouteId())) {
                counter = counter + 1;
            }
        }
        if (counter == trips.size()) {
            tripService.addTrip(trips);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/trips")
    public ResponseEntity<?> getTripsByRouteId(@RequestParam String sourceCity, @RequestParam String destinationCity, @RequestParam String date) {
        if (destinationService.checkId(sourceCity) == 1 && destinationService.checkId(destinationCity) == 1) {
            int sourceId = destinationService.getCityId(sourceCity);
            int destinationId = destinationService.getCityId(destinationCity);
            if (sourceId != destinationId) {
                int routeId = routeService.getRouteId(sourceId, destinationId);
                return new ResponseEntity<>(tripService.getTripsByrouteId(routeId, date), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Bad request", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }

    }
}
