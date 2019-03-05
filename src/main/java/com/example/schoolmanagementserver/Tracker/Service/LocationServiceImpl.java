package com.example.schoolmanagementserver.Tracker.Service;

import java.util.Date;

import com.example.schoolmanagementserver.Tracker.Domain.Location;
import com.example.schoolmanagementserver.Tracker.Repository.LocationRepository;
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
