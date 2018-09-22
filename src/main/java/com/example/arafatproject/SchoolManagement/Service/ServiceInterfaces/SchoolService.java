package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.School;

public interface SchoolService {
    School newschool(School school);

    List<School> getAllSchools();
}
