package com.bus.booking.service;

import com.bus.booking.Dao.BusDetailsDao;
import com.bus.booking.models.BusDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusDetailsService {
    @Autowired
    private BusDetailsDao busdetailsdao;

    public void addBusDetails(List<BusDetails> details){
        busdetailsdao.saveAll(details);
    }
}
