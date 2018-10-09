package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import com.example.arafatproject.SchoolManagement.Domain.Region.Country;
import com.example.arafatproject.SchoolManagement.Domain.Region.County;
import com.example.arafatproject.SchoolManagement.Domain.Region.Subcounty;

public interface RegionService {
    Country newCountry(Country country);

    County newCounty(County county);

    Subcounty newSubCounty(Subcounty subcounty);
}
