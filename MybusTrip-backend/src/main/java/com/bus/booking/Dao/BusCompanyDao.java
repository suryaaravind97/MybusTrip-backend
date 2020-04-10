package com.bus.booking.Dao;

import com.bus.booking.models.Buscompany;
import org.springframework.data.repository.CrudRepository;

public interface BusCompanyDao extends CrudRepository<Buscompany, Integer> {
    public Buscompany findByCompanyName(String companyName);
}
