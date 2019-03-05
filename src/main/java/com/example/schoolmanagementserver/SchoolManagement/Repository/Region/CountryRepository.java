package com.example.schoolmanagementserver.SchoolManagement.Repository.Region;

import com.example.schoolmanagementserver.SchoolManagement.Domain.Region.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
