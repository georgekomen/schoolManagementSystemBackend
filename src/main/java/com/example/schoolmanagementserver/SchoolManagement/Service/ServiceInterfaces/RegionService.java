package com.example.schoolmanagementserver.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;
import java.util.Optional;

import com.example.schoolmanagementserver.SchoolManagement.Domain.Region.Country;
import com.example.schoolmanagementserver.SchoolManagement.Domain.Region.County;
import com.example.schoolmanagementserver.SchoolManagement.Domain.Region.SubCounty;

public interface RegionService {
    Country newCountry(Country country);

    County newCounty(County county);

    SubCounty newSubCounty(SubCounty subCounty);

    Optional<SubCounty> getSubCounty(Long subcountyId);

    List<County> getCounties(Country country);

    List<SubCounty> getSubCounties(County subcounty);

    List<Country> getCountries();
}
