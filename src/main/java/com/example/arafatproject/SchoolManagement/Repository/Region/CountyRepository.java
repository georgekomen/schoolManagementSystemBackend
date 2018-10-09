package com.example.arafatproject.SchoolManagement.Repository.Region;

import com.example.arafatproject.SchoolManagement.Domain.Region.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {
}
