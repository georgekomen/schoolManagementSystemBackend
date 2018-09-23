package com.example.arafatproject.SchoolManagement.Controller;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "new_course", method = RequestMethod.POST)
    public Course newCourse(@RequestBody Course course) {
        return courseService.newCourse(course);
    }

    @RequestMapping(value = "get_courses", method = RequestMethod.GET)
    public List<Course> getAllCourses(Pageable pageable) {
        return courseService.getAllCourses(pageable);
    }

}
