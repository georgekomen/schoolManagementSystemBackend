package com.example.arafatproject.SchoolManagement.Controller;

import java.util.List;
import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.Region.Country;
import com.example.arafatproject.SchoolManagement.Domain.Region.County;
import com.example.arafatproject.SchoolManagement.Domain.Region.SubCounty;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.RegionService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.arafatproject.SchoolManagement.Domain.view;

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

    @RequestMapping(value = "new_subCounty", method = RequestMethod.POST)
    public SubCounty newSubCounty(@RequestBody SubCounty subCounty) {
        return regionService.newSubCounty(subCounty);
    }

    @JsonView(view.listView.class)
    @RequestMapping(value = "get_countries", method = RequestMethod.GET)
    public List<Country> getCounties() {
        return regionService.getCountries();
    }

    @JsonView(view.listView.class)
    @RequestMapping(value = "get_counties/{countryId}", method = RequestMethod.GET)
    public List<County> getCounties(@PathVariable("countryId")Country country) {
        return regionService.getCounties(country);
    }

    @JsonView(view.listView.class)
    @RequestMapping(value = "get_subCounties/{countyId}", method = RequestMethod.GET)
    public List<SubCounty> getSubCounties(@PathVariable("countyId")County county) {
        return regionService.getSubCounties(county);
    }

    @JsonView(view.upTreeView.class)
    @RequestMapping(value = "get_subCounty/{subCounty_id}", method = RequestMethod.GET)
    public Optional<SubCounty> getSubCounty(@PathVariable(value = "subCounty_id")Long subCountyId) {
        return regionService.getSubCounty(subCountyId);
    }


}
