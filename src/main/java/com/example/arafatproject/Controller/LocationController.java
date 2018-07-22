package com.example.arafatproject.Controller;

import com.example.arafatproject.domain.Location;
import com.example.arafatproject.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "location")
public class LocationController {
    @Autowired
    private LocationService locationService;


    @RequestMapping(value = "new", method = RequestMethod.POST)
    public Location save(@RequestBody Location location) {
        return locationService.save(location);
    }

}
