package com.example.arafatproject.SchoolManagement.Controller;

import com.example.arafatproject.SchoolManagement.Domain.Region.Country;
import com.example.arafatproject.SchoolManagement.Domain.Region.County;
import com.example.arafatproject.SchoolManagement.Domain.Region.Subcounty;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @RequestMapping(value = "new_country", method = RequestMethod.POST)
    public Country newCountry(@RequestBody Country country) {
        return regionService.newCountry(country);
    }

    @RequestMapping(value = "new_county", method = RequestMethod.POST)
    public County newCounty(@RequestBody County county) {
        return regionService.newCounty(county);
    }

    @RequestMapping(value = "new_subcounty", method = RequestMethod.POST)
    public Subcounty newSubCounty(@RequestBody Subcounty subcounty) {
        return regionService.newSubCounty(subcounty);
    }


}
