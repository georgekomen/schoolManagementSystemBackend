package com.example.arafatproject.SchoolManagement.Service.ServiceInterfaces;

import java.util.List;

import com.example.arafatproject.SchoolManagement.Domain.Course;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    Course newCourse(Course course);

    List<Course> getAllCourses(Pageable pageable);
}
