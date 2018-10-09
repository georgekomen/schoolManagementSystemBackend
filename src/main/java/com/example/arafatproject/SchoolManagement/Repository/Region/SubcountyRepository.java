package com.example.arafatproject.SchoolManagement.Repository.Region;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Region.County;
import com.example.arafatproject.SchoolManagement.Domain.Region.SubCounty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcountyRepository extends JpaRepository<SubCounty, Long> {
    @Query("select sc from SubCounty sc where sc.county = ?1")
    List<SubCounty> findByCounty(County county);
}
