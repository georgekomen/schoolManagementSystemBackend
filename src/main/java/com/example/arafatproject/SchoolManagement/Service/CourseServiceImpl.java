package com.example.arafatproject.SchoolManagement.Service;

import com.example.arafatproject.SchoolManagement.Domain.Course;
import com.example.arafatproject.SchoolManagement.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course newCourse(Course course) {
        Course course1 = new Course(course.getName(), course.getSchool());
        return courseRepository.save(course1);
    }
}
