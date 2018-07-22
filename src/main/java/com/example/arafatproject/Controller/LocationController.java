package com.example.arafatproject.Controller;

import java.util.Date;

import com.example.arafatproject.domain.Location;
import com.example.arafatproject.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "location")
public class LocationController {
    @Autowired
    private LocationService locationService;


    @RequestMapping(value = "new", method = RequestMethod.GET)
    public Location save(@RequestParam String imei, @RequestParam Double lon, @RequestParam Double lat) {
        Location location = new Location(imei, lon, lat, new Date());
        return locationService.save(location);
    }

}
