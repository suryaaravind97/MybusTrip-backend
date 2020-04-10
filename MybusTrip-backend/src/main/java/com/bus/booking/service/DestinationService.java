package com.bus.booking.service;

import com.bus.booking.Dao.DestinationsDao;
import com.bus.booking.models.Destinations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {
    @Autowired
    private DestinationsDao destinationsDao;

    public void addCities(List<Destinations> cities) {
        destinationsDao.saveAll(cities);
    }

    public Optional<Destinations> getCity(int id) {
        return destinationsDao.findById(id);
    }

    public int getCityId(String destinationCity) {
        return destinationsDao.getCityId(destinationCity);
    }

    public int checkId(String destinationCity) {
        return destinationsDao.checkId(destinationCity);
    }

    public List<String> getAllCities(){
        return destinationsDao.getAllCities();
    }
}
