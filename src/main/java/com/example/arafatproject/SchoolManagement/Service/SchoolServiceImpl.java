package com.example.arafatproject.SchoolManagement.Service;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Admission;
import com.example.arafatproject.SchoolManagement.Domain.AdmissionCourse;
import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Repository.AdmissionCourseRepository;
import com.example.arafatproject.SchoolManagement.Repository.AdmissionRepository;
import com.example.arafatproject.SchoolManagement.Repository.SchoolRepository;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private AdmissionCourseRepository admissionCourseRepository;

    @Autowired
    private AdmissionRepository admissionRepository;

    @Override
    public School newschool(School school) {
        School school1 = new School(school.getName(), school.getDate_registered());
        return schoolRepository.save(school1);
    }

    @Override
    public List<School> getAllSchools(Pageable pageable) {
        return schoolRepository.findAll(pageable).getContent();
    }

    @Override
    public Admission newAdmission(Admission admission) {
        return admissionRepository.save(admission);
    }

    @Override
    public AdmissionCourse newAdmissionCourse(AdmissionCourse admissionCourse) {
        return admissionCourseRepository.save(admissionCourse);
    }

    @Override
    public List<Admission> getAdmissions(Pageable pageable) {
        return admissionRepository.findAll(pageable).getContent();
    }

    @Override
    public List<AdmissionCourse> getAdmissionCourses(Pageable pageable) {
        return admissionCourseRepository.findAll(pageable).getContent();
    }
}
