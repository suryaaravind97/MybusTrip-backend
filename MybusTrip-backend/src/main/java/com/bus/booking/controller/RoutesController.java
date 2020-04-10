package com.bus.booking.controller;

import com.bus.booking.Dao.DestinationsDao;
import com.bus.booking.models.Destinations;
import com.bus.booking.models.Routes;
import com.bus.booking.service.DestinationService;
import com.bus.booking.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class RoutesController {
    @Autowired
    private RoutesService routeService;
    @Autowired
    private DestinationService destinationService;
    @Autowired
    private DestinationsDao destinationDao;

    @RequestMapping(method = RequestMethod.POST, value = "/addroute")
    public ResponseEntity<?> addRoutes(@RequestBody Routes routes, @RequestParam int sourceId, @RequestParam int destinationId) {
        if (destinationDao.existsById(sourceId) && destinationDao.existsById(destinationId)) {
            routes.setSource(new Destinations(sourceId));
            routes.setDestination(new Destinations(destinationId));
            routeService.createRoutes(routes);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getrouteid")
    public ResponseEntity<?> getRouteId(@RequestParam String sourceCity, @RequestParam String destinationCity) {
        if (destinationService.checkId(sourceCity) == 1 && destinationService.checkId(destinationCity) == 1) {
            int sourceId = destinationService.getCityId(sourceCity);
            int destinationId = destinationService.getCityId(destinationCity);
            return new ResponseEntity<>(routeService.getRouteId(sourceId, destinationId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }

    }
}
