package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Admission;
import com.example.arafatproject.SchoolManagement.Domain.AdmissionCourse;
import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Domain.School;
import org.springframework.data.domain.Pageable;

public interface SchoolService {
    School newschool(School school);

    List<School> getAllSchools(Pageable pageable);

    Admission newAdmission(Admission admission);

    AdmissionCourse newAdmissionCourse(AdmissionCourse admissionCourse);

    List<Admission> getAdmissions(Pageable pageable);

    List<AdmissionCourse> getAdmissionCourses(Pageable pageable);

    Course newCourse(Course course);

    List<Course> getAllCourses(Pageable pageable);
}
