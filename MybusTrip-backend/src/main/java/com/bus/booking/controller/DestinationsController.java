package com.bus.booking.controller;

import com.bus.booking.models.Destinations;
import com.bus.booking.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class DestinationsController {
    @Autowired
    private DestinationService destinationService;

    @RequestMapping(method = RequestMethod.POST, value = "/addcities")
    public ResponseEntity<?> addCities(@RequestBody List<Destinations> cities) {
        if (!cities.isEmpty()) {
            destinationService.addCities(cities);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getcity")
    public Optional<Destinations> getCity(@RequestParam int id) {
        return destinationService.getCity(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getcityid")
    public ResponseEntity<?> getCityId(@RequestParam String destinationCity) {
        if (destinationService.checkId(destinationCity) == 1) {
            return new ResponseEntity<>(destinationService.getCityId(destinationCity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found Data", HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(method = RequestMethod.GET, value = "/getallcities")
    public List<String> getAllCities(){
        return destinationService.getAllCities();
    }

}
