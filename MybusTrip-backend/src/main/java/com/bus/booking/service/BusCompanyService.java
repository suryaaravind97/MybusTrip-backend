package com.bus.booking.service;

import com.bus.booking.Dao.BusCompanyDao;
import com.bus.booking.models.Buscompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusCompanyService {
    @Autowired
    private BusCompanyDao buscompanydao;

    public void addCompanyDetails(List<Buscompany> data){
        buscompanydao.saveAll(data);
    }
    public Buscompany getCompanyDetails(String companyName){
        return buscompanydao.findByCompanyName(companyName);
    }
}
