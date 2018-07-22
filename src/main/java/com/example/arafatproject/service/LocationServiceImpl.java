package com.example.arafatproject.service;

import java.util.Date;

import com.example.arafatproject.domain.Location;
import com.example.arafatproject.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location save(Location location) {
        location.setDateTime(new Date());
        return locationRepository.save(location);
    }
}
