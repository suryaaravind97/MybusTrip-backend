package com.bus.booking.service;

import com.bus.booking.Dao.RoutesDao;
import com.bus.booking.models.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoutesService {
    @Autowired
    private RoutesDao routeDao;

    public void createRoutes(Routes routes) {
        routeDao.save(routes);
    }

    public int getRouteId(int sourceId, int destinationId) {
        return routeDao.getRouteId(sourceId, destinationId);
    }
}
