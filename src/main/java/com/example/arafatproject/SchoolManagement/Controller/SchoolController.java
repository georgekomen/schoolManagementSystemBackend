package com.example.arafatproject.SchoolManagement.Controller;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Admission;
import com.example.arafatproject.SchoolManagement.Domain.AdmissionCourse;
import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Domain.School;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "new_school", method = RequestMethod.POST)
    public School newSchool(@RequestBody School school) {
        return schoolService.newschool(school);
    }

    @RequestMapping(value = "get_schools", method = RequestMethod.GET)
    public List<School> getSchools(Pageable pageable) {
        return schoolService.getAllSchools(pageable);
    }

    @RequestMapping(value = "new_admission", method = RequestMethod.POST)
    public Admission newAdmission(@RequestBody Admission admission) {
        return schoolService.newAdmission(admission);
    }

    @RequestMapping(value = "new_admission_course", method = RequestMethod.POST)
    public AdmissionCourse newAdmission(@RequestBody AdmissionCourse admissionCourse) {
        return schoolService.newAdmissionCourse(admissionCourse);
    }

    @RequestMapping(value = "get_admissions", method = RequestMethod.GET)
    public List<Admission> getAdmissions(Pageable pageable) {
        return schoolService.getAdmissions(pageable);
    }

    @RequestMapping(value = "get_admissions_courses", method = RequestMethod.GET)
    public List<AdmissionCourse> getAdmissionCourses(Pageable pageable) {
        return schoolService.getAdmissionCourses(pageable);
    }

    @RequestMapping(value = "new_course", method = RequestMethod.POST)
    public Course newCourse(@RequestBody Course course) {
        return schoolService.newCourse(course);
    }

    @RequestMapping(value = "get_courses", method = RequestMethod.GET)
    public List<Course> getAllCourses(Pageable pageable) {
        return schoolService.getAllCourses(pageable);
    }
}
