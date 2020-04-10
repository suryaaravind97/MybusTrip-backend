package com.bus.booking.controller;

import com.bus.booking.models.Buscompany;
import com.bus.booking.service.BusCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BusCompanyController {
    @Autowired
    private BusCompanyService busCompanyService;

    @RequestMapping(method = RequestMethod.POST, value = "/addcompany")
    public ResponseEntity<?> addCompanyDetails(@RequestBody List<Buscompany> data) {
        if (!data.isEmpty()) {
            busCompanyService.addCompanyDetails(data);
            return new ResponseEntity<>("Data added", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Data Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getcompany")
    public ResponseEntity<?> getCompanyDetails(@RequestParam String companyName) {
        if (!companyName.isEmpty()) {
            Buscompany companyDetails = busCompanyService.getCompanyDetails(companyName);
            if (companyDetails != null) {
                return new ResponseEntity<>(companyDetails, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("CompanyName does not exist", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
        }
    }
}
