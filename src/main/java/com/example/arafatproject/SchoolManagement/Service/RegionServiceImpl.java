package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;
import java.util.Optional;

import com.example.arafatproject.SchoolManagement.Domain.Region.Country;
import com.example.arafatproject.SchoolManagement.Domain.Region.County;
import com.example.arafatproject.SchoolManagement.Domain.Region.SubCounty;
import com.example.arafatproject.SchoolManagement.Repository.Region.CountryRepository;
import com.example.arafatproject.SchoolManagement.Repository.Region.CountyRepository;
import com.example.arafatproject.SchoolManagement.Repository.Region.SubcountyRepository;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountyRepository countyRepository;

    @Autowired
    private SubcountyRepository subcountyRepository;

    @Override
    public Country newCountry(Country country) {
        Country country1 = new Country(country.getName());
        return countryRepository.save(country1);
    }

    @Override
    public County newCounty(County county) {
        County county1 = new County(county.getName(), county.getCountry());
        return countyRepository.save(county1);
    }

    @Override
    public SubCounty newSubCounty(SubCounty subCounty) {
        SubCounty subCounty1 = new SubCounty(subCounty.getName(), subCounty.getCounty());
        return subcountyRepository.save(subCounty1);
    }

    @Override
    public Optional<SubCounty> getSubCounty(Long subcountyId) {
        return subcountyRepository.findById(subcountyId);
    }

    @Override
    public List<County> getCounties(Country country) {
        return countyRepository.findByCountry(country);
    }

    @Override
    public List<SubCounty> getSubCounties(County county) {
        return subcountyRepository.findByCounty(county);
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
