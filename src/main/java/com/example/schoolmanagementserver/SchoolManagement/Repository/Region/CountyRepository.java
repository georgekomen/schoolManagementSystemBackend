package com.example.schoolmanagementserver.SchoolManagement.Repository.Region;

import java.util.List;

import com.example.schoolmanagementserver.SchoolManagement.Domain.Region.Country;
import com.example.schoolmanagementserver.SchoolManagement.Domain.Region.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {
    @Query("select cu from County cu where cu.country = ?1")
    List<County> findByCountry(Country country);
}
