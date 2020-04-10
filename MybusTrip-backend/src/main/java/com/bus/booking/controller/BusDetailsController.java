package com.bus.booking.controller;

import com.bus.booking.models.BusDetails;
import com.bus.booking.service.BusDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BusDetailsController {
    @Autowired
    private BusDetailsService busDetailsService;

    @RequestMapping(method = RequestMethod.POST, value = "/addbus")
    public ResponseEntity<?> addBusDetails(@RequestBody List<BusDetails> details){
        if(!details.isEmpty()){
            busDetailsService.addBusDetails(details);
            return new ResponseEntity<>("Data Saved", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Not Found Required Data", HttpStatus.NOT_FOUND);
        }
    }
}
