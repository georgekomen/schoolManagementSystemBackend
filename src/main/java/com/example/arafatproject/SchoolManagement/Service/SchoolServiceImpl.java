package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public School newschool(School school) {
        School school1 = new School(school.getName(), school.getDate_registered());
        return schoolRepository.save(school1);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }
}