package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.School;
import org.springframework.data.domain.Pageable;

public interface SchoolService {
    School newschool(School school);

    List<School> getAllSchools(Pageable pageable);
}
