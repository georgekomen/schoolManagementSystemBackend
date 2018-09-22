package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Course;

public interface CourseService {
    Course newCourse(Course course);

    List<Course> getAllCourses();
}
